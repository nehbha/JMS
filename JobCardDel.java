import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
class JobCardDel extends JFrame implements ActionListener
{
	JInternalFrame iFrameJobCardDel = new JInternalFrame("Delete Job Card Info",true,true,true,true);
	
	Connection con;
        Statement stmt;
        ResultSet rs;
	LayoutManager lm = null;
	
	

	JTextField JobCardDel_Id = new JTextField(10);
	
	
	JButton Delete = new JButton("Delete");

	public JobCardDel()
	{
	}			
	public JInternalFrame JobCardDelFrame(JDesktopPane desktop)
	{
		iFrameJobCardDel.setLayout(lm);
		
		iFrameJobCardDel.setLocation(25,25);
				
		iFrameJobCardDel.setSize(300,80);
		Border border = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		iFrameJobCardDel.setBorder(border);

			
		JLabel l_JobCardDel_Id =new JLabel("Job Card ID :");
		l_JobCardDel_Id.setBounds(20,15,110,20); 
		iFrameJobCardDel.add(l_JobCardDel_Id);
			
		
		JobCardDel_Id.setBounds(120,15,60,20);
		iFrameJobCardDel.add(JobCardDel_Id);
		
	
		Border border12 = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		Delete.setBounds(190,15,100,20);
		iFrameJobCardDel.add(Delete);
		Delete.setBorder(border12);
		Delete.addActionListener(this);
	
		
		desktop.add(iFrameJobCardDel);
		return(iFrameJobCardDel);
		//iFrameJobCardDel.show();
		
	}
	public void actionPerformed(ActionEvent e)
        {
               
		String delstr = JobCardDel_Id.getText();
	
		
                
                try
	        {
        		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        con = DriverManager.getConnection("jdbc:odbc:JMS");
			int custstr = Integer.parseInt(delstr);
			String query = "DELETE * FROM Job_Card E WHERE E.Job_ID = "+custstr;
			stmt = con.createStatement();
			int result = stmt.executeUpdate ( query );
			System.out.println("result = "+result);
			if(result==1)
			{
				JOptionPane.showMessageDialog(this,"The Job Card Record Deleted");
				iFrameJobCardDel.setVisible(false);
				return;	
			}
			if(result==0)
			{
				JOptionPane.showMessageDialog(this,"The Job Card Record Not Found Try Again.");
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