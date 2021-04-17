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
	int numberSmall;
	double valueMassSmall, valueRadiusSmall, valueMassLarge, valueRadiusLarge, valueDisplayed;
	CenterPanel centerPanel;
	Calculations counter;
	
	public RightPanel() {
		this.setLayout(new GridLayout(0, 1, 10, 10));
		on_off = 0;
		
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
					counter.setNumberSmall(numberSmall);
				}
				catch(NumberFormatException e) {}
			}});
		this.add(textNumberSmall);
	
		labelMassSmall = new JLabel("The mass of the small molecules:");
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
					centerPanel.setValueMassSmall(valueMassSmall);
				}
				catch(NumberFormatException e) {}
			}});
		this.add(textMassSmall);
		
		labelRadiusSmall = new JLabel("The radius of the small molecules:");
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
					centerPanel.setValueRadiusSmall(valueRadiusSmall);
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
					centerPanel.setValueMassLarge(valueMassLarge);
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
					centerPanel.setValueRadiusLarge(valueRadiusLarge);
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
					valueDisplayed = Double.parseDouble(textDisplayed.getText());
					centerPanel.setValueDisplayed(valueDisplayed);
				}	
				catch(NumberFormatException e) {}
			}});
		this.add(textDisplayed);
	
		reset = new JButton("RESET");
		reset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO update parametrow symulacji
				numberSmall = 10;
				textNumberSmall.setText(Integer.toString(numberSmall));
				counter.setNumberSmall(numberSmall);
				
				valueMassSmall = 1;
				textMassSmall.setText(Double.toString(valueMassSmall));
				centerPanel.setValueMassSmall(valueMassSmall);
				
				valueRadiusSmall = 10;
				textRadiusSmall.setText(Double.toString(valueRadiusSmall));
				centerPanel.setValueRadiusSmall(valueRadiusSmall);
				
				valueMassLarge = 1;
				textMassLarge.setText(Double.toString(valueMassLarge));
				centerPanel.setValueMassLarge(valueMassLarge);
				
				valueRadiusLarge = 200;
				textRadiusLarge.setText(Double.toString(valueRadiusLarge));
				centerPanel.setValueRadiusLarge(valueRadiusLarge);
				
				valueDisplayed = 1;
				textDisplayed.setText(Double.toString(valueDisplayed));
				centerPanel.setValueDisplayed(valueDisplayed);
				//repaint centralnego panelu	

			}
		});
		this.add(reset);
		
		start = new JButton("START/STOP");
		start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO update parametrow symulacji
				if (on_off == 0) {
					on_off = 1;
				}else{
					on_off = 0;
				}
			}
		});
		this.add(start);
	}
	
	public void setCenterPanel(CenterPanel centerPanel_) {
		this.centerPanel = centerPanel_;
	}
	
	public void setCalculations(Calculations counter) {
		this.counter = counter;
	}

}
