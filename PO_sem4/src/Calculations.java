import java.awt.Color;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingWorker;



@SuppressWarnings("serial")
public class Calculations extends SwingWorker<Void, ParticleInfo>{
	int on_off, infty;
	CenterPanel centerPanel;
	double dt;
	ParticleInfo allParticles;

	public Calculations(ParticleInfo allParticles) {
    	 Random rand = new Random();
    	 this.allParticles = allParticles;
    	 on_off = 0;
    	 infty = 1;
	} 


    public void setCenterPanel(CenterPanel centerPanel) {
    	this.centerPanel = centerPanel;
    }	 
    
    //Obliczenia

	@Override
	protected Void doInBackground() throws Exception {
   	
   	Random rand = new Random();
	   	while(infty == 1) {

   		dt = 0.005;
   		int dup = 0;
		double x = 0;
		double y = 0;
		
   		int i = 1;
   		if(allParticles.numberSmallTmp > allParticles.numberSmall) {
   			for(i=0; i<allParticles.numberSmallTmp - allParticles.numberSmall; i++) {
   				while (dup == 0) {
   		    		x = rand.nextDouble()*1000;
   		    		y = rand.nextDouble()*600;
   		    		for (int j = 0; j < i + allParticles.numberSmall; j++) {
   		    			if((x >= allParticles.particleList.get(j).xPosition - allParticles.valueRadiusSmall*2 && x <= allParticles.particleList.get(j).xPosition + allParticles.particleList.get(j).radius*2) &&
   	    					 (y >= allParticles.particleList.get(j).yPosition - allParticles.valueRadiusSmall*2 && y <= allParticles.particleList.get(j).yPosition + allParticles.particleList.get(j).radius*2)) 
   	    					 dup = 1;
   		    		}
   		    		if (dup == 1) dup = 0;
   		    		else break;
   				}
   		    
   		 allParticles.particleList.add(new Particle(x, y, rand.nextDouble()*20-10.0, rand.nextDouble()*20-10, allParticles.valueRadiusSmall, allParticles.valueMassSmall));
   		 dup = 0;
   		} 
   			allParticles.numberSmall = allParticles.numberSmallTmp;
   		} else {
   			
   			for(i=0; i<allParticles.numberSmall - allParticles.numberSmallTmp; i++) {
   				allParticles.particleList.remove(allParticles.particleList.size()-1);
   			}
   			
   			allParticles.numberSmall = allParticles.numberSmallTmp;
   		}
   		
   		allParticles.particleList.get(0).radius = allParticles.valueRadiusLarge;

   	   	if(on_off == 1) {
   		allParticles.particleList.get(0).xPosition += allParticles.particleList.get(0).xVelocity * dt;
		allParticles.particleList.get(0).yPosition += allParticles.particleList.get(0).yVelocity * dt;
		
		if(allParticles.particleList.get(0).xPosition >= centerPanel.getWidth() - allParticles.particleList.get(0).radius * 2 || allParticles.particleList.get(0).xPosition <= 0) allParticles.particleList.get(0).xVelocity *= -1;
		if(allParticles.particleList.get(0).yPosition >= centerPanel.getHeight()- allParticles.particleList.get(0).radius * 2 || allParticles.particleList.get(0).yPosition <= 0) allParticles.particleList.get(0).yVelocity *= -1;
		
   		
   		i=1;
		while (allParticles.numberSmall >= i)  {
			allParticles.particleList.get(i).radius = allParticles.valueRadiusSmall;
			allParticles.particleList.get(i).xPosition += allParticles.particleList.get(i).xVelocity * dt;
			allParticles.particleList.get(i).yPosition += allParticles.particleList.get(i).yVelocity * dt;
			
			if(allParticles.particleList.get(i).xPosition >= centerPanel.getWidth() - allParticles.particleList.get(i).radius * 2 || allParticles.particleList.get(i).xPosition <= 0) allParticles.particleList.get(i).xVelocity *= -1;
			if(allParticles.particleList.get(i).yPosition >= centerPanel.getHeight()- allParticles.particleList.get(i).radius * 2 || allParticles.particleList.get(i).yPosition <= 0) allParticles.particleList.get(i).yVelocity *= -1;
			
			
			i++;
			}
		contactDetection(); //Detekcja kontaktu z innymi czastkami
   	   	}
		Thread.sleep(1);
		publish(allParticles);
   	}
   	return null;
	}
	
	public static class Distance {
		int index; //index
		double dd; //distance
		
		public Distance(int i, double d) {
			index = i;
			dd = d;
		}
		
