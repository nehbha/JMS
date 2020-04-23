import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;
class JobCardView extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JInternalFrame ViewBill = new JInternalFrame("View all Job Card Details",true,true,true,true);

	public JTable table;
	Connection con;
        Statement stmt;
        ResultSet rs;
	LayoutManager lm = null;
	String com = new String("Job_Card_ID");
	String com1;
	String filds[] = {
					"Job_Card_ID", "Style_ID", "Details", "Vendor_Name","Vendor_ID", "In_Date", "Gold", "Gold_wt", "Stone_Type","Stone_Weight", "Stone_numbers", "Stone_Wt", "Stone_Name", "Current_status"
				 }; 
	JComboBox oList = new JComboBox(filds);
	
	JLabel enq = new JLabel("Search From Existing Records By  :");
	JTextField tf = new JTextField(50);
	JButton find = new JButton("Find");
	public JobCardView()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:JMS");
		}
		catch(Exception ae)
		{
			System.out.println("NO CONNECTION");
			ae.printStackTrace();
		}
	}		
	public JInternalFrame JobCardViewFrame(JDesktopPane desktop)
	{
		ViewBill.setLayout(lm);
		ViewBill.setSize(1000,500);
		
				
		enq.setBounds(50,30,200,20);
		ViewBill.add(enq);
		

		oList.setMaximumRowCount(12);
		oList.setBounds(270,30,100,20);
		oList.addItemListener(new ItemListener()
					{
						public void itemStateChanged(ItemEvent a)
						{
							com = filds[oList.getSelectedIndex()];
						}
					});
		ViewBill.add(oList);

		
		tf.setBounds(400,30,100,20);
		ViewBill.add(tf);
		
		
		find.setBounds(550,30,80,20);
		find.addActionListener(this);
		ViewBill.add(find);
	
		ViewBill.setVisible(true);		
		desktop.add(ViewBill);
		ViewBill.show();
		return(ViewBill);
		
	}
	public void actionPerformed(ActionEvent e)
	{	//setVisible(false);
		String str = tf.getText();	
		
		String query;
		String str1=null;
				
		
		if(!str.equals(""))
		{
			if(com.equals("Job_Card_ID"))
			{
				int inventstr = Integer.parseInt(str);
				query = "SELECT * FROM Job_Card E WHERE E."+com+" = "+inventstr;
			}	
			else	
	 		{
				str1 = "'"+str+"'";
				query = "SELECT * FROM Job_Card E WHERE E."+com+" = "+str1;
			}
			
		}	
		else
		{
			query = "SELECT * FROM Job_Card";
		}
		System.out.println(str1);
		try{
			stmt = con.createStatement();
			System.out.println(query);
			rs = stmt.executeQuery(query);
			displayResultSet(rs);
			stmt.close();
		}
		catch(SQLException sqlx)
		{
			sqlx.printStackTrace();
		}
		
	}
	public void displayResultSet(ResultSet rs1)throws SQLException
	{
		boolean moreRecords = rs1.next();
		if(!moreRecords)
		{
			JOptionPane.showMessageDialog(this,"No Record is Kept here.");
			ViewBill.setTitle("No Record to Display");
			return;
		}
		
		ViewBill.setTitle("Details Enquired are....");
		Vector col = new Vector();
		Vector row = new Vector();
		
		try
		{
			ResultSetMetaData rsmd = rs1.getMetaData();
			
			for(int i = 1;i<=rsmd.getColumnCount();++i)
				col.addElement(rsmd.getColumnName(i));
			
			do
			{
				row.addElement(getNextRow(rs1,rsmd));	
			}while(rs1.next());
			
			table = new JTable(row,col);
			JScrollPane scroller = new JScrollPane(table);
			//System.out.println(table);
			scroller.setBounds(10,60,1200,500);
			ViewBill.add(scroller);
			ViewBill.setVisible(true);
			//ViewBill.setSize(400,400);
			ViewBill.validate();
		}
		catch(SQLException sqlx)
		{
			sqlx.printStackTrace();
			
		}
	}	
	private Vector getNextRow(ResultSet rs2,ResultSetMetaData rsmd)throws SQLException
	{
		Vector currentRow = new Vector();
		
		for(int i = 1;i<=rsmd.getColumnCount();++i)
			switch(rsmd.getColumnType(i))
			{
				case Types.VARCHAR:System.out.println(i);
					currentRow.addElement(rs2.getString(i));
					break;
				case Types.INTEGER:
					currentRow.addElement(new Long(rs2.getLong(i)));
					break;
				default:
					System.out.println("type was"+rsmd.getColumnTypeName(i));
			}
		return currentRow;
	}
}