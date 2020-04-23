import java.sql.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.border.*;
import java.awt.event.*;
class Login extends JFrame implements ActionListener
{
	Container c = getContentPane();
	Connection con;
        Statement stmt;
        ResultSet rs;
	LayoutManager lm = null;
	String com1;
	String filds[] = {
					"Admin", "Salesman", "Goldsmith"
				 }; 
	
	String com = "Admin";
	JComboBox Type = new JComboBox(filds);
	
	JTextField User = new JTextField(50);
	JPasswordField Password = new JPasswordField(50);

	JButton Submit = new JButton("Submit");
	JButton Reset = new JButton("Reset");
	
	public Login()
	{
		c.setLayout(lm);
		c.setBackground(Color.black);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 310;
	    int height = 270;
		int x = (screen.width - width) / 2;
	    int y = (screen.height - height) / 2;
	    setBounds(x, y, width, height);

		setTitle("User to JMS");
	
		//Border border = new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED),new LineBorder(Color.black,10));
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:JMS");
		}
		catch(Exception ae)
		{
			System.out.println("NO CONNECTION");
			ae.printStackTrace();
		}
		
		JLabel Tag = new JLabel("Login to JMS");		
		Font labelFont = new Font("Arial", Font.BOLD, 30);
		Tag.setFont(labelFont);
		Tag.setForeground(Color.white);
		Tag.setBounds(60,20,200,50);
		c.add(Tag);

		JLabel l_User = new JLabel("User ID");;
		l_User.setBounds(70,80,80,20);
		l_User.setForeground(Color.white);
		c.add(l_User);

		User.setBounds(140,80,80,20);
		c.add(User);

		JLabel l_Password = new JLabel("Password");;
		l_Password.setBounds(70,110,80,20);
		l_Password.setForeground(Color.white);
		c.add(l_Password);

		Password.setBounds(140,110,80,20);
		c.add(Password);
		
		JLabel l_Type = new JLabel("User Type");;
		l_Type.setBounds(70,140,80,20);
		l_Type.setForeground(Color.white);
		c.add(l_Type);

		Type.setMaximumRowCount(3);
		Type.setBounds(140,140,80,20);
		Type.addItemListener(new ItemListener()
					{
						public void itemStateChanged(ItemEvent a)
						{
							com = filds[Type.getSelectedIndex()];
						}
					});
		c.add(Type);
		
		Border border12 = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		Submit.setBounds(100,190,100,20);
		c.add(Submit);
		Submit.setBorder(border12);
		Submit.addActionListener(this);
		
		setVisible(true);		
	}
	public void actionPerformed(ActionEvent e)//throws SQLException
	{	
		
		//System.out.println("the action"+e);
		
		if(e.getActionCommand().equals("Submit"))
		{
		
			String SUser = User.getText();
			String SPassword = Password.getText();
			String SType = com;
			String str,str1;
		//	str = "SUser";
			//str1 = "'"+str+"'";
		 
	
			try
			{
				String query = new String("SELECT * FROM Login L WHERE L.User='"+SUser+"' ");
				stmt = con.createStatement();
				rs = stmt.executeQuery ( query );
				//System.out.println("rs = "+rs);	
				
				int i = 0;
				
				while(rs.next())
				{
					String dUser = rs.getString(("User"));
					//System.out.println("User = "+dUser);
					String dPassword = rs.getString(("Password"));
					//System.out.println("User = "+dPassword);				
					String dType = rs.getString(("Type"));
					//System.out.println("User = "+dType);		
					
					if((SType.equals(dType))&&(SUser.equals(dUser))&&(SPassword.equals(dPassword)))
					{
						JOptionPane.showMessageDialog(this,"Login Successful Welcome To JMS Mr. "+dType);
						setVisible(false);
						InterNal in1 = new InterNal(dType);
						return;
					}	
					
					
					
						if((SType.equals(dType))&&(SUser.equals(dUser))||!(SPassword.equals(dPassword)))
						{
							JOptionPane.showMessageDialog(this,"Wrong Password or Locked by user");
							return;
						}
						if((SType.equals(dType))||(SUser.equals(dUser))||!(SPassword.equals(dPassword)))
						{
							JOptionPane.showMessageDialog(this,"Wrong Password or Type");
							return;
						}
						i=i+1;
				}
				
				if(i==0)
				{
					JOptionPane.showMessageDialog(this,"Wrong User ID and Password");
					return;
				}
			}
			catch(Exception ae)
            {
            	ae.printStackTrace();
	        }
		}
		if(e.getActionCommand().equals("Reset"))
		{
			setVisible(false);
			Login againlogin = new Login();
		}
	}
}
/*class Login
{
	public static void main(String argv[])
	{
		LoginForm lofinForm = new LoginForm();
	}
}*/