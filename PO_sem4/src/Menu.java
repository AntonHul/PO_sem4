import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	
	JMenuBar menuBar;
    JMenu menuExport, menuOptions, menuLanguage, menuColors;
    JMenuItem menuItem1, menuItem2, menuItem3;
    JMenuItem submenuItem1, submenuItem2, submenuItem3;
	
    public Menu() {
          
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
          menuColors.add(submenuItem1);
          submenuItem2 = new JMenuItem("Big particle color");
          menuColors.add(submenuItem2);
          submenuItem3 = new JMenuItem("Small particles color");
          menuColors.add(submenuItem3);
         
          menuLanguage = new JMenu("Language");
          this.add(menuLanguage);
         
	}

}
