import java.awt.*;     
import java.net.URL;
import javax.swing.*;  
import java.util.concurrent.TimeUnit;
import java.util.Formatter;
import java.util.Random;
import java.awt.event.*;
import cell.*;
import player.*;
public class Field extends JFrame implements MouseMotionListener
{
	private JTextField t1 = new JTextField(""),t2=new JTextField("");
	private JButton rollButton= new JButton("Roll");
	private JButton buyButton= new JButton("Buy");
	private JButton upgradeButton= new JButton("Uprade House");
	
	private Player play1= new Player("LULU",0,0,new Money(2000));
	private Player play;
	private Canvas canvas=new Canvas(630,620,1,1);
	private DisplayPlayer displayplayer=new DisplayPlayer(play1);
	private int x=630,y=620,co=0,d1=1,d2=1,turn=0;
	private Dice dice=new Dice();
	public Field()
	{
		Container cp=getContentPane();
		JPanel panel1= new JPanel(new FlowLayout());
		cp.setLayout(null);
		d1=dice.getDice1();
		d2=dice.getDice2();
		cp.add(canvas);
//		cp.add(t1);
//		cp.add(t2);
		cp.add(rollButton);
		cp.add(buyButton);
		cp.add(upgradeButton);
		cp.add(displayplayer);
		displayplayer.setBounds(701, 0, 200, 80);
		canvas.setBounds(0, 0, 700, 700);
//		t1.setBounds(701,10,50,20);
//		t2.setBounds(701,80,50,20);
//		t1.setEditable(false);
//		t2.setEditable(false);
		rollButton.setBounds(701, 400, 100, 50);
		rollButton.addActionListener(new rollListener());
		buyButton.setBounds(801, 400, 100, 50);
		upgradeButton.setBounds(901, 400, 200, 50);
		addMouseMotionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
	    setTitle("MONOPOLY"); // "super" JFrame sets title
	    setSize(1200,800);         // "super" JFrame sets initial size
	    setVisible(true);  
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent evt) {
		int x=evt.getX(),y=evt.getY();
		t1.setText(String.valueOf(x));
		t2.setText(String.valueOf(y));
	}
	private class rollListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent evt) 
		{
			dice.roll();
			d1=dice.getDice1();
			d2=dice.getDice2();
			canvas.setDice(d1, d2);
			play1.step(d1+d2);
			repaint();
			Thread move=new Thread()
			{
				@Override
				public void run() 
				{
					for (int i=0;i<(d1+d2)*57;i++)
					{
						if ((x>630-57*10) &&y==620) x--;
						else if (x==630-57*10&&y>620-57*10) y--;
						else if (x<630&&y==620-57*10) x++;
						else if (x==630&& y<620) y++;
						canvas.setXY(x,y);
						repaint();
						try {
			                  // Delay and give other thread a chance to run
			                  Thread.sleep(5);  // milliseconds
			               } catch (InterruptedException ignore) {}
					}
				}
			};
			move.start();
		}
	}
	
	
	  
}