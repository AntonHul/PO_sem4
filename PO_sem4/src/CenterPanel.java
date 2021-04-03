import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel {
	
	Color BGColor;
	
	public CenterPanel() {
		BGColor = Color.LIGHT_GRAY;
		this.setBackground(BGColor);
		
	} // Koniec Konstruktora
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
        
        Random rand = new Random();
        for(int i=0; i<1000; i++) {
        	Ellipse2D.Double smallParticle = new Ellipse2D.Double(rand.nextInt(1100), rand.nextInt(700), 10, 10);
        	g2d.setColor(Color.black);
        	g2d.fill(smallParticle);
        }
        
        Ellipse2D.Double bigParticle = new Ellipse2D.Double(470, 240, 150, 150);
        g2d.setColor(Color.blue);
        g2d.fill(bigParticle);
        
	} // Pokazowe cz¹stki
	
}
