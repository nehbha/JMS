import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
class Customer extends JFrame implements ActionListener
{
	JInternalFrame iFrameCustomer = new JInternalFrame("Add New Customer Item",true,true,true,true);
	
	Connection con;
        Statement stmt;
        ResultSet rs;
	LayoutManager lm = null;
	
	

	JTextField Customer_Id = new JTextField(10);
	JTextField Date_In = new JTextField(10);
	JTextField Customer_Name = new JTextField(10);
	JTextField Address = new JTextField(255);
	JTextField Phone = new JTextField(10);
	JTextField Wedding_Aniv = new JTextField(10);
	JTextField Birthday = new JTextField(10);
	JTextField Ring_Husband = new JTextField(10);
	JTextField Ring_Wife = new JTextField(10);
	JTextField Ring_Other = new JTextField(12);	
	JTextField Visits = new JTextField(12);
	JTextField credit = new JTextField(12);
	JTextField Style_Id = new JTextField(255);
	JTextField Remark = new JTextField(255);
	
	JButton submit = new JButton("Submit");

	public Customer()
	{
	}			
	public JInternalFrame CustomerFrame(JDesktopPane desktop)
	{
		iFrameCustomer.setLayout(lm);
		
		iFrameCustomer.setLocation(25,25);
		
		iFrameCustomer.setSize(700,400);
		Border border = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		iFrameCustomer.setBorder(border);

		JLabel l_Customer_Id_Title =new JLabel("                           Customer's Information");
		Font labelFont = new Font("Arial", Font.BOLD, 20);
		l_Customer_Id_Title.setFont(labelFont);
		//l_Customer_Id.setColor(Color BLUE);
		l_Customer_Id_Title.setBounds(20,20,500,20);
		iFrameCustomer.add(l_Customer_Id_Title);
		
		
		JLabel l_Customer_Id =new JLabel("           Customer ID :");
		l_Customer_Id.setBounds(50,60,120,20); 
		iFrameCustomer.add(l_Customer_Id);
			
		
		Customer_Id.setBounds(170,60,60,20);
		iFrameCustomer.add(Customer_Id);
		Customer_Id.setText("Don't Fill");
		
		
		JLabel l_Date_In =new JLabel("           Date In :");
		l_Date_In.setBounds(350,60,120,20);
		iFrameCustomer.add(l_Date_In);
		
		
		Date_In.setBounds(440,60,80,20);
		iFrameCustomer.add(Date_In);
		
		JLabel l_inc_date1 =new JLabel("dd / mm / yyyy");
		l_inc_date1.setBounds(520,60,100,20);
		iFrameCustomer.add(l_inc_date1);
		
		JLabel l_Customer_Name =new JLabel("   Customer Name :");
		l_Customer_Name.setBounds(50,90,120,20); 
		iFrameCustomer.add(l_Customer_Name);
		
		
		Customer_Name.setBounds(170,90,200,20);
		iFrameCustomer.add(Customer_Name);
		
			 
		JLabel l_Address =new JLabel("                  Address :");
		l_Address.setBounds(50,120,120,20);
		iFrameCustomer.add(l_Address);
		
		Address.setBounds(170,120,350,20);
		iFrameCustomer.add(Address);

		JLabel l_Phone =new JLabel("            Phone :");
		l_Phone.setBounds(350,90,150,20);
		iFrameCustomer.add(l_Phone);
		
		
		Phone.setBounds(440,90,130,20);
		iFrameCustomer.add(Phone);

		
		JLabel l_Wedding_Aniv = new JLabel("      Wedding Aniversary :");
		l_Wedding_Aniv.setBounds(20,150,150,20);
		iFrameCustomer.add(l_Wedding_Aniv);
		
		
		Wedding_Aniv.setBounds(170,150,80,20);
		iFrameCustomer.add(Wedding_Aniv);
		
		    
		JLabel l_Birthday =new JLabel("     Birthdays :");
		l_Birthday.setBounds(350,150,80,20);
		iFrameCustomer.add(l_Birthday);
		
		Birthday.setBounds(440,150,130,20);
		iFrameCustomer.add(Birthday);
		Birthday.setText("Seperated by Comma");
		
		JLabel l_inc_date2 =new JLabel("dd / mm / yyyy ");
		l_inc_date2.setBounds(570,150,250,20);
		iFrameCustomer.add(l_inc_date2);
		
		JLabel l_Ring_Size =new JLabel("       Ring Size :");
		l_Ring_Size.setBounds(80,180,80,20);
		iFrameCustomer.add(l_Ring_Size);
		
		Ring_Husband.setBounds(170,180,30,20);
		iFrameCustomer.add(Ring_Husband);
		Ring_Husband.setText("<H>");

		Ring_Wife.setBounds(210,180,30,20);
		iFrameCustomer.add(Ring_Wife);
		Ring_Wife.setText("<W>");

		Ring_Other.setBounds(250,180,30,20);
		iFrameCustomer.add(Ring_Other);
		Ring_Other.setText("<O>");

		JLabel l_Visits =new JLabel("            Visits :");
		l_Visits.setBounds(350,180,120,20);
		iFrameCustomer.add(l_Visits);
		
		Visits.setBounds(440,180,50,20);
		iFrameCustomer.add(Visits);
		
		JLabel l_credit =new JLabel("      Credit :");
		l_credit.setBounds(100,210,80,20);
		iFrameCustomer.add(l_credit);
		
		credit.setBounds(170,210,180,20);
		iFrameCustomer.add(credit);

		JLabel l_Style_Id =new JLabel("    Style Id :");
		l_Style_Id.setBounds(100,240,80,20);
		iFrameCustomer.add(l_Style_Id);
		
		Style_Id.setBounds(170,240,50,20);
		iFrameCustomer.add(Style_Id);

		JLabel l_Remark =new JLabel("  Remark :");
		l_Remark.setBounds(100,270,120,20);
		iFrameCustomer.add(l_Remark);
		
		Remark.setBounds(170,270,400,20);
		iFrameCustomer.add(Remark);
		

		

		
		Border border12 = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		submit.setBounds(270,315,140,30);
		iFrameCustomer.add(submit);
		submit.setBorder(border12);
		submit.addActionListener(this);
	
		
		desktop.add(iFrameCustomer);
		return(iFrameCustomer);
		//iFrameCustomer.show();
		
	}
	public void actionPerformed(ActionEvent e)
        {
               
		//String sCustomer_Id = Customer_Id.getText();
                String sDate_In= Date_In.getText();
       	        String sCustomer_Name = Customer_Name.getText();
               	String sAddress = Address.getText();
                String sPhone = Phone.getText();
       	        String sWedding_Aniv = Wedding_Aniv.getText();
               	String sBirthday = Birthday.getText();
                String sRing_Husband = Ring_Husband.getText();
                String sRing_Wife= Ring_Wife.getText();
       	        String sRing_Other = Ring_Other.getText();
               	String sVisits = Visits.getText();
                String scredit = credit.getText();
       	        String sStyle_Id = Style_Id.getText();
               	String sRemark = Remark.getText();



       	        //String sStatus = com.getText();


                String query =" INSERT INTO Customer(Date_In,Name,Address,Phone,Wedding_Aniv,Birthday,Ring_Husband,Ring_Wife,Ring_Other,Visits,credit,Style_Id,Remark) VALUES ('"+sDate_In+"','"+sCustomer_Name+"','"+sAddress+"','"+sPhone+"','"+sWedding_Aniv+"','"+sBirthday+"','"+sRing_Husband+"','"+sRing_Wife+"','"+sRing_Other+"','"+sVisits+"','"+scredit+"','"+sStyle_Id+"','"+sRemark+"')";

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
		
		iFrameCustomer.setVisible(false);
		//Addenq1 p = new Addenq1();		
	}
}