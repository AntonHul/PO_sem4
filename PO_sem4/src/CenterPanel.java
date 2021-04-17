import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel {
	
	Color BGColor;

	double valueMassSmall, valueRadiusSmall, valueMassLarge, valueRadiusLarge, valueDisplayed;
	ParticleInfo allParicles;
	
	public CenterPanel() {
		BGColor = Color.LIGHT_GRAY;
		allParicles = new ParticleInfo();
		this.setBackground(BGColor);
		valueRadiusLarge = 200;
		valueRadiusSmall = 15;
	} // Koniec Konstruktora
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		int i = 1;
		while (allParicles.numberSmall > i)  {
        	Ellipse2D.Double smallParticle = new Ellipse2D.Double(allParicles.xPosition.get(i), allParicles.yPosition.get(i), valueRadiusSmall, valueRadiusSmall);
        	g2d.setColor(Color.black);
        	g2d.fill(smallParticle);
        	i++;
        }
        
        Ellipse2D.Double bigParticle = new Ellipse2D.Double(allParicles.xPosition.get(0), allParicles.yPosition.get(0), valueRadiusLarge, valueRadiusLarge);
        g2d.setColor(Color.blue);
        g2d.fill(bigParticle);
        
	} 
	

	public void setValueMassSmall(double valueMassSmall) {
		this.valueMassSmall = valueMassSmall;
		repaint();
	}

	public void setValueRadiusSmall(double valueRadiusSmall) {
		this.valueRadiusSmall = valueRadiusSmall;
		repaint();
	}

	public void setValueMassLarge(double valueMassLarge) {
		this.valueMassLarge = valueMassLarge;
		repaint();
	}

	public void setValueRadiusLarge(double valueRadiusLarge) {
		this.valueRadiusLarge = valueRadiusLarge;
		repaint();
	}

	public void setValueDisplayed(double valueDisplayed) {
		this.valueDisplayed = valueDisplayed;
		repaint();
	}
	
	// Settery dla obliczen

    public void setAllParicles(ParticleInfo allParicles) {
    	this.allParicles = allParicles;
    	repaint();
    }

}
