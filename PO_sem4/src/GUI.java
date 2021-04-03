
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
	
	public GUI() throws HeadlessException {
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
	
		//Menu górne (Anton)
		JMenuBar mainMenuBar = new JMenuBar();
		this.setJMenuBar(mainMenuBar);
		
		JMenu menuFile = new JMenu("File");
		mainMenuBar.add(menuFile);
		
		//Button export (Anton)
		JMenuItem menuFileExport = new JMenuItem("Export");
		menuFileExport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}});
		menuFile.add(menuFileExport);
	
		//Button import (Anton)
		JMenuItem menuFileImport = new JMenuItem("Import");
		menuFileImport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}});
		menuFile.add(menuFileImport);
	
		//Menu settings (Anton)
		JMenu menuSet = new JMenu("Settings");
		mainMenuBar.add(menuSet);
		
		//Button koloru (Anton)
		JMenuItem menuSetColor = new JMenuItem("Colour");
		menuSetColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}});
		menuSet.add(menuSetColor);
	
	//Right panel, ustawienie parametrów (Anton)
	rightPanel = new RightPanel();
	this.add(rightPanel, BorderLayout.LINE_END);
	
	
	
	
	
	
	}
	
	public static void main(String[] args) {
		GUI mainFrame = new GUI();
		mainFrame.setTitle("Symulacja ruchów Browna");
		mainFrame.setVisible(true);

	}
}