
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class GUI extends JFrame{

	RightPanel rightPanel;
	CenterPanel centerPanel;
	Menu menu;
	
	public GUI() throws HeadlessException {
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
	
	menu = new Menu();
	this.setJMenuBar(menu);
		
	//Right panel, ustawienie parametrów (Anton)
	rightPanel = new RightPanel();
	this.add(rightPanel, BorderLayout.LINE_END);
	
	
	//Center panel (Micha³)
	centerPanel = new CenterPanel();
	this.add(centerPanel, BorderLayout.CENTER);

	rightPanel.setCenterPanel(centerPanel);
	
	} // Koniec konstruktora
	
	public static void main(String[] args) {
		GUI mainFrame = new GUI();
		mainFrame.setTitle("Brownian motion simulation");
		mainFrame.setVisible(true);

	}
}