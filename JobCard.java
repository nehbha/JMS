import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
class JobCard extends JFrame implements ActionListener
{
	JInternalFrame iFrameJobCard = new JInternalFrame("Add New JobCard Item",true,true,true,true);
	
	Connection con;
        Statement stmt;
        ResultSet rs;
	LayoutManager lm = null;
	
	

	JTextField Customer_Id = new JTextField(10);
	JTextField Style_Id = new JTextField(10);
	JTextField Order_Date = new JTextField(10);
	JTextField Due_Date = new JTextField(10);
	JTextField E_Cost = new JTextField(20);	
	JTextField Remark = new JTextField(255);
	JTextField Amount_Pay = new JTextField(20);
	JTextField SalesMan = new JTextField(10);
	
	String Status_list[] = { 
					"1", "2", "3", "4", "5"
			  };
	JComboBox Status = new JComboBox(Status_list);
	
	String com = "1";

	JButton submit = new JButton("Submit");

	public JobCard()
	{
	}			
	public JInternalFrame JobCardFrame(JDesktopPane desktop)
	{
		iFrameJobCard.setLayout(lm);
		
		iFrameJobCard.setLocation(25,25);
		
		iFrameJobCard.setSize(600,400);
		Border border = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		iFrameJobCard.setBorder(border);

		JLabel l_JobCard_Id =new JLabel("                           JobCard's Information");
		Font labelFont = new Font("Arial", Font.BOLD, 20);
		l_JobCard_Id.setFont(labelFont);
		//l_JobCard_Id.setColor(Color BLUE);
		l_JobCard_Id.setBounds(20,20,500,20);
		iFrameJobCard.add(l_JobCard_Id);
		
		
		JLabel l_Customer_Id =new JLabel("           Customer ID :");
		l_Customer_Id.setBounds(50,60,120,20); 
		iFrameJobCard.add(l_Customer_Id);
			
		
		Customer_Id.setBounds(170,60,60,20);
		iFrameJobCard.add(Customer_Id);
		
		JLabel l_Style_Id =new JLabel("                    Style ID :");
		l_Style_Id.setBounds(50,90,120,20);
		iFrameJobCard.add(l_Style_Id);
		
		
		Style_Id.setBounds(170,90,80,20);
		iFrameJobCard.add(Style_Id);
		
		JLabel l_Order_Date =new JLabel("             Order Date :");
		l_Order_Date.setBounds(50,120,120,20); 
		iFrameJobCard.add(l_Order_Date);
		
		
		Order_Date.setBounds(170,120,80,20);
		iFrameJobCard.add(Order_Date);
		
		JLabel l_inc_date =new JLabel("dd / mm / yyyy");
		l_inc_date.setBounds(270,120,100,20);
		iFrameJobCard.add(l_inc_date);

	 
		JLabel l_Due_Date =new JLabel("           Due Delivery Date :");
		l_Due_Date.setBounds(20,150,150,20);
		iFrameJobCard.add(l_Due_Date);
		
		Due_Date.setBounds(170,150,80,20);
		iFrameJobCard.add(Due_Date);

		JLabel l_inc_date1 =new JLabel("dd / mm / yyyy");
		l_inc_date1.setBounds(270,150,100,20);
		iFrameJobCard.add(l_inc_date1);
		
		JLabel l_Current_Status =new JLabel("   Current Status :");
		l_Current_Status.setBounds(300,60,120,20);
		iFrameJobCard.add(l_Current_Status);
		
		Status.setMaximumRowCount(5);
		Status.setBounds(440,60,120,20);
		Status.addItemListener(new ItemListener()
					{
						public void itemStateChanged(ItemEvent a)
						{
							com = Status_list[Status.getSelectedIndex()];
						}
					});
		iFrameJobCard.add(Status);
		

		JLabel l_E_Cost =new JLabel("         Estimated Cost :");
		l_E_Cost.setBounds(40,180,120,20);
		iFrameJobCard.add(l_E_Cost);
		
		
		E_Cost.setBounds(170,180,80,20);
		iFrameJobCard.add(E_Cost);

		
		JLabel l_Amount_Pay = new JLabel("            Advance Amount :");
		l_Amount_Pay.setBounds(20,210,170,20);
		iFrameJobCard.add(l_Amount_Pay);
		
		
		Amount_Pay.setBounds(170,210,80,20);
		iFrameJobCard.add(Amount_Pay);
		
		    
		JLabel l_SalesMan =new JLabel("             SalesMan Name :");
		l_SalesMan.setBounds(20,240,150,20);
		iFrameJobCard.add(l_SalesMan);
		
		
		SalesMan.setBounds(170,240,120,20);
		iFrameJobCard.add(SalesMan);
		
		
		
		JLabel l_Remark =new JLabel("                Remarks :");
		l_Remark.setBounds(50,270,120,20);
		iFrameJobCard.add(l_Remark);
		
		Remark.setBounds(170,270,270,20);
		iFrameJobCard.add(Remark);

		
		Border border12 = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		submit.setBounds(200,315,140,30);
		iFrameJobCard.add(submit);
		submit.setBorder(border12);
		submit.addActionListener(this);
	
		
		desktop.add(iFrameJobCard);
		return(iFrameJobCard);
		//iFrameJobCard.show();
		
	}
	public void actionPerformed(ActionEvent e)
        {
               
		String sCustomer_Id = Customer_Id.getText();
                String sStyle_Id= Style_Id.getText();
       	        String sOrder_Date = Order_Date.getText();
               	String sDue_Date = Due_Date.getText();
                String sE_Cost = E_Cost.getText();
       	        String sRemark = Remark.getText();
               	String sAmount_Pay = Amount_Pay.getText();
                String sSalesMan = SalesMan.getText();
       	        //String sStatus = com.getText();
                String query =" INSERT INTO Job_Card(Customer_ID,Style_ID,Order_Date,Due_Date,Estimated_Cost,Remarks,Amount_Advance,Salesman,Current_Status) VALUES ('"+sCustomer_Id+"','"+sStyle_Id+"','"+sOrder_Date+"','"+sDue_Date+"','"+sE_Cost+"','"+sRemark+"','"+sAmount_Pay+"','"+sSalesMan+"','"+com+"')";

		try
	        {
        		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        con = DriverManager.getConnection("jdbc:odbc:JMS1");
			stmt = con.createStatement();
			int result = stmt.executeUpdate ( query );
		}
		catch(Exception ae)
              	{
              		ae.printStackTrace();
	        }
		
		iFrameJobCard.setVisible(false);
		//Addenq1 p = new Addenq1();		
	}
}