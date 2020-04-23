//package p1;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
class Vendor extends JFrame implements ActionListener
{
	JInternalFrame iFrameVendor = new JInternalFrame("Add New Vendor Item",true,true,true,true);
	
	Connection con;
        Statement stmt;
        ResultSet rs;
	LayoutManager lm = null;
	
	

	JTextField Vendor_Name = new JTextField(255);
	JTextField Contact_Person = new JTextField(100);
	JTextField Phone = new JTextField(20);
	JTextField Fax = new JTextField(20);
	JTextField Mobile = new JTextField(20);
	JTextField email = new JTextField(10);
	JTextField Cargo_Name = new JTextField(10);
	JTextField Remark = new JTextField(255);
	JTextField Date_In = new JTextField(10);

	JButton submit = new JButton("Submit");

	public Vendor()
	{
	}			
	public JInternalFrame VendorFrame(JDesktopPane desktop)
	{
		iFrameVendor.setLayout(lm);
		
		iFrameVendor.setLocation(25,25);
		
		iFrameVendor.setSize(600,440);
		Border border = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		iFrameVendor.setBorder(border);

		JLabel l_Vendor_Id =new JLabel("                           Vendor's Information");
		Font labelFont = new Font("Arial", Font.BOLD, 20);
		l_Vendor_Id.setFont(labelFont);
		//l_Vendor_Id.setColor(Color BLUE);
		l_Vendor_Id.setBounds(20,20,500,20);
		iFrameVendor.add(l_Vendor_Id);
		
		
		JLabel l_Vendor_Name =new JLabel("       Vendor Name :");
		l_Vendor_Name.setBounds(50,60,120,20);
		iFrameVendor.add(l_Vendor_Name);
			
		
		Vendor_Name.setBounds(170,60,100,20);
		iFrameVendor.add(Vendor_Name);
		
		JLabel l_Date_In =new JLabel("          Date of Inlet :");
		l_Date_In.setBounds(50,90,120,20);
		iFrameVendor.add(l_Date_In);
		
		
		Date_In.setBounds(170,90,80,20);
		iFrameVendor.add(Date_In);
		
		JLabel l_inc_date =new JLabel("dd / mm / yyyy");
		l_inc_date.setBounds(270,90,100,20);
		iFrameVendor.add(l_inc_date);

		
	 
		JLabel l_Contact_Person =new JLabel("   Contact Person :");
		l_Contact_Person.setBounds(50,120,120,20);
		iFrameVendor.add(l_Contact_Person);
		
		
		Contact_Person.setBounds(170,120,160,20);
		iFrameVendor.add(Contact_Person);

	 
		JLabel l_Phone =new JLabel("                    Phone :");
		l_Phone.setBounds(50,150,150,20);
		iFrameVendor.add(l_Phone);
		
		Phone.setBounds(170,150,80,20);
		iFrameVendor.add(Phone);
		
		JLabel l_Fax =new JLabel("    Fax :");
		l_Fax.setBounds(340,150,120,20);
		iFrameVendor.add(l_Fax);	
	
		Fax.setBounds(420,150,120,20);
		iFrameVendor.add(Fax);	
	
		
		JLabel l_Mobile =new JLabel("             Mobile No. :");
		l_Mobile.setBounds(50,180,120,20);
		iFrameVendor.add(l_Mobile);
		
		
		Mobile.setBounds(170,180,160,20);
		iFrameVendor.add(Mobile);

		
		JLabel l_email = new JLabel("                      email :");
		l_email.setBounds(50,210,120,20);
		iFrameVendor.add(l_email);
		
		
		email.setBounds(170,210,80,20);
		iFrameVendor.add(email);
		
		  
		JLabel l_Cargo_Name =new JLabel("                   Cargo Name :");
		l_Cargo_Name.setBounds(20,240,150,20);
		iFrameVendor.add(l_Cargo_Name);
		
		
		Cargo_Name.setBounds(170,240,120,20);
		iFrameVendor.add(Cargo_Name);
		
		
		
		JLabel l_Remark =new JLabel("               Remarks :");
		l_Remark.setBounds(50,270,120,20);
		iFrameVendor.add(l_Remark);
		
		Remark.setBounds(170,270,170,60);
		iFrameVendor.add(Remark);

		
		Border border12 = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		submit.setBounds(200,350,140,30);
		iFrameVendor.add(submit);
		submit.setBorder(border12);
		submit.addActionListener(this);
	
		
		desktop.add(iFrameVendor);
		return(iFrameVendor);
		//iFrameVendor.show();
		
	}
	public void actionPerformed(ActionEvent e)
        {
                String sVendor_Name = Vendor_Name.getText();
                String sContact_Person = Contact_Person.getText();
               	String sPhone = Phone.getText();
                String sFax = Fax.getText();
       	        String sMobile = Mobile.getText();
               	String semail = email.getText();
                String sCargo_Name = Cargo_Name.getText();
       	        String sRemark = Remark.getText();
		String sDate_In = Date_In.getText();
		
                String query =" INSERT INTO Vendor (Vendor_name,Contact_Person,Phone,Fax,Mobile,email,Cargo_Name,Remark,Date_In) VALUES ('"+sVendor_Name+"','"+sContact_Person+"','"+sPhone+"','"+sFax+"','"+sMobile+"','"+semail+"','"+sCargo_Name+"','"+sRemark+"','"+sDate_In+"')";

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
		iFrameVendor.setVisible(false);
		//Addenq1 p = new Addenq1();		
	}
}