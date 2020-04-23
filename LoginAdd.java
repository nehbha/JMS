import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
class LoginAdd extends JFrame implements ActionListener
{
	JInternalFrame iFrameLogin = new JInternalFrame("Add New User",true,true,true,true);
	
	Connection con;
    Statement stmt;
    ResultSet rs;
	LayoutManager lm = null;
	
	

	JTextField User = new JTextField(30);
	JPasswordField Password = new JPasswordField(30);
	JPasswordField PasswordC = new JPasswordField(30);
	JTextField Name = new JTextField(50);
	JTextField Contact = new JTextField(10);	
	
	String com1;
	String filds[] = {
					"Admin", "Salesman", "Goldsmith"
				 }; 
	
	String com = "Admin";
	JComboBox Type = new JComboBox(filds);

	JButton submit = new JButton("Submit");

	public LoginAdd()
	{
		try
        {
    		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        con = DriverManager.getConnection("jdbc:odbc:JMS");
	    }
		catch(Exception ae)
		{
         	ae.printStackTrace();
        }
	}			
	public JInternalFrame LoginAddFrame(JDesktopPane desktop)
	{
		iFrameLogin.setLayout(lm);
		
		iFrameLogin.setLocation(25,25);
		
		iFrameLogin.setSize(300,350);
		Border border = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		iFrameLogin.setBorder(border);

		JLabel l_Login =new JLabel("New User Information");
		Font labelFont = new Font("Arial", Font.BOLD, 15);
		l_Login.setFont(labelFont);
		l_Login.setForeground(Color.BLUE);
		l_Login.setBounds(20,20,500,20);
		iFrameLogin.add(l_Login);
		
		
		JLabel l_User =new JLabel("User ID :");
		l_User.setBounds(75,60,80,20); 
		iFrameLogin.add(l_User);
			
		
		User.setBounds(130,60,60,20);
		iFrameLogin.add(User);
		
		JLabel l_Password =new JLabel(" Password:");
		l_Password.setBounds(50,90,100,20);
		iFrameLogin.add(l_Password);
		
		
		Password.setBounds(130,90,80,20);
		iFrameLogin.add(Password);
		
		JLabel l_PasswordC =new JLabel("Re Enter Password:");
		l_PasswordC.setBounds(5,120,120,20); 
		iFrameLogin.add(l_PasswordC);
		
		
		PasswordC.setBounds(130,120,80,20);
		iFrameLogin.add(PasswordC);
		
		JLabel l_Type = new JLabel("User Type:");;
		l_Type.setBounds(50,150,80,20);
//		l_Type.setForeground(Color.white);
		iFrameLogin.add(l_Type);
		
		Type.setMaximumRowCount(3);
		Type.setBounds(130,150,80,20);
		Type.addItemListener(new ItemListener()
					{
						public void itemStateChanged(ItemEvent a)
						{
							com = filds[Type.getSelectedIndex()];
						}
					});
		iFrameLogin.add(Type);
		
		JLabel l_Name =new JLabel("Name:");
		l_Name.setBounds(75,180,60,20);
		iFrameLogin.add(l_Name);
		
		Name.setBounds(130,180,120,20);
		iFrameLogin.add(Name);

		JLabel l_Contact = new JLabel("Contact Number:");
		l_Contact.setBounds(20,210,120,20);
		iFrameLogin.add(l_Contact);
		
		Contact.setBounds(130,210,80,20);
		iFrameLogin.add(Contact);
				    
		Border border12 = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		submit.setBounds(90,250,140,30);
		iFrameLogin.add(submit);
		submit.setBorder(border12);
		submit.addActionListener(this);
	
		
		desktop.add(iFrameLogin);
		return(iFrameLogin);
		//iFrameLogin.show();
		
	}
	public void actionPerformed(ActionEvent e)
        {
               
		String sPassword = Password.getText();
		String sPasswordC = PasswordC.getText();
		
		if(sPassword.equals(sPasswordC))
		{		
			String sUser = User.getText();
			String sName = Name.getText();
			String sType = com;
			String sContact = Contact.getText();
			
			String query =" INSERT INTO Login(User,Password,Type,Name,Contact) VALUES ('"+sUser+"','"+sPassword+"','"+sType+"','"+sName+"','"+sContact+"')";
			try
	        {
        		stmt = con.createStatement();
        		int result = stmt.executeUpdate ( query );
	        }
			catch(Exception ae)
        	    {
              		ae.printStackTrace();
	        }
		
			iFrameLogin.setVisible(false);
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Password Do not Match Try Again.");
			return;	
		}
		
	
       }
}