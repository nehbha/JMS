import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
class LoginDel extends JFrame implements ActionListener
{
	JInternalFrame iFrameLoginDel = new JInternalFrame("Delete Login Info",true,true,true,true);
	
	Connection con;
        Statement stmt;
        ResultSet rs;
	LayoutManager lm = null;
	
	

	JTextField LoginDel_Id = new JTextField(10);
	
	
	JButton Delete = new JButton("Delete");

	public LoginDel()
	{
	}			
	public JInternalFrame LoginDelFrame(JDesktopPane desktop)
	{
		iFrameLoginDel.setLayout(lm);
		
		iFrameLoginDel.setLocation(25,25);
			
		
		iFrameLoginDel.setSize(300,80);
		Border border = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		iFrameLoginDel.setBorder(border);

			
		JLabel l_LoginDel_Id =new JLabel("User ID :");
		l_LoginDel_Id.setBounds(20,15,110,20); 
		iFrameLoginDel.add(l_LoginDel_Id);
			
		
		LoginDel_Id.setBounds(120,15,60,20);
		iFrameLoginDel.add(LoginDel_Id);
		
	
		Border border12 = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		Delete.setBounds(190,15,100,20);
		iFrameLoginDel.add(Delete);
		Delete.setBorder(border12);
		Delete.addActionListener(this);
	
		
		desktop.add(iFrameLoginDel);
		return(iFrameLoginDel);
		//iFrameLoginDel.show();
		
	}
	public void actionPerformed(ActionEvent e)
        {
               
		String delstr = LoginDel_Id.getText();
	
		
                
                try
	        {
        		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        con = DriverManager.getConnection("jdbc:odbc:JMS");
			//int custstr = Integer.parseInt(delstr);
			String query = "DELETE * FROM Login E WHERE E.User = '"+delstr+"'";
			System.out.println("Query ="+query);
			stmt = con.createStatement();
			int result = stmt.executeUpdate ( query );
			System.out.println("result = "+result);
			if(result==1)
			{
				JOptionPane.showMessageDialog(this,"The Login Record Deleted");
				iFrameLoginDel.setVisible(false);
				return;	
			}
			if(result==0)
			{
				JOptionPane.showMessageDialog(this,"The Login Record Not Found Try Again.");
				return;	
			}
		}
		catch(Exception ae)
              	{
              		ae.printStackTrace();
	        }
	}
}