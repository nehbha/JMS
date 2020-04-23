/*
Java Swing, 2nd Edition
By Marc Loy, Robert Eckstein, Dave Wood, James Elliott, Brian Cole
ISBN: 0-596-00408-7
Publisher: O'Reilly 
*/
// SplashScreen.java
//A simple application to show a title screen in the center of the screen
//for the amount of time given in the constructor. This class includes
//a sample main() method to test the splash screen, but it's meant for use
//with other applications.
//

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

@SuppressWarnings("serial")
public class SplashScreen extends JWindow {
  private int duration;

  public SplashScreen(int d) {
    duration = d;
  }

  // A simple little method to show a title screen in the center
  // of the screen for the amount of time given in the constructor
  public void showSplash() {
    JPanel content = (JPanel) getContentPane();
    content.setBackground(Color.black);

    // Set the window's bounds, centering the window
    int width = 500;
    int height = 500;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width - width) / 2;
    int y = (screen.height - height) / 2;
    setBounds(x, y, width, height);

    // Build the splash screen
    JLabel label = new JLabel(new ImageIcon("jms2.gif"));
    JLabel copyrt = new JLabel("Jewellery Management System",JLabel.CENTER);
    copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 16));
    content.add(label, BorderLayout.CENTER);
    copyrt.setForeground(Color.RED);
    content.add(copyrt, BorderLayout.SOUTH);
    
    content.setBorder(BorderFactory.createLineBorder(Color.black, 10));

    // Display it
    setVisible(true);

    // Wait a little while, maybe while loading resources
    try {
      Thread.sleep(duration);
    } catch (Exception e) {
    }

    setVisible(false);
  }

  public void showSplashAndExit() {
    showSplash();
    //System.exit(0);
    Login lofinForm = new Login();
    
  }

  public static void main(String[] args) {
    // Throw a nice little title page up on the screen first
    SplashScreen splash = new SplashScreen(4000);
    // Normally, we'd call splash.showSplash() and get on with the program.
    // But, since this is only a test...
    splash.showSplashAndExit();
    
  }
}