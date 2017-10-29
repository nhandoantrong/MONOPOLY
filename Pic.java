import java.awt.*;     // Using AWT's Graphics and Color
import java.net.URL;
import javax.swing.*;  // Using Swing's components and container
import java.util.Random;
public class Pic extends JPanel 
{
	private String name;
	private Image img;
	public Pic(String na)
	{
		name=na;
		URL url=getClass().getClassLoader().getResource(name);
		Toolkit tk=Toolkit.getDefaultToolkit();
		img=tk.getImage(url);
	}
	public Image getImage()
	{
		return img;
	}
}
