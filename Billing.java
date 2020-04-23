import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
class Billing extends JFrame implements ActionListener
{
	JInternalFrame iFrameBilling = new JInternalFrame("Add New Billing Item",true,true,true,true);
	
	Connection con;
	Connection con1;
        Statement stmt;
	Statement stmt1;
	Statement stmtCustom;
        ResultSet rs;
	ResultSet rs1;
	ResultSet res;
	LayoutManager lm = null;
	
	JTextField Customer_Id = new JTextField(10);
	JTextField Job_Id = new JTextField(10);
	JTextField Bill_Date = new JTextField(10);
	JTextField Stone_Numbers = new JTextField(5);
	JTextField Weight = new JTextField(10);
	JTextField Net_Weight = new JTextField(10);
	JTextField Gross_Err = new JTextField(10);
	JTextField Weight_Err = new JTextField(10);
	JTextField Gold_Purity = new JTextField(10);
	JTextField Total_Price = new JTextField(12);	
	//JTextField Advance = new JTextField(12);
	JTextField Discount = new JTextField(12);
	JTextField Details = new JTextField(255);
	JTextField Net_Due = new JTextField(10);
	
	
	String Mode_list[] = { 
					"Cash", "Credit Card", "Cheque", "Demand Draft"
			  };
	JComboBox Mode_Payment = new JComboBox(Mode_list);
	
	String com = "Cash";

	JButton submit = new JButton("Submit");

