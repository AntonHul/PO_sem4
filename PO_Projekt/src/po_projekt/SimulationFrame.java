package po_projekt;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class SimulationFrame extends JFrame {

	JMenuBar menuBar;
	JMenu menuExport, menuOptions, menuLanguage, menuColors;
	JMenuItem menuItem1, menuItem2, menuItem3;
	JMenuItem submenuItem1, submenuItem2, submenuItem3;
	
	JPanel centerPanel, eastPanel;
	
	JTextField visibleParticlesNTextField, smallParticlesNTextField, smallParticlesMTextField, smallParticlesRTextField, bigParticleMTextField, bigParticleRTextField;
	
	JButton resetButton, startStopButton;
	
	int visibleParticlesN, smallParticlesN;
	double smallParticlesM, smallParticlesR, bigParticleM, bigParticleR;
	
	
	public SimulationFrame() throws HeadlessException {
		
		visibleParticlesN=100;
		smallParticlesN=1000;
		
		smallParticlesM=1.0;
		smallParticlesR=1.0; 
		bigParticleM=10.0;
		bigParticleR=10.0;
		
		
		// FRAME
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(840,640);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		this.setTitle("Brownian motion simulation");
		
		// MENU
		menuBar = new JMenuBar();
		
		menuExport = new JMenu("Export");
		menuBar.add(menuExport);
		
		menuOptions = new JMenu("Options");
		menuBar.add(menuOptions);
		menuItem1 = new JMenuItem("Algorithm");
		menuOptions.add(menuItem1);
		menuItem2 = new JMenuItem("Boundary conditions");
		menuOptions.add(menuItem2);
		menuItem3 = new JMenuItem("Initial distribution");
		menuOptions.add(menuItem3);
		
		menuColors = new JMenu("Color theme");
		menuOptions.add(menuColors);
		
		submenuItem1 = new JMenuItem("Background color");
		menuColors.add(submenuItem1);
		submenuItem2 = new JMenuItem("Big particle color");
		menuColors.add(submenuItem2);
		submenuItem3 = new JMenuItem("Small particles color");
		menuColors.add(submenuItem3);
		
		menuLanguage = new JMenu("Language");
		menuBar.add(menuLanguage);
		
		this.setJMenuBar(menuBar);
		
		// MAIN PANEL
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.white);
		this.add(centerPanel, BorderLayout.CENTER);
		
		// EAST PANEL
		eastPanel = new JPanel();
		eastPanel.setBackground(new Color(255,241,194,215));
		eastPanel.setPreferredSize(new Dimension(200,480));
		eastPanel.setLayout(new GridLayout(9,1));
		this.add(eastPanel, BorderLayout.EAST);
		
		visibleParticlesNTextField = new JTextField(String.format("%d", visibleParticlesN));
		visibleParticlesNTextField.setPreferredSize(new Dimension(20,10));
		eastPanel.add(visibleParticlesNTextField);
		
		smallParticlesNTextField = new JTextField(String.format("%d", smallParticlesN));
		eastPanel.add(smallParticlesNTextField);
		
		smallParticlesMTextField = new JTextField(String.format("%.3f", smallParticlesM));
		eastPanel.add(smallParticlesMTextField);
		
		smallParticlesRTextField = new JTextField(String.format("%.3f", smallParticlesR));
		eastPanel.add(smallParticlesRTextField);
		
		bigParticleMTextField = new JTextField(String.format("%.3f", bigParticleM));
		eastPanel.add(bigParticleMTextField);
		
		bigParticleRTextField = new JTextField(String.format("%.3f", bigParticleR));
		eastPanel.add(bigParticleRTextField);
		
		eastPanel.add(new JPanel()); // Dummy panel
		
		resetButton = new JButton("RESET");
		eastPanel.add(resetButton);
		
		startStopButton = new JButton("START/STOP");
		eastPanel.add(startStopButton);
		
	} // KONIEC KONSTRUKTORA
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimulationFrame frame = new SimulationFrame();
		frame.setVisible(true);

	}

} // KONIEC KLASY SimulationFrame
