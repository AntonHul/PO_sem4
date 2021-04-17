import java.awt.Color;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingWorker;


@SuppressWarnings("serial")
public class Calculations extends SwingWorker<Void, ParticleInfo>{
	CenterPanel centerPanel;
	int on_off;
	
	double dt;
	double massSmall, massLarge;
	ParticleInfo allParicles;

	public Calculations() {
    	 Random rand = new Random();
    	 allParicles = new ParticleInfo();
    	 on_off = 1;
	} 


    public void setCenterPanel(CenterPanel centerPanel) {
    	this.centerPanel = centerPanel;
    }	 
    
    //Obliczenia

	@Override
	protected Void doInBackground() throws Exception {
   	
   	Random rand = new Random();
   	while(on_off == 1) {
   		allParicles.xVelocity.clear();
   		allParicles.yVelocity.clear();
   		allParicles.xPosition.clear(); 
   		allParicles.yPosition.clear();
   		allParicles.xVelocity.add(0.0);
   		allParicles.yVelocity.add(0.0);
   		allParicles.xPosition.add(470);
   		allParicles.yPosition.add(240);
   		int i = 1;
		while (allParicles.numberSmall >= i)  {
			allParicles.xVelocity.add(rand.nextDouble()*10); 
			allParicles.yVelocity.add(rand.nextDouble()*10); 
			allParicles.xPosition.add(rand.nextInt(1100)); 
			allParicles.yPosition.add(rand.nextInt(700)); 
			i++;
			}
		publish(allParicles);
   		}
   	return null;
	}
	
	protected void process(ParticleInfo allParicles) {
		centerPanel.setAllParicles(allParicles);
		System.out.println(allParicles.numberSmall);
	}
	
	public void setNumberSmall(int numberSmall) {
		this.allParicles.numberSmall = numberSmall;
	}

}