	public Billing()
	{
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
	}			
	public JInternalFrame BillingFrame(JDesktopPane desktop)
	{
		iFrameBilling.setLayout(lm);
		
		iFrameBilling.setLocation(25,25);
		
		iFrameBilling.setSize(600,450);
		Border border = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		iFrameBilling.setBorder(border);

		JLabel l_Billing_Id =new JLabel("                           Billing's Information");
		Font labelFont = new Font("Arial", Font.BOLD, 20);
		l_Billing_Id.setFont(labelFont);
		//l_Billing_Id.setColor(Color BLUE);
		l_Billing_Id.setBounds(20,20,500,20);
		iFrameBilling.add(l_Billing_Id);
		
		
		JLabel l_Customer_Id =new JLabel("         Customer ID :");
		l_Customer_Id.setBounds(50,60,120,20); 
		iFrameBilling.add(l_Customer_Id);
			
		
		Customer_Id.setBounds(170,60,60,20);
		iFrameBilling.add(Customer_Id);
		
		JLabel l_Job_Id =new JLabel("                 Job ID :");
		l_Job_Id.setBounds(60,90,120,20);
		iFrameBilling.add(l_Job_Id);
		
		
		Job_Id.setBounds(170,90,80,20);
		iFrameBilling.add(Job_Id);
		
		JLabel l_Bill_Date =new JLabel("           Bill Date :");
		l_Bill_Date.setBounds(65,120,120,20); 
		iFrameBilling.add(l_Bill_Date);
		
		
		Bill_Date.setBounds(170,120,80,20);
		iFrameBilling.add(Bill_Date);
		
		JLabel l_inc_date =new JLabel("dd / mm / yyyy");
		l_inc_date.setBounds(270,120,100,20);
		iFrameBilling.add(l_inc_date);

	 
		JLabel l_Stone_Numbers =new JLabel("       Number of Stones :");
		l_Stone_Numbers.setBounds(20,150,150,20);
		iFrameBilling.add(l_Stone_Numbers);
		
		Stone_Numbers.setBounds(170,150,80,20);
		iFrameBilling.add(Stone_Numbers);

		JLabel l_Mode_Payment =new JLabel("   Payment Mode :");
		l_Mode_Payment.setBounds(330,60,120,20);
		iFrameBilling.add(l_Mode_Payment);
		
		Mode_Payment.setMaximumRowCount(5);
		Mode_Payment.setBounds(440,60,120,20);
		Mode_Payment.addItemListener(new ItemListener()
					{
						public void itemStateChanged(ItemEvent a)
						{
							com = Mode_list[Mode_Payment.getSelectedIndex()];
						}
					});
		iFrameBilling.add(Mode_Payment);
		

		JLabel l_Weight =new JLabel("        Weight :");
		l_Weight.setBounds(80,180,100,20);
		iFrameBilling.add(l_Weight);
		
		
		Weight.setBounds(170,180,80,20);
		iFrameBilling.add(Weight);

		
		JLabel l_Net_Weight = new JLabel("    Net Weight :");
		l_Net_Weight.setBounds(70,210,120,20);
		iFrameBilling.add(l_Net_Weight);
		
		
		Net_Weight.setBounds(170,210,80,20);
		iFrameBilling.add(Net_Weight);
		
		JLabel l_Weight_Err = new JLabel("    Weight Error:");
		l_Weight_Err.setBounds(280,210,120,20);
		iFrameBilling.add(l_Weight_Err);
		
		
		Weight_Err.setBounds(380,210,80,20);
		iFrameBilling.add(Weight_Err);
		
		    
		JLabel l_Gross_Err =new JLabel("         Gross Error :");
		l_Gross_Err.setBounds(50,240,150,20);
		iFrameBilling.add(l_Gross_Err);
		
		
		Gross_Err.setBounds(170,240,80,20);
		iFrameBilling.add(Gross_Err);
		
		
		
		JLabel l_Gold_Purity =new JLabel("           Gold Purity :");
		l_Gold_Purity.setBounds(50,270,120,20);
		iFrameBilling.add(l_Gold_Purity);
		
		Gold_Purity.setBounds(170,270,100,20);
		iFrameBilling.add(Gold_Purity);
 
		JLabel l_Total_Price =new JLabel("                 Total Price :");
		l_Total_Price.setBounds(30,300,120,20);
		iFrameBilling.add(l_Total_Price);
		
		Total_Price.setBounds(170,300,100,20);
		iFrameBilling.add(Total_Price);

		JLabel l_Discount =new JLabel("       Discount :");
		l_Discount.setBounds(280,300,100,20);
		iFrameBilling.add(l_Discount);
		
		Discount.setBounds(380,300,70,20);
		iFrameBilling.add(Discount);

		JLabel l_Details =new JLabel("                  Details :");
		l_Details.setBounds(50,330,120,20);
		iFrameBilling.add(l_Details);
		
		Details.setBounds(170,330,300,20);
		iFrameBilling.add(Details);


		Border border12 = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		submit.setBounds(240,370,140,30);
		iFrameBilling.add(submit);
		submit.setBorder(border12);
		submit.addActionListener(this);
	
		
		desktop.add(iFrameBilling);
		return(iFrameBilling);
		//iFrameBilling.show();
		
	}
	public void actionPerformed(ActionEvent e)
        {
               
		String Advance;
		String sCustomer_Id = Customer_Id.getText();
                String sJob_Id = Job_Id.getText();
		String sBill_Date = Bill_Date.getText();
               	String sStone_Numbers = Stone_Numbers.getText();
                String sWeight = Weight.getText();
       	        String sNet_Weight = Net_Weight.getText();
               	String sGross_Err = Gross_Err.getText();
                String sWeight_Err= Weight_Err.getText();
       	        String sGold_Purity = Gold_Purity.getText();
               	String sTotal_Price = Total_Price.getText();
                //String sAdvance = Advance.getText();
		String sDiscount = Discount.getText();
               	String sDetails = Details.getText();
		
	
		if(sCustomer_Id.equals(""))
		{
			JOptionPane.showMessageDialog(this,"Customer Id is Missing.");
			return;
		}
	
		//int Cust = Integer.parseInt(sCustomer_Id);

		//System.out.println("sCustomer_Id="+Cust);
		//if(!(sCustomer_Id.equals("")))
		{
			System.out.println("sCustomer_Id="+sCustomer_Id);
			try
			{
				String qCustom = "SELECT Customer_ID FROM Job_Card WHERE Customer_ID = '"+sCustomer_Id+"'";
				stmtCustom = con.createStatement();
				res = stmtCustom.executeQuery ( qCustom );
				System.out.println("the res = "+res);
				if(!(res.next()))
				{
					JOptionPane.showMessageDialog(this,"Customer not Present add to customer Data base.");
					setTitle("No Record to Display");
					return;
				}
			}
			catch(Exception ae)
              		{
              			ae.printStackTrace();
	        	}
		}
	        if(sJob_Id.equals(""))
		{
			JOptionPane.showMessageDialog(this,"Job Id is Missing.");
			setTitle("No Record to Display");
			return;
		}
		if(sBill_Date.equals(""))
		{
			JOptionPane.showMessageDialog(this,"Bill Date is Missing.");
			setTitle("No Record to Display");
			return;
		}
		if(sStone_Numbers.equals(""))
		{
			JOptionPane.showMessageDialog(this,"Number of Stones Id is Missing.");
			setTitle("No Record to Display");
			return;
		}
		if(sNet_Weight.equals(""))
		{
			JOptionPane.showMessageDialog(this,"Net Weight is Missing.");
			setTitle("No Record to Display");
			return;
		}
		if(sGross_Err.equals(""))
		{
			JOptionPane.showMessageDialog(this,"Gross Error is Missing.");
			setTitle("No Record to Display");
			return;
		}
		if(sWeight_Err.equals(""))
		{
			JOptionPane.showMessageDialog(this,"Weight Error is Missing.");
			setTitle("No Record to Display");
			return;
		}
		if(sGold_Purity.equals(""))
		{
			JOptionPane.showMessageDialog(this,"Gold Purity is Missing.");
			setTitle("No Record to Display");
			return;
		}
		if(sTotal_Price.equals(""))
		{
			JOptionPane.showMessageDialog(this,"Total Price is Missing.");
			setTitle("No Record to Display");
			return;
		}
		
		
		
                String query =new String(" INSERT INTO Billing(Customer_ID,Job_ID,Bill_Date,Stone_Numbers,Weight,Net_Weight,Gross_error,Weight_error,Gold_purity,Total_Price,Payment_Mode,Discount,Details) VALUES ('"+sCustomer_Id+"','"+sJob_Id+"','"+sBill_Date+"','"+sStone_Numbers+"','"+sWeight+"','"+sNet_Weight+"','"+sGross_Err+"','"+sWeight_Err+"','"+sGold_Purity+"','"+sTotal_Price+"','"+com+"','"+sDiscount+"','"+sDetails+"')");
		
		String query1 = new String("SELECT Amount_Advance FROM Job_Card WHERE Job_ID = "+sJob_Id+"");
		
		try
	        {
        		stmt = con.createStatement();
			int result = stmt.executeUpdate ( query );
				
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery ( query1 );
			//System.out.println(" result1="+rs1);
			if(rs1.next())
			{
				Advance = rs1.getString(1);
				System.out.println("Systems output is "+Advance);
			}
		
			
		
		}
		catch(Exception ae)
              	{
              		ae.printStackTrace();
	        }
		
		//iFrameBilling.setVisible(false);
		//Addenq1 p = new Addenq1();Amount_Advance		
	}
}