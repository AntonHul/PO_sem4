import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.swing.JPanel;

import org.jfree.data.xy.XYSeries;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel {
	
	Color BGColor, colorSmall, colorBig;

	double valueDisplayed;
	ParticleInfo allParticles;
	
	ArrayList<Position> positions; 
	boolean addMorePositions = false;
	
	XYSeries series;

	
	
	public CenterPanel(ParticleInfo allParticles) {
		BGColor = Color.LIGHT_GRAY;
		colorBig = Color.blue;
		colorSmall = Color.black;
		this.setBackground(BGColor);
		this.allParticles = allParticles;
		positions = new ArrayList<Position>();
		series = new XYSeries("Ruch du¿ej cz¹stki");

	} // Koniec Konstruktora
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		this.setBackground(BGColor);
		
		int i = 1;
		while (allParticles.numberSmall >= i)  {
        	Ellipse2D.Double smallParticle = new Ellipse2D.Double(allParticles.particleList.get(i).xPosition, allParticles.particleList.get(i).yPosition,
        			allParticles.particleList.get(i).radius*2, allParticles.particleList.get(i).radius*2);
        	g2d.setColor(colorSmall);
        	g2d.fill(smallParticle);
        	i++;
        }
        
        Ellipse2D.Double bigParticle = new Ellipse2D.Double(allParticles.particleList.get(0).xPosition, allParticles.particleList.get(0).yPosition,
        		 allParticles.particleList.get(0).radius*2, allParticles.particleList.get(0).radius*2);
        g2d.setColor(colorBig);
        g2d.fill(bigParticle);
	} 
	
	class Position {
		double x, y;
		
		public Position(double xx, double yy) {
			x = xx;
			y = yy;
		}
		
		public String getPosition() {
			return String.format(Locale.US, "%f\t%f", x, y);
		}
	}
	
	public void clearPositions() {
		this.positions.clear();
		this.series.clear();
	}
	
	public void addPosition(double xx, double yy) {
		this.positions.add(new Position(xx, yy));
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
}
