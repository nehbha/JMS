import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
class BillingDel extends JFrame implements ActionListener
{
	JInternalFrame iFrameBillingDel = new JInternalFrame("Delete Billing Info",true,true,true,true);
	
	Connection con;
        Statement stmt;
        ResultSet rs;
	LayoutManager lm = null;
	
	

	JTextField BillingDel_Id = new JTextField(10);
	
	
	JButton Delete = new JButton("Delete");

	public BillingDel()
	{
	}			
	public JInternalFrame BillingDelFrame(JDesktopPane desktop)
	{
		iFrameBillingDel.setLayout(lm);
		
		iFrameBillingDel.setLocation(25,25);
				
		iFrameBillingDel.setSize(300,80);
		Border border = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		iFrameBillingDel.setBorder(border);

			
		JLabel l_BillingDel_Id =new JLabel("Bill Number :");
		l_BillingDel_Id.setBounds(20,15,110,20); 
		iFrameBillingDel.add(l_BillingDel_Id);
			
		
		BillingDel_Id.setBounds(120,15,60,20);
		iFrameBillingDel.add(BillingDel_Id);
		
	
		Border border12 = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		Delete.setBounds(190,15,100,20);
		iFrameBillingDel.add(Delete);
		Delete.setBorder(border12);
		Delete.addActionListener(this);
	
		
		desktop.add(iFrameBillingDel);
		return(iFrameBillingDel);
		//iFrameBillingDel.show();
		
	}
	public void actionPerformed(ActionEvent e)
        {
               
		String delstr = BillingDel_Id.getText();
	
		
                
                try
	        {
        		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        con = DriverManager.getConnection("jdbc:odbc:JMS");
			int custstr = Integer.parseInt(delstr);
			String query = "DELETE * FROM Billing E WHERE E.Bill_No = "+custstr;
			stmt = con.createStatement();
			int result = stmt.executeUpdate ( query );
			System.out.println("result = "+result);
			if(result==1)
			{
				JOptionPane.showMessageDialog(this,"The Billing Record Deleted");
				iFrameBillingDel.setVisible(false);
				return;	
			}
			if(result==0)
			{
				JOptionPane.showMessageDialog(this,"The Billing Record Not Found Try Again.");
				return;	
			}
		}
		catch(Exception ae)
              	{
              		ae.printStackTrace();
	        }
		
		
		//Addenq1 p = new Addenq1();		
	}
}