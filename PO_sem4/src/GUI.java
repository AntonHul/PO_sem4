
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class GUI extends JFrame{

	RightPanel rightPanel;
	ParticleInfo allParticles;
	Menu menu;
	
	public GUI() throws HeadlessException {
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
	
		
		menu = new Menu();
		this.setJMenuBar(menu);
		
		//Right panel, ustawienie parametrów (Anton)
		allParticles = new ParticleInfo(10, 1.0, 5.0, 20.0, 100.0);
		rightPanel = new RightPanel(allParticles);
		rightPanel.initialParam();
		rightPanel.setParticleInfo(allParticles);
		
		this.add(rightPanel, BorderLayout.LINE_END);
} 
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI mainFrame = new GUI();
				mainFrame.setTitle("Brownian motion simulation");
				mainFrame.setVisible(true);

				//obliczenia 
				
				Calculations counter = new Calculations(mainFrame.allParticles);
				
				CenterPanel centerPanel = new CenterPanel(counter.allParticles);
				mainFrame.add(centerPanel, BorderLayout.CENTER);	
				counter.setCenterPanel(centerPanel);
				
				mainFrame.rightPanel.setCalculations(counter);
				
				//Watki
				ExecutorService exec = Executors.newFixedThreadPool(2);
				exec.execute(counter);
				exec.shutdown();
			
			}
		});
	}
}