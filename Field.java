import java.awt.*;     // Using AWT's Graphics and Color
import java.net.URL;
import javax.swing.*;  // Using Swing's components and container
import java.util.concurrent.TimeUnit;
import java.util.Formatter;
import java.util.Random;
import java.awt.event.*;
public class Field extends JFrame implements MouseMotionListener, MouseListener,ActionListener
{
	private JTextField t1,t2;
	private JPanel board,lulu;
	private ImageLabel boardPic, luluPic;
	private Canvas canvas;
	private Random dice1= new Random(), dice2=new Random();
	private int x=630,y=620,co=0,d1=1,d2=1;
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
		canvas=new Canvas(x,y,d1,d2);
		canvas.setPreferredSize(new Dimension(700,700));
		
		cp.add(panel1,BorderLayout.SOUTH);
		cp.add(canvas,BorderLayout.WEST);
		t1.setEditable(false);
		t2.setEditable(false);
		addMouseMotionListener(this);
		addMouseListener(this);
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
	  @Override
	   public void mouseClicked(MouseEvent evt)
	  {
		  d1=dice1.nextInt(6)+1;
		  d2=dice2.nextInt(6)+1;
		  int num=d1+d2;
		  for (int i=1;i<=num;i++)
		  {
			  update();
			  canvas.setXY(x,y);
			  canvas.setDice(d1,d2);
			  repaint();
		  }
		  
	  }
	  
	  public void update()
	  {
		  if (co/10%4==0)
			  x-=57;
			  else if (co/10%4==1)
				  y-=57;
			  	else if (co/10%4==2)
			  x+=57;
			  	else if (co/10%4==3)
			  y+=57;
		  co++;
	  }
	  @Override public void actionPerformed(ActionEvent ev){
	  }
	  @Override public void mousePressed(MouseEvent evt) 
	  {
		  
	  }
	   @Override public void mouseReleased(MouseEvent evt) { }
	   @Override public void mouseEntered(MouseEvent evt) { }
	   @Override public void mouseExited(MouseEvent evt) { }
	  
}
