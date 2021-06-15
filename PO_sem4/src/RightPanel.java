import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class RightPanel extends JPanel{ 

	JLabel labelNumberSmall, labelMassSmall, labelRadiusSmall, labelMassLarge, labelRadiusLarge, labelDisplayed;
	JTextField textNumberSmall, textMassSmall,textRadiusSmall, textMassLarge, textRadiusLarge, textDisplayed;
	JButton reset, start;
	
	int on_off;
	int numberSmall, valueDisplayed;
	double valueMassSmall, valueRadiusSmall, valueMassLarge, valueRadiusLarge;
	Calculations counter;
	ParticleInfo particles; 
	CenterPanel centerPanel;
	
	public RightPanel(ParticleInfo particles) {
		this.setLayout(new GridLayout(0, 1, 10, 10));	
		on_off = 0;
		
		this.particles = particles;
		
		labelNumberSmall = new JLabel("The number of small molecules:");
		labelNumberSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelNumberSmall);
		textNumberSmall = new JTextField();
		textNumberSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textNumberSmall.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void warn() throws NumberFormatException {
				try {
				if(!textNumberSmall.getText().equals(""))
					numberSmall = Integer.parseInt(textNumberSmall.getText());
					particles.numberSmallTmp = numberSmall;
				}
				catch(NumberFormatException e) {}
			}});
		this.add(textNumberSmall);

		
		
		labelMassSmall = new JLabel("The mass of small molecules:");
		labelMassSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelMassSmall);
		textMassSmall = new JTextField();
		textMassSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textMassSmall.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void warn() throws NumberFormatException {
				try {
				if(!textMassSmall.getText().equals(""))
					valueMassSmall = Double.parseDouble(textMassSmall.getText());
					particles.valueMassSmall = valueMassSmall;
				}
				catch(NumberFormatException e) {}
			}});
		this.add(textMassSmall);
		
		labelRadiusSmall = new JLabel("The radius of small molecules:");
		labelRadiusSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelRadiusSmall);
		textRadiusSmall = new JTextField();
		textRadiusSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textRadiusSmall.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void warn()  throws NumberFormatException {
				try {
				if(!textRadiusSmall.getText().equals(""))
					valueRadiusSmall = Double.parseDouble(textRadiusSmall.getText());
					particles.valueRadiusSmall  = valueRadiusSmall;
				}
				catch(NumberFormatException e) {}
			}});
		this.add(textRadiusSmall);
		
		labelMassLarge = new JLabel("The mass of the large molecule:");
		labelMassLarge.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelMassLarge);
		textMassLarge = new JTextField();
		textMassLarge.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textMassLarge.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void warn() throws NumberFormatException {
				try {
				if(!textMassLarge.getText().equals(""))
					valueMassLarge = Double.parseDouble(textMassLarge.getText());
					particles.valueMassLarge = valueMassLarge;
				}
				catch(NumberFormatException e) {}
			}});
		this.add(textMassLarge);
		
		labelRadiusLarge = new JLabel("The radius of the large molecule:");
		labelRadiusLarge.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelRadiusLarge);
		textRadiusLarge = new JTextField();
		textRadiusLarge.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textRadiusLarge.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void warn() throws NumberFormatException {
				try {
				if(!textRadiusLarge.getText().equals(""))
					valueRadiusLarge = Double.parseDouble(textRadiusLarge.getText());
					particles.valueRadiusLarge  = valueRadiusLarge;
				}	
				catch(NumberFormatException e) {}
			}});
		this.add(textRadiusLarge);
	
		labelDisplayed = new JLabel("The number of displayed molecules:");
		labelDisplayed.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add( labelDisplayed);
		textDisplayed = new JTextField();
		textDisplayed.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textDisplayed.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void warn() throws NumberFormatException {
				try {
				if(!textDisplayed.getText().equals(""))
					valueDisplayed = Integer.parseInt(textDisplayed.getText());
				}	
				catch(NumberFormatException e) {}
			}});
		this.add(textDisplayed);
	
//Button RESET	
		
		reset = new JButton("RESET");
		reset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO update parametrow symulacji
				
				centerPanel.clearPositions();
				on_off = 0;
				counter.setOnOff(on_off);
				centerPanel.addMorePositions = false;
				
				numberSmall = 10;
				textNumberSmall.setText(Integer.toString(numberSmall));
				particles.numberSmallTmp  = numberSmall;
				
				valueMassSmall = 1;
				textMassSmall.setText(Double.toString(valueMassSmall));
				particles.valueMassSmall = valueMassSmall;
				
				valueRadiusSmall = 5;
				textRadiusSmall.setText(Double.toString(valueRadiusSmall));
				particles.valueRadiusSmall = valueRadiusSmall;
				
				valueMassLarge = 20;
				textMassLarge.setText(Double.toString(valueMassLarge));
				particles.valueMassLarge  = valueMassLarge;
				
				valueRadiusLarge = 100;
				textRadiusLarge.setText(Double.toString(valueRadiusLarge));
				particles.valueRadiusLarge  = valueRadiusLarge;
				
				valueDisplayed = 10;
				textDisplayed.setText(Double.toString(valueDisplayed));
			}
		});
		this.add(reset);
	
//Button START/STOP
		
		start = new JButton("START/STOP");
		start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(centerPanel.addMorePositions == true) centerPanel.addMorePositions = false;
				else centerPanel.addMorePositions = true;
				
				if (on_off == 0) {
					on_off = 1;
				}else{
					on_off = 0;
				}
				counter.setOnOff(on_off);
			}
		});
		this.add(start);
	}
	
//Warunki poczatkowe
	
	public void initialParam() {
			numberSmall = 10;
			textNumberSmall.setText(Integer.toString(numberSmall));
			
			valueMassSmall = 1;
			textMassSmall.setText(Double.toString(valueMassSmall));
			
			valueRadiusSmall = 5;
			textRadiusSmall.setText(Double.toString(valueRadiusSmall));
			
			valueMassLarge = 20;
			textMassLarge.setText(Double.toString(valueMassLarge));
			
			valueRadiusLarge = 100;
			textRadiusLarge.setText(Double.toString(valueRadiusLarge));
	
			valueDisplayed = 10;
			textDisplayed.setText(Double.toString(valueDisplayed));
	}
	
	public void setCalculations(Calculations counter) {
		this.counter = counter;
	}
	
	public void setParticleInfo(ParticleInfo particles) {
		this.particles = particles;
	}
	
	public void setCenterPanel(CenterPanel centerPanel) {
    	this.centerPanel = centerPanel;
    }	
}
