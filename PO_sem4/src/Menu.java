import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Menu extends JMenuBar{
	
	JMenuBar menuBar;
    JMenu menuExport, menuOptions, menuLanguage, menuColors;
    JMenuItem menuItem1, menuItem2, menuItem3;
    JMenuItem submenuItem1, submenuItem2, submenuItem3;
	
    Color BGColor, bigParticleColor, smallParticlesColor;
    
    public Menu() {
         
<<<<<<< Upstream, based on branch 'main' of https://github.com/AntonHul/PO_sem4.git
    	
        menuExport = new JMenu("Export");
        this.add(menuExport);
        
        menuOptions = new JMenu("Options");
        this.add(menuOptions);
        menuItem1 = new JMenuItem("Algorithm");
        menuOptions.add(menuItem1);
        menuItem2 = new JMenuItem("Boundary conditions");
        menuOptions.add(menuItem2);
        menuItem3 = new JMenuItem("Initial distribution");
        menuOptions.add(menuItem3);
        
        menuColors = new JMenu("Color theme");
        menuOptions.add(menuColors);
        
        submenuItem1 = new JMenuItem("Background color");
        submenuItem1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BGColor = JColorChooser.showDialog(submenuItem1, "Choose background color", getForeground());
				
			}
        	
        	
        });
        menuColors.add(submenuItem1);
        submenuItem2 = new JMenuItem("Big particle color");
        submenuItem2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bigParticleColor = JColorChooser.showDialog(submenuItem2, "Choose big particle color", getForeground());
				
			}
        	
        	
        });
        menuColors.add(submenuItem2);
        submenuItem3 = new JMenuItem("Small particles color");
        submenuItem3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				smallParticlesColor = JColorChooser.showDialog(submenuItem3, "Choose small particles color", getForeground());
				
			}
        	
        	
        });
        menuColors.add(submenuItem3);
        
        menuLanguage = new JMenu("Language");
        this.add(menuLanguage);
        
=======
          menuOptions = new JMenu("Options");
          this.add(menuOptions);
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
         
          menuLanguage = new JMenu("Language fsfsefsfssfsfsfs");
          this.add(menuLanguage);
         
          
>>>>>>> 37c7f0e test
	}

}
