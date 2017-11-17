import java.awt.*;     // Using AWT's Graphics and Color
import java.net.URL;
import javax.swing.*;  // Using Swing's components and container
import java.util.concurrent.TimeUnit;
import java.util.Formatter;
import java.util.Random;
import java.awt.event.*;
public class money extends JPanel {
	private int i;
	public money(int i)
	{
		this.i=i;
	}
	@Override
    public void paintComponent (Graphics g) 
	 {
       super.paintComponent(g);
       g.setFont(new Font("Arial", Font.PLAIN, 80));
       g.drawString(Integer.toString(i), 700,100);
       
    }
}
