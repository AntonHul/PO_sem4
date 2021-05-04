import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParticleInfo {
	
	int numberSmall, numberSmallTmp, valueDisplayed;
	double valueMassSmall, valueRadiusSmall, valueMassLarge, valueRadiusLarge;
	
	List<Particle> particleList;
	
	public ParticleInfo(int numberSmall, double valueMassSmall, double valueRadiusSmall, double valueMassLarge, double valueRadiusLarge) {
		this.numberSmallTmp = numberSmall;
		this.valueMassSmall = valueMassSmall;
		this.valueRadiusSmall = valueRadiusSmall;
		this.valueMassLarge = valueMassLarge;
		this.valueRadiusLarge = valueRadiusLarge; 
		this.numberSmall = 10;
		
		particleList = new ArrayList<Particle>();
		particleList.add(new Particle(470.0, 240.0, 0.0, 0.0, valueRadiusLarge, valueMassLarge)); //big particle
		
		int i = 1;
		int dup = 0;
		double x = 0;
		double y = 0;
	   	Random rand = new Random();
	    while (numberSmall >= i)  {
	    	while (dup == 0) {
	    		x = rand.nextDouble()*1000;
	    		y = rand.nextDouble()*600;
	    		for (int j = 0; j < i; j++) {
	    			if((x >= particleList.get(j).xPosition - 2*valueRadiusSmall && x <= particleList.get(j).xPosition + particleList.get(j).radius*2) &&
	    					 (y >= particleList.get(j).yPosition - 2*valueRadiusSmall && y <= particleList.get(j).yPosition + particleList.get(j).radius*2)) 
	    					 dup = 1;
	    		}
	    		if (dup == 1) dup = 0;
	    		else break;
	    	}
	    particleList.add(new Particle(x, y, rand.nextDouble()*10, rand.nextDouble()*10, valueRadiusSmall, valueMassSmall));
	    dup = 0;
	    i++;
	    }
	}
}

 class Particle {
	double xPosition, yPosition, xVelocity, yVelocity;
	double radius, mass;
	
	Particle(double xPos, double yPos, double xVel, double yVel, double rad, double mss){
		xPosition = xPos;
		yPosition = yPos;
		xVelocity = xVel;
		yVelocity = yVel;
		radius = rad;
		mass = mss;
	}
}