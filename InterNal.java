import java.sql.*;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

import javax.swing.border.*;
class InterNal extends JFrame implements ActionListener 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
    Statement stmt;
    ResultSet rs;
    
    JInternalFrame iFrame1 = new JInternalFrame();
    
	Container c1 = getContentPane();
	LayoutManager lm = null;
	
	JDesktopPane desktopPane = new JDesktopPane();
		
	int fcount =1;
	int xo=25;
	int yo=25;
	
	public InterNal(String access)
	{
		super("JMS");
		c1 =this.getContentPane();
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
		
		System.out.println("Access = "+access);
		//new BevelBorder(BevelBorder.RAISED),
		Border border = new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED),new LineBorder(Color.white,5));
		desktopPane.setBorder(border);
		desktopPane.setBackground(Color.black);
		
		int width = 500;
	    int height = 500;
	    //Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = 300;
	    int y = 150;
	    	
		Border border1 = new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new EtchedBorder(EtchedBorder.RAISED));
		JMenuBar menuBar = new JMenuBar();
		
		menuBar.setBorder(border1);
		
		
		JMenu addNew = new JMenu("Add New");
		JMenu createNew = new JMenu("Create");
		JMenu  addSearch= new JMenu("Search");
		JMenu addDel = new JMenu("Delete");
		JMenu UserOut = new JMenu("User Logout");
		
		JMenuItem addCustomer = new JMenuItem("Add Customer");
		JMenuItem addVendor = new JMenuItem("Add Vendor");
		JMenuItem addInventory = new JMenuItem("Add Inventory");
		JMenuItem addLogin = new JMenuItem("Add User");
		
		JMenuItem createJobCard = new JMenuItem("Job Card");
		JMenuItem createBill = new JMenuItem("Bill");
			
		JMenuItem searchCustomer = new JMenuItem("Customer");
		JMenuItem searchJobCard = new JMenuItem("Job Card");
		JMenuItem searchInventory = new JMenuItem("Inventory");
		JMenuItem searchVendor = new JMenuItem("Vendor");
		JMenuItem searchBill = new JMenuItem("Old Bill");
		
		JMenuItem deleteCustomer = new JMenuItem("Customer Info");
		JMenuItem deleteJobCard = new JMenuItem("Job Card Info");
		JMenuItem deleteInventory = new JMenuItem("Inventory Info");
		JMenuItem deleteVendor = new JMenuItem("Vendor Info");
		JMenuItem deleteBill = new JMenuItem("Old Bill Info");
		JMenuItem deleteLogin = new JMenuItem("User Acount Info");
		
		JMenuItem menuLogOut = new JMenuItem("Logout");
	
		
		
		if(access.equals("Admin"))
		{
			addNew.add(addCustomer);
			addCustomer.addActionListener (new ActionListener() 
						{
			      			public void actionPerformed (ActionEvent e) 
			      			{
			      				Customer newCustomer = new Customer();
			      				iFrame1 = newCustomer.CustomerFrame(desktopPane);
			      				iFrame1.show();
			      			}
			      		});
			
			addNew.add(addVendor);
			addVendor.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				Vendor newVendor = new Vendor();
      				iFrame1 = newVendor.VendorFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addNew.add(addInventory);
			addInventory.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				Inventory newInventory = new Inventory();
      				iFrame1 = newInventory.InventoryFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addNew.add(addLogin);
			addLogin.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				LoginAdd newaddLogin = new LoginAdd();
      				iFrame1 = newaddLogin.LoginAddFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			createNew.add(createJobCard);
			createJobCard.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				JobCard createJobCard = new JobCard();
      				iFrame1 = createJobCard.JobCardFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			createNew.add(createBill);
			createBill.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				Billing createBill = new Billing();
      				iFrame1 = createBill.BillingFrame(desktopPane);
      				iFrame1.show();
      			}
      		});

			addSearch.add(searchCustomer);
			searchCustomer.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				CustomerView viewCustomer = new CustomerView();
      				iFrame1 = viewCustomer.CustomerViewFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addSearch.add(searchJobCard);
			searchJobCard.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				JobCardView viewJobCard = new JobCardView();
      				iFrame1 = viewJobCard.JobCardViewFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addSearch.add(searchInventory);
			searchInventory.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				InventoryView viewInventory = new InventoryView();
      				iFrame1 = viewInventory.InventoryViewFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			
			addSearch.add(searchVendor);
			searchVendor.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				VendorView viewVendor = new VendorView();
      				iFrame1 = viewVendor.VendorViewFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addSearch.add(searchBill);
			searchBill.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				BillingView viewBill = new BillingView();
      				iFrame1 = viewBill.BillingViewFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addDel.add(deleteCustomer);
			deleteCustomer.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				CustomerDel delCustomer = new CustomerDel();
      				iFrame1 = delCustomer.CustomerDelFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addDel.add(deleteJobCard);
			deleteJobCard.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				JobCardDel delJobCard = new JobCardDel();
      				iFrame1 = delJobCard.JobCardDelFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addDel.add(deleteInventory);
			deleteInventory.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				InventoryDel delInventory = new InventoryDel();
      				iFrame1 = delInventory.InventoryDelFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addDel.add(deleteVendor);
			deleteVendor.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				VendorDel delVendor = new VendorDel();
      				iFrame1 = delVendor.VendorDelFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addDel.add(deleteBill);
			deleteBill.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				BillingDel delBill = new BillingDel();
      				iFrame1 = delBill.BillingDelFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addDel.add(deleteLogin);
			deleteLogin.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				LoginDel delLogin = new LoginDel();
      				iFrame1 = delLogin.LoginDelFrame(desktopPane);
      				iFrame1.show();
      			}
      		});

			UserOut.add(menuLogOut);
			menuLogOut.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				setVisible(false);
      				Login againlogin = new Login();
      				
      			}
      		});
			
			
			menuBar.add(addNew);
			menuBar.add(createNew);
			menuBar.add(addSearch);
			menuBar.add(addDel);
			menuBar.add(UserOut,BorderLayout.WEST);
			
			addNew.setMnemonic('A');
			createNew.setMnemonic('C');
			addSearch.setMnemonic('S');
			addDel.setMnemonic('D');
			UserOut.setMnemonic('U');
			
		}
		
		if(access.equals("Salesman"))
		{
			addNew.add(addCustomer);
			addCustomer.addActionListener (new ActionListener() 
						{
			      			public void actionPerformed (ActionEvent e) 
			      			{
			      				Customer newCustomer = new Customer();
			      				iFrame1 = newCustomer.CustomerFrame(desktopPane);
			      				iFrame1.show();
			      			}
			      		});
			
			createNew.add(createJobCard);
			createJobCard.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				JobCard createJobCard = new JobCard();
      				iFrame1 = createJobCard.JobCardFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addSearch.add(searchCustomer);
			searchCustomer.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				CustomerView viewCustomer = new CustomerView();
      				iFrame1 = viewCustomer.CustomerViewFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addSearch.add(searchJobCard);
			searchJobCard.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				JobCardView viewJobCard = new JobCardView();
      				iFrame1 = viewJobCard.JobCardViewFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addSearch.add(searchInventory);
			searchInventory.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				InventoryView viewInventory = new InventoryView();
      				iFrame1 = viewInventory.InventoryViewFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			
			addSearch.add(searchBill);
			searchBill.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				BillingView viewBill = new BillingView();
      				iFrame1 = viewBill.BillingViewFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			UserOut.add(menuLogOut);
			menuLogOut.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				desktopPane.setVisible(false);
      				Login againlogin = new Login();
      				
      			}
      		});
			
			menuBar.add(addNew);
			menuBar.add(createNew);
			menuBar.add(addSearch);
			menuBar.add(UserOut,BorderLayout.WEST);
						
			addNew.setMnemonic('A');
			createNew.setMnemonic('C');
			addSearch.setMnemonic('S');
			UserOut.setMnemonic('U');
		}
		if(access.equals("Goldsmith"))
		{
			addSearch.add(searchJobCard);
			searchJobCard.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				JobCardView viewJobCard = new JobCardView();
      				iFrame1 = viewJobCard.JobCardViewFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			addSearch.add(searchInventory);
			searchInventory.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				InventoryView viewInventory = new InventoryView();
      				iFrame1 = viewInventory.InventoryViewFrame(desktopPane);
      				iFrame1.show();
      			}
      		});
			
			UserOut.add(menuLogOut,BorderLayout.WEST);
			menuLogOut.addActionListener (new ActionListener() 
			{
      			public void actionPerformed (ActionEvent e) 
      			{
      				desktopPane.setVisible(false);
      				Login againlogin = new Login();
      				
      			}
      		});
			
			menuBar.add(addSearch);
			menuBar.add(UserOut,BorderLayout.WEST);
					
			addSearch.setMnemonic('S');
			UserOut.setMnemonic('U');
		}
		
		
		addNew.setToolTipText("Click Here for add Operations.");
		addSearch.setToolTipText("Click here to search any Data in the Table");
		addDel.setToolTipText("Click Here to Delete any data in table with refrence to ID.");
		menuLogOut.setToolTipText("Click here to logout from the system.");

		c1.add(menuBar,BorderLayout.NORTH);
		c1.add(desktopPane);

		setSize(1100,700);
		show();
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

	