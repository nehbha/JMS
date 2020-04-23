import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
class InventoryDel extends JFrame implements ActionListener
{
	JInternalFrame iFrameInventoryDel = new JInternalFrame("Delete Vendor Info",true,true,true,true);
	
	Connection con;
        Statement stmt;
        ResultSet rs;
	LayoutManager lm = null;
	
	

	JTextField InventoryDel_Id = new JTextField(10);
	
	
	JButton Delete = new JButton("Delete");

	public InventoryDel()
	{
	}			
	public JInternalFrame InventoryDelFrame(JDesktopPane desktop)
	{
		iFrameInventoryDel.setLayout(lm);
		
		iFrameInventoryDel.setLocation(25,25);
		iFrameInventoryDel.setTitle("Delete Inventory Information");
		
		
		iFrameInventoryDel.setSize(300,80);
		Border border = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		iFrameInventoryDel.setBorder(border);

			
		JLabel l_InventoryDel_Id =new JLabel("Inventory ID :");
		l_InventoryDel_Id.setBounds(20,15,110,20); 
		iFrameInventoryDel.add(l_InventoryDel_Id);
			
		
		InventoryDel_Id.setBounds(120,15,60,20);
		iFrameInventoryDel.add(InventoryDel_Id);
		
	
		Border border12 = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		Delete.setBounds(190,15,100,20);
		iFrameInventoryDel.add(Delete);
		Delete.setBorder(border12);
		Delete.addActionListener(this);
	
		
		desktop.add(iFrameInventoryDel);
		return(iFrameInventoryDel);
		//iFrameInventoryDel.show();
		
	}
	public void actionPerformed(ActionEvent e)
        {
               
		String delstr = InventoryDel_Id.getText();
	
		
                
                try
	        {
        		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        con = DriverManager.getConnection("jdbc:odbc:JMS");
			int custstr = Integer.parseInt(delstr);
			String query = "DELETE * FROM Inventory E WHERE E.Inventory_ID = "+custstr;
			stmt = con.createStatement();
			int result = stmt.executeUpdate ( query );
			System.out.println("result = "+result);
			if(result==1)
			{
				JOptionPane.showMessageDialog(this,"The Inventory Record Deleted");
				iFrameInventoryDel.setVisible(false);
				return;	
			}
			if(result==0)
			{
				JOptionPane.showMessageDialog(this,"The Inventory Record Not Found Try Again.");
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