


import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class ShowMovedDottedLine extends JPanel implements ActionListener{

	@Override
	public void paint(Graphics g) {
		Color c = getBackground();
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(c);
		g2.fillRect(0, 0, this.getWidth(),this.getHeight());
		g2.setColor(Color.RED);
		g2.setStroke(bs[(index++)%6]);
		
		g2.draw(path);
	}

	
	
	Timer timer ;
	GeneralPath path; 
	final BasicStroke[] bs = new BasicStroke[6];
    int index = 0;
	
	public ShowMovedDottedLine(){
		timer=new Timer(50,this);
		path = new GeneralPath();
		path.moveTo(0, 0);
		path.lineTo(600, 0);
		float[] dash = new float[]{5,5};
		 for (int i = 0; i < 6; i++) {
		        bs[i] = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, i);
		    }
		timer.start();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	

}
