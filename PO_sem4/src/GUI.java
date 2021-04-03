
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


public class GUI extends JFrame{

	RightPanel rightPanel;
	Menu menu;
	
	public GUI() throws HeadlessException {
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
	
	menu = new Menu();
	this.setJMenuBar(menu);
		
	//Right panel, ustawienie parametr�w (Anton)
	rightPanel = new RightPanel();
	this.add(rightPanel, BorderLayout.LINE_END);
	
	
	
	
	
	
	}
	
	public static void main(String[] args) {
		GUI mainFrame = new GUI();
		mainFrame.setTitle("Brownian motion simulation");
		mainFrame.setVisible(true);

	}
}