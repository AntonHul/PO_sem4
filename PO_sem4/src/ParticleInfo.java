import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParticleInfo {
	
	List<Double> yVelocity, xVelocity; 
	List<Integer> xPosition, yPosition;
	int numberSmall;
	public ParticleInfo() {
		xVelocity = new ArrayList <Double>();
		xVelocity.add(0.0);
		yVelocity = new ArrayList <Double>();
		yVelocity.add(0.0);
		xPosition = new ArrayList <Integer>();
		xPosition.add(470);
		yPosition = new ArrayList <Integer>();
		yPosition.add(240);
		numberSmall = 10;
		 
		int i = 1;
	   	Random rand = new Random();
	    while (numberSmall >= i)  {
	   		xVelocity.add(rand.nextDouble()*10); 
	   		yVelocity.add(rand.nextDouble()*10); 
	   		xPosition.add(rand.nextInt(600)); 
	   		yPosition.add(rand.nextInt(700)); 
	   		i++;
	   	 }
	}
}
