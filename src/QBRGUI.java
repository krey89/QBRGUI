//This GUI takes in football passing statistics and
//calculates the passer rating used by the NFL to evaluate
//passing efficiency.  The scale is from 0 to 158.3.
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
class qbr extends JPanel{
	TextField  attTF = new TextField();
	Label attLB = new Label("ATT");
	
	TextField  compTF = new TextField();
	Label compLB = new Label("COMP");

	TextField  ydsTF = new TextField();
	Label ydsLB = new Label("YDS");

	TextField  tdTF = new TextField();
	Label tdLB = new Label("TD");

	TextField  intTF = new TextField();
	Label intLB = new Label("INT");

	Button calc = new Button("Find Passer Rating");
	Label qbrLB = new Label();
	Label pctLB = new Label("Comp %: ");
	Label ypaLB = new Label("YDS/ATT: ");

	 
	public class qbrListener implements ActionListener{
		   public void actionPerformed(ActionEvent e){
			    double att = Double.parseDouble(attTF.getText());	//pass attempts
			     double comp = Double.parseDouble(compTF.getText());//completions
			     double yds = Double.parseDouble(ydsTF.getText());	//yards
			     double td = Double.parseDouble(tdTF.getText());	//touchdowns
			     double ints = Double.parseDouble(intTF.getText());	//interceptions
			 	double a,b,c,d;

			     a = ((comp/att)-(.3))*5;
			     if(a < 0){
						a = 0;}
					else if (a > 2.375){
					a = 2.375;}
			     b = ((yds/att)-3)/4;
			     if(b< 0){
						b = 0;}
					else if (b > 2.375){
					b = 2.375;}
			     c = (td/att)*20;
			     if(c < 0){
						c= 0;}
					else if (c > 2.375){
					c = 2.375;}
			     d = 2.375-((ints/att)*25);
			     if(d < 0){
						d = 0;}
					else if (d > 2.375){
					d = 2.375;}
			     
			     double passer_rating = ((a+b+c+d)/6)*100;
			     qbrLB.setText(""+passer_rating);
			     pctLB.setText("Comp %: "+(comp/att)*100);	//prints completion percentage
			     ypaLB.setText("YDS/ATT: "+(yds/att));		//prints yards per attempt
		   }

		}
	

	public qbr(){
	      setLayout(null);
	      
	      add(attTF, 10, 10, 100, 30);
	      add(attLB, 10, 40, 100, 30);
	      add(compTF, 10, 80, 100, 30);
	      add(compLB, 10, 110, 100, 30);
	      add(ydsTF, 10, 150, 100, 30);
	      add(ydsLB, 10, 180, 100, 30);
	      add(tdTF, 10, 220, 100, 30);
	      add(tdLB, 10, 250, 100, 30);
	      add(intTF, 10, 290, 100, 30);
	      add(intLB, 10, 320, 100, 30);
	      add(calc, 175, 50, 150, 30);
	      add(qbrLB, 175, 80, 150, 30);
	      add(pctLB, 175, 120, 150, 30);
	      add(ypaLB, 175, 150, 150, 30);
	      calc.addActionListener(new qbrListener());
		}
	 public void add(Component c, int x, int y, int w, int h){
		   add(c);
		   c.setLocation(x, y);
		   c.setSize(w, h);
		}

	 public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.black);		
		}

}


@SuppressWarnings("serial")
public class QBRGUI extends JFrame{
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new QBRGUI();
			}
		});
	}

	public QBRGUI(){	
		setSize(400, 400);
		setTitle("Passer Rating GUI");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new qbr());
	}


}
