import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
class VendorDel extends JFrame implements ActionListener
{
	JInternalFrame iFrameVendorDel = new JInternalFrame("Delete Vendor Info",true,true,true,true);
	
	Connection con;
        Statement stmt;
        ResultSet rs;
	LayoutManager lm = null;
	
	

	JTextField VendorDel_Id = new JTextField(10);
	
	
	JButton Delete = new JButton("Delete");

	public VendorDel()
	{
	}			
	public JInternalFrame VendorDelFrame(JDesktopPane desktop)
	{
		iFrameVendorDel.setLayout(lm);
		
		iFrameVendorDel.setLocation(25,25);
		iFrameVendorDel.setTitle("Delete Vendor Information");
		
		
		iFrameVendorDel.setSize(300,80);
		Border border = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		iFrameVendorDel.setBorder(border);

			
		JLabel l_VendorDel_Id =new JLabel("Vendor ID :");
		l_VendorDel_Id.setBounds(20,15,110,20); 
		iFrameVendorDel.add(l_VendorDel_Id);
			
		
		VendorDel_Id.setBounds(120,15,60,20);
		iFrameVendorDel.add(VendorDel_Id);
		
	
		Border border12 = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		Delete.setBounds(190,15,100,20);
		iFrameVendorDel.add(Delete);
		Delete.setBorder(border12);
		Delete.addActionListener(this);
	
		
		desktop.add(iFrameVendorDel);
		return(iFrameVendorDel);
		//iFrameVendorDel.show();
		
	}
	public void actionPerformed(ActionEvent e)
        {
               
		String delstr = VendorDel_Id.getText();
	
		
                
                try
	        {
        		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        con = DriverManager.getConnection("jdbc:odbc:JMS");
			int custstr = Integer.parseInt(delstr);
			String query = "DELETE * FROM Vendor E WHERE E.Vendor_ID = "+custstr;
			stmt = con.createStatement();
			int result = stmt.executeUpdate ( query );
			System.out.println("result = "+result);
			if(result==1)
			{
				JOptionPane.showMessageDialog(this,"The Vendor Record Deleted");
				iFrameVendorDel.setVisible(false);
				return;	
			}
			if(result==0)
			{
				JOptionPane.showMessageDialog(this,"The Vendor Record Not Found Try Again.");
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