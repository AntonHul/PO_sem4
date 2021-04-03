import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RightPanel extends JPanel {

	JLabel labelNumberSmall, labelMassSmall, labelRadiusSmall, labelMassLarge, labelRadiusLarge, labelDisplayed;
	JTextField textNumberSmall, textMassSmall,textRadiusSmall, textMassLarge, textRadiusLarge, textDisplayed;
	JButton reset, start;
	
	
	public RightPanel() {
		this.setLayout(new GridLayout(0, 1, 10, 10));
		
		labelNumberSmall = new JLabel("The number of small molecules:");
		labelNumberSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelNumberSmall);
		textNumberSmall = new JTextField();
		textNumberSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(textNumberSmall);
	
		labelMassSmall = new JLabel("The mass of the small molecules:");
		labelMassSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelMassSmall);
		textMassSmall = new JTextField();
		textMassSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(textMassSmall);
		
		labelRadiusSmall = new JLabel("The radius of the small molecules:");
		labelRadiusSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelRadiusSmall);
		textRadiusSmall = new JTextField();
		textRadiusSmall.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(textRadiusSmall);
		
		labelMassLarge = new JLabel("The mass of the large molecule:");
		labelMassLarge.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelMassLarge);
		textMassLarge = new JTextField();
		textMassLarge.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(textMassLarge);
		
		labelRadiusLarge = new JLabel("The radius of the large molecule:");
		labelRadiusLarge.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(labelRadiusLarge);
		textRadiusLarge = new JTextField();
		textRadiusLarge.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(textRadiusLarge);
	
		labelDisplayed = new JLabel("The number of displayed molecules:");
		labelDisplayed.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add( labelDisplayed);
		textDisplayed = new JTextField();
		textDisplayed.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		this.add(textDisplayed);
	
		reset = new JButton("RESET");
		this.add(reset);
		
		start = new JButton("START/STOP");
		this.add(start);
	}
}
