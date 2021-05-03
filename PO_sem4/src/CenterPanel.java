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
	
	Color BGColor, colorSmall, colorBig;

	double valueMassSmall, valueRadiusSmall, valueMassLarge, valueRadiusLarge, valueDisplayed;
	ParticleInfo allParticles;
	
	public CenterPanel() {
		BGColor = Color.LIGHT_GRAY;
		colorBig = Color.blue;
		colorSmall = Color.black;
		allParticles = new ParticleInfo();
		this.setBackground(BGColor);
		valueRadiusLarge = 100;
		valueRadiusSmall = 5;
	} // Koniec Konstruktora
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		int i = 1;
		while (allParticles.numberSmall >= i)  {
        	Ellipse2D.Double smallParticle = new Ellipse2D.Double(allParticles.particleList.get(i).xPosition, allParticles.particleList.get(i).yPosition, valueRadiusSmall*2, valueRadiusSmall*2);
        	g2d.setColor(colorSmall);
        	g2d.fill(smallParticle);
        	i++;
        }
        
        Ellipse2D.Double bigParticle = new Ellipse2D.Double(allParticles.particleList.get(0).xPosition, allParticles.particleList.get(0).yPosition, valueRadiusLarge*2, valueRadiusLarge*2);
        g2d.setColor(colorBig);
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
	
	public void setBGColor(Color c) {
		this.BGColor = c;
	}
	
	public void setColorBig(Color c) {
		this.colorBig = c;
	}
	
	public void setColorSmall(Color c) {
		this.colorSmall = c;
	}
	
	// Settery dla obliczen

    public void setAllParicles(ParticleInfo allParicles) {
    	this.allParticles = allParicles;
    	repaint();
    }

}
