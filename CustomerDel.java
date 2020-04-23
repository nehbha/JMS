import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
class CustomerDel extends JFrame implements ActionListener
{
	JInternalFrame iFrameCustomerDel = new JInternalFrame("Delete Customer Info",true,true,true,true);
	
	Connection con;
        Statement stmt;
        ResultSet rs;
	LayoutManager lm = null;
	
	

	JTextField CustomerDel_Id = new JTextField(10);
	
	
	JButton Delete = new JButton("Delete");

	public CustomerDel()
	{
	}			
	public JInternalFrame CustomerDelFrame(JDesktopPane desktop)
	{
		iFrameCustomerDel.setLayout(lm);
		
		iFrameCustomerDel.setLocation(25,25);
		iFrameCustomerDel.setTitle("Delete Customer Information");
		
		
		iFrameCustomerDel.setSize(300,80);
		Border border = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		iFrameCustomerDel.setBorder(border);

			
		JLabel l_CustomerDel_Id =new JLabel("Customer ID :");
		l_CustomerDel_Id.setBounds(20,15,110,20); 
		iFrameCustomerDel.add(l_CustomerDel_Id);
			
		
		CustomerDel_Id.setBounds(120,15,60,20);
		iFrameCustomerDel.add(CustomerDel_Id);
		
	
		Border border12 = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		Delete.setBounds(190,15,100,20);
		iFrameCustomerDel.add(Delete);
		Delete.setBorder(border12);
		Delete.addActionListener(this);
	
		
		desktop.add(iFrameCustomerDel);
		return(iFrameCustomerDel);
		//iFrameCustomerDel.show();
		
	}
	public void actionPerformed(ActionEvent e)
        {
               
		String delstr = CustomerDel_Id.getText();
	
		
                
                try
	        {
        		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        con = DriverManager.getConnection("jdbc:odbc:JMS");
			int custstr = Integer.parseInt(delstr);
			String query = "DELETE * FROM Customer E WHERE E.Customer_ID = "+custstr;
			stmt = con.createStatement();
			int result = stmt.executeUpdate ( query );
			System.out.println("result = "+result);
			if(result==1)
			{
				JOptionPane.showMessageDialog(this,"The Customer Record Deleted");
				iFrameCustomerDel.setVisible(false);
				return;	
			}
			if(result==0)
			{
				JOptionPane.showMessageDialog(this,"The Customer Record Not Found Try Again.");
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