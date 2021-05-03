import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParticleInfo {
	
	int numberSmall, numberSmallTmp;
	
	List<Particle> particleList;
	
	public ParticleInfo() {
		numberSmall = 10;
		
		particleList = new ArrayList<Particle>();
		particleList.add(new Particle(470.0, 240.0, 0.0, 0.0, 100.0, 10.0)); //big particle
		
		int i = 1;
	   	Random rand = new Random();
	    while (numberSmall >= i)  {
	    	particleList.add(new Particle(rand.nextDouble()*600, rand.nextDouble()*700, rand.nextDouble()*10, rand.nextDouble()*10, 10.0, 1.0));
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