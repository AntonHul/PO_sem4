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

@SuppressWarnings("serial")
public class RightPanel extends JPanel {

	JLabel labelNumberSmall, labelMassSmall, labelRadiusSmall, labelMassLarge, labelRadiusLarge, labelDisplayed;
	JTextField textNumberSmall, textMassSmall,textRadiusSmall, textMassLarge, textRadiusLarge, textDisplayed;
	JButton reset, start;
	
	int on_off;
	int numberSmall;
	double valueMassSmall, valueRadiusSmall, valueMassLarge, valueRadiusLarge, valueDisplayed;
	CenterPanel centerPanel;
	
	public RightPanel() {
		this.setLayout(new GridLayout(0, 1, 10, 10));
		on_off = 0;
		
		labelNumberSmall = new JLabel("The number of small molecules:");
		labelNumberSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelNumberSmall);
		textNumberSmall = new JTextField();
		textNumberSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textNumberSmall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberSmall = Integer.parseInt(textNumberSmall.getText());
				centerPanel.setNumberSmall(numberSmall);
			}});
		this.add(textNumberSmall);
	
		labelMassSmall = new JLabel("The mass of the small molecules:");
		labelMassSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelMassSmall);
		textMassSmall = new JTextField();
		textMassSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textMassSmall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valueMassSmall = Double.parseDouble(textMassSmall.getText());
				centerPanel.setValueMassSmall(valueMassSmall);
			}});
		this.add(textMassSmall);
		
		labelRadiusSmall = new JLabel("The radius of the small molecules:");
		labelRadiusSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelRadiusSmall);
		textRadiusSmall = new JTextField();
		textRadiusSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textRadiusSmall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valueRadiusSmall = Double.parseDouble(textRadiusSmall.getText());
				centerPanel.setValueRadiusSmall(valueRadiusSmall);
			}});
		this.add(textRadiusSmall);
		
		labelMassLarge = new JLabel("The mass of the large molecule:");
		labelMassLarge.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelMassLarge);
		textMassLarge = new JTextField();
		textMassLarge.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textMassLarge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valueMassLarge = Double.parseDouble(textMassLarge.getText());
				centerPanel.setValueMassLarge(valueMassLarge);
			}});
		this.add(textMassLarge);
		
		labelRadiusLarge = new JLabel("The radius of the large molecule:");
		labelRadiusLarge.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelRadiusLarge);
		textRadiusLarge = new JTextField();
		textRadiusLarge.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textRadiusLarge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valueRadiusLarge = Double.parseDouble(textRadiusLarge.getText());
				centerPanel.setValueRadiusLarge(valueRadiusLarge);
			}});
		this.add(textRadiusLarge);
	
		labelDisplayed = new JLabel("The number of displayed molecules:");
		labelDisplayed.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add( labelDisplayed);
		textDisplayed = new JTextField();
		textDisplayed.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textDisplayed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valueDisplayed = Double.parseDouble(textDisplayed.getText());
				centerPanel.setValueDisplayed(valueDisplayed);
			}});
		this.add(textDisplayed);
	
		reset = new JButton("RESET");
		reset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO update parametrow symulacji
				numberSmall = 10;
				textNumberSmall.setText(Integer.toString(numberSmall));
				centerPanel.setNumberSmall(numberSmall);
				
				valueMassSmall = 1;
				textMassSmall.setText(Double.toString(valueMassSmall));
				centerPanel.setValueMassSmall(valueMassSmall);
				
				valueRadiusSmall = 1;
				textRadiusSmall.setText(Double.toString(valueRadiusSmall));
				centerPanel.setValueRadiusSmall(valueRadiusSmall);
				
				valueMassLarge = 1;
				textMassLarge.setText(Double.toString(valueMassLarge));
				centerPanel.setValueMassLarge(valueMassLarge);
				
				valueRadiusLarge = 1;
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
	
	public int getNumberSmall() {
		return numberSmall;
	}
	
	public double getValueMassSmall() {
		return valueMassSmall;
	}

	public double getValueRadiusSmall() {
		return valueRadiusSmall;
	}

	public double getValueMassLarge() {
		return valueMassLarge;
	}

	public double getValueRadiusLarge() {
		return valueRadiusLarge;
	}

	public double getValueDisplayed() {
		return valueDisplayed;
	}

}
