
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

public class Lulu
{
	public String LuluName ="lulu2.jpg";
	public Image LuluImage;
	public Lulu()
	{
		ImageIcon LuluIcon=null;
		URL LuluURL= getClass().getClassLoader().getResource(LuluName);
		LuluIcon=new ImageIcon(LuluURL);
		LuluImage=LuluIcon.getImage();
	}
	
}
