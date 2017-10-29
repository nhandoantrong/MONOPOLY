import java.awt.*;     // Using AWT's Graphics and Color
import java.net.URL;
import javax.swing.*;  // Using Swing's components and container

import java.util.Formatter;
import java.util.Random;
import java.awt.event.*;
public class Field extends JFrame implements MouseMotionListener
{
	private JTextField t1,t2;
	private JPanel board,lulu;
	private ImageLabel boardPic, luluPic;
	public Field()
	{
		Container cp=getContentPane();
		JPanel panel1= new JPanel(new FlowLayout());
		cp.setLayout(new BorderLayout());
		t1=new JTextField("100");
		t2=new JTextField("100");
		t1.setBackground(Color.GREEN);
		t2.setBackground(Color.GREEN);
		JLabel label= new JLabel("             " );
		panel1.add(t1);
		panel1.add(label);
		panel1.add(t2);
		
		board=new JPanel();
		boardPic=new ImageLabel(new ImageIcon("board1.jpg"));
		board.setLocation(0, 0);
		board.add(boardPic);
		lulu=new JPanel();
		luluPic=new ImageLabel(new ImageIcon("lulu2.jpg"));
		luluPic.setLocation(900, 700);
		lulu.add(luluPic);
		
		cp.add(panel1,BorderLayout.SOUTH);
		cp.add(board,BorderLayout.WEST);
		t1.setEditable(false);
		t2.setEditable(false);
		addMouseMotionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
	    setTitle("MONOPOLY"); // "super" JFrame sets title
	    setSize(800,800);         // "super" JFrame sets initial size
	    setVisible(true);  
	}
	 @Override
	   public void mouseMoved(MouseEvent evt) {
	      t1.setText("   "+evt.getX() + "  ");
	      t2.setText("   "+evt.getY() + "  ");
	   }
	 
	   // Not Used, but need to provide an empty body for compilation
	   @Override public void mouseDragged(MouseEvent evt) { }
}