		public static Comparator<Distance> compareDistance() {   
		 Comparator comp = new Comparator<Distance>(){
		     @Override
		     public int compare(Distance d1, Distance d2)
		     {
		           return d1.dd > d2.dd ? 1 : -1;
		     }        
		 };
		 return comp;
		}  
	}
	
	
	void contactDetection() {
		//Michal
		ArrayList<Distance> distances = new ArrayList<Distance>();
		int np = allParticles.particleList.size();
		for(int i=0; i<np; i++) {
			distances.add(new Distance(i, Math.sqrt( Math.pow(allParticles.particleList.get(i).xPosition + allParticles.particleList.get(i).radius, 2) + Math.pow(allParticles.particleList.get(i).yPosition + allParticles.particleList.get(i).radius, 2) ) - allParticles.particleList.get(i).radius ) );
		}
		
		Collections.sort(distances, Distance.compareDistance());
		
		for(int i=0; i<np-1; i++) {
			int ii = distances.get(i).index;
			for(int j=i+1; j<np; j++) {
				int jj = distances.get(j).index;
				double distanceFromIJ = distances.get(j).dd - distances.get(i).dd;
				
				if(2.0 * allParticles.particleList.get(ii).radius <= distances.get(j).dd - distances.get(i).dd) {
					break;	
				}
				else {
					
					if(distanceIJ(ii, jj) >= 0 ) {
						particleCollision(ii,jj);
					} 
				}
			}
		}
	}
	double distanceIJ(int ii, int jj) {
		
		return allParticles.particleList.get(ii).radius + allParticles.particleList.get(jj).radius
				- Math.sqrt(
						Math.pow(allParticles.particleList.get(ii).xPosition + allParticles.particleList.get(ii).radius - (allParticles.particleList.get(jj).xPosition + allParticles.particleList.get(jj).radius), 2) +
						Math.pow(allParticles.particleList.get(ii).yPosition + allParticles.particleList.get(ii).radius - (allParticles.particleList.get(jj).yPosition + allParticles.particleList.get(jj).radius), 2)
						);

	}
	void particleCollision(int i, int j) {
		//Michal
		double u1x, u1y, u2x, u2y;
		
		double M, m1, m2, x1, x2, y1, y2, vx1, vx2, vy1, vy2; //zmienne pomocnicze, bedzie mozna pozniej pousuwac
		
		m1 = allParticles.particleList.get(i).mass;
		m2 = allParticles.particleList.get(j).mass;
		M = m1 + m2;
		
		x1 = allParticles.particleList.get(i).xPosition + allParticles.particleList.get(i).radius;
		x2 = allParticles.particleList.get(j).xPosition + allParticles.particleList.get(j).radius;
		
		y1 = allParticles.particleList.get(i).yPosition + allParticles.particleList.get(i).radius;
		y2 = allParticles.particleList.get(j).yPosition + allParticles.particleList.get(j).radius;
		
		vx1 = allParticles.particleList.get(i).xVelocity;
		vx2 = allParticles.particleList.get(j).xVelocity;
		
		vy1 = allParticles.particleList.get(i).yVelocity;
		vy2 = allParticles.particleList.get(j).yVelocity;
		
		u1x = (2 * m2 / M) * ((vx1-vx2) * (x1-x2) + (vy1-vy2) * (y1-y2) ) / ( Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2) ) * (x1 - x2);
		u1y = (2 * m2 / M) * ((vx1-vx2) * (x1-x2) + (vy1-vy2) * (y1-y2) ) / ( Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2) ) * (y1 - y2);
		
		u2x = (2 * m1 / M) * ((vx1-vx2) * (x1-x2) + (vy1-vy2) * (y1-y2) ) / ( Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2) ) * (x2 - x1);
		u2y = (2 * m1 / M) * ((vx1-vx2) * (x1-x2) + (vy1-vy2) * (y1-y2) ) / ( Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2) ) * (y2 - y1);
		
		allParticles.particleList.get(i).xVelocity -= u1x;
		allParticles.particleList.get(i).yVelocity -= u1y;
		
		allParticles.particleList.get(j).xVelocity -= u2x;
		allParticles.particleList.get(j).yVelocity -= u2y;
		
		
	}
	
	public void setOnOff(int on_off) {
    	this.on_off = on_off;
	}
	
	void updatePositions(ParticleInfo particles) {
		//TODO do zrobienia w osobnych funkcjach
	}
	
	@Override
    protected void process(List <ParticleInfo> allParticles) {
		this.allParticles = allParticles.get(0);
		centerPanel.repaint();
    }

	public void setParticleInfo (ParticleInfo allParticles) {
		this.allParticles = allParticles;
	}

}
