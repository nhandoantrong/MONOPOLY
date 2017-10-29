import javax.swing.*;

public class Monopoly {

	public static void main(String[] args) {
	      // Run UI in the Event Dispatcher Thread (EDT), instead of Main thread
	      javax.swing.SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	        	 new Field();
	         }
	      });
	   }

}
