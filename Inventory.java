//package p1;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
class Inventory extends JFrame implements ActionListener
{
	JInternalFrame iFrameInventory = new JInternalFrame("Add New Inventory Item",true,true,true,true);
	
	Connection con;
        Statement stmt;
        ResultSet rs;
	LayoutManager lm = null;
	
	

	JTextField style_id = new JTextField(10);
	JTextField in_date = new JTextField(10);
	JTextField Vendor_id = new JTextField(20);
	JTextField stone_type = new JTextField(100);
	JTextField stone_wt = new JTextField(10);
	JTextField stone_number = new JTextField(100);
	JTextField gold_cr = new JTextField(10);
	JTextField gold_wt = new JTextField(20);
	JTextField details = new JTextField(100);
	
	JButton submit = new JButton("Submit");

	public Inventory()
	{
	}			
	public JInternalFrame InventoryFrame(JDesktopPane desktop)
	{
		iFrameInventory.setLayout(lm);
		
		iFrameInventory.setLocation(25,25);
		
		iFrameInventory.setSize(600,440);
		Border border = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		iFrameInventory.setBorder(border);

		JLabel l_Inventory_Id_Title =new JLabel("                           Inventory Information");
		Font labelFont = new Font("Arial", Font.BOLD, 20);
		l_Inventory_Id_Title.setFont(labelFont);
		//l_Inventory_Id_Title.setColor(Color.BLUE);
		l_Inventory_Id_Title.setBounds(20,20,500,20);
		iFrameInventory.add(l_Inventory_Id_Title);
		
	
		JLabel l_style_id =new JLabel("                    Style ID :");
		l_style_id.setBounds(50,60,120,20);
		iFrameInventory.add(l_style_id);
			
		
		style_id.setBounds(170,60,100,20);
		iFrameInventory.add(style_id);
		
		JLabel l_in_date =new JLabel("           Date of Inlet :");
		l_in_date.setBounds(50,90,120,20);
		iFrameInventory.add(l_in_date);
		
		
		in_date.setBounds(170,90,80,20);
		iFrameInventory.add(in_date);
		
		JLabel l_inc_date =new JLabel("dd / mm / yyyy");
		l_inc_date.setBounds(270,90,100,20);
		iFrameInventory.add(l_inc_date);

		
	 
		JLabel l_Vendor_id =new JLabel("               Vendor ID :");
		l_Vendor_id.setBounds(50,120,120,20);
		iFrameInventory.add(l_Vendor_id);
		
		
		Vendor_id.setBounds(170,120,160,20);
		iFrameInventory.add(Vendor_id);

	
		JLabel l_stone_wt =new JLabel("       Stone Wt(in Carat)  :");
		l_stone_wt.setBounds(20,150,150,20);
		iFrameInventory.add(l_stone_wt);
		
		stone_wt.setBounds(170,150,80,20);
		iFrameInventory.add(stone_wt);
		
		JLabel l_stone_type =new JLabel("Stone Type :");
		l_stone_type.setBounds(340,150,120,20);
		iFrameInventory.add(l_stone_type);	
	
		stone_type.setBounds(420,150,120,20);
		iFrameInventory.add(stone_type);	
		

		

		
		JLabel l_stone_number =new JLabel(" Numbers of Stones:");
		l_stone_number.setBounds(40,180,120,20);
		iFrameInventory.add(l_stone_number);
		
		
		stone_number.setBounds(170,180,160,20);
		iFrameInventory.add(stone_number);

		
		JLabel l_gold_wt = new JLabel("    Gold Wt(in gms):");
		l_gold_wt.setBounds(50,210,120,20);
		iFrameInventory.add(l_gold_wt);
		
		
		gold_wt.setBounds(170,210,80,20);
		iFrameInventory.add(gold_wt);
		
		
		JLabel l_gold_cr =new JLabel("   Gold Purity(in Carats) :");
		l_gold_cr.setBounds(20,240,150,20);
		iFrameInventory.add(l_gold_cr);
		
		
		gold_cr.setBounds(170,240,120,20);
		iFrameInventory.add(gold_cr);
		
		
		
		JLabel l_details =new JLabel("                    Details :");
		l_details.setBounds(50,270,120,20);
		iFrameInventory.add(l_details);
		
		details.setBounds(170,270,170,60);
		iFrameInventory.add(details);

		
		Border border12 = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		submit.setBounds(200,350,140,30);
		iFrameInventory.add(submit);
		submit.setBorder(border12);
		submit.addActionListener(this);
	
		
		desktop.add(iFrameInventory);
		return(iFrameInventory);
		//iFrameInventory.show();
		
	}
	public void actionPerformed(ActionEvent e)
        {
               	iFrameInventory.setVisible(false);;
		String sstyle_id= style_id.getText();
       	        String sVendor_id = Vendor_id.getText();
               	String sin_date = in_date.getText();
                String sgold_cr = gold_cr.getText();
       	        String sgold_wt = gold_wt.getText();
               	String sstone_type = stone_type.getText();
                String sstone_wt = stone_wt.getText();
                String sstone_number = stone_number.getText();
       	        String sdetails = details.getText();

	 	String query =" INSERT INTO Inventory(Style_ID,Vendor_ID,In_Date,Gold,Gold_wt,Stone_Type,Stone_Weight,Stone_numbers,Details) VALUES ('"+sstyle_id+"','"+sVendor_id+"','"+sin_date+"','"+sgold_cr+"','"+sgold_wt+"','"+sstone_type+"','"+sstone_wt+"','"+sstone_number+"','"+sdetails+"')";
                //System.out.println("Query ="+query);
		try
	        {
        		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        con = DriverManager.getConnection("jdbc:odbc:JMS");
			stmt = con.createStatement();
			int result = stmt.executeUpdate ( query );
		}
		catch(Exception ae)
              	{
              		ae.printStackTrace();
	        }
		
		
		//Addenq1 p = new Addenq1();		
	}
}