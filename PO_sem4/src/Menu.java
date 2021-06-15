import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeriesCollection;

import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.Page;

@SuppressWarnings("serial")
public class Menu extends JMenuBar{
	
	JMenuBar menuBar;
    JMenu menuExport, menuOptions, menuLanguage, menuColors, menuItem2; 
    JMenuItem menuItem1, menuItem3, menuItemExport;
    JMenuItem submenuItem1, submenuItem2, submenuItem3;
    CenterPanel centerPanel;
	RightPanel rightPanel;
	Calculations calc; 
    Color BGColor, bigParticleColor, smallParticlesColor;
    
    public Menu() {
    	// (Michal)
    	
        menuExport = new JMenu("Export");
        this.add(menuExport);
        menuItemExport = new JMenuItem("Export big particle trajectory");
        menuItemExport.addActionListener(new ActionListener() {
        	//Michal
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.addMorePositions = false;
				
				//Chart
				XYSeriesCollection dataset = new XYSeriesCollection();
				dataset.addSeries(centerPanel.series);
				
				JFreeChart chart = ChartFactory.createXYLineChart(
						"Ruchy Browna",//Tytul
						"X", // opisy osi
						"Y", 
						dataset, // Dane 
						PlotOrientation.VERTICAL, // Orientacja wykresu /HORIZONTAL
						true, // legenda
						true, // tooltips
						false
					);
				XYPlot xyPlot = (XYPlot) chart.getPlot();
		        NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
		        domain.setRange(0.00, centerPanel.getWidth());
		        NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
		        range.setRange(0.0, centerPanel.getHeight());
		        range.setInverted(true);
		        
		        
		        String s = (String)JOptionPane.showInputDialog(null, "Choose filename:\n", "Save image...", JOptionPane.PLAIN_MESSAGE, null, null, "...");	

				PDFDocument pdfDoc = new PDFDocument();
				Page page1 = pdfDoc.createPage(new Rectangle(794, 1123));
				PDFGraphics2D gpage1 = page1.getGraphics2D();
				chart.draw(gpage1, new Rectangle(0, 0, 612, 468));
				File pdfFile = new File(s + ".pdf");
		        pdfDoc.writeToFile(pdfFile);
				
				//Plik
				File outputfile = new File(s + ".txt");	
				FileWriter fw = null;
				try {
					fw = new FileWriter(outputfile, true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedWriter bw = new BufferedWriter(fw);
				for(int i=0; i<centerPanel.positions.size(); i++) {
					try {
						bw.write(centerPanel.positions.get(i).getPosition());
						bw.newLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				try {
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        	
        });
        menuExport.add(menuItemExport);
        
        menuOptions = new JMenu("Options");
        this.add(menuOptions);
        menuItem1 = new JMenuItem("Algorithm");
        menuItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Used algorithm: Euler's method");
			}
        });
        menuOptions.add(menuItem1);
        
        
        menuItem2 = new JMenu("Boundary conditions");
        JMenuItem boundaryOn = new JMenuItem("Reflection");
        boundaryOn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc.boundary = true;
			}
        });
        menuItem2.add(boundaryOn);
        JMenuItem boundaryOff = new JMenuItem("Periodic");
        boundaryOff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc.boundary = false;
			}
        });
        menuItem2.add(boundaryOff);
        
        
        menuOptions.add(menuItem2);
        menuItem3 = new JMenuItem("Initial distribution");
        menuItem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Initial distribution: Uniform distribution");
			}
        });
        menuOptions.add(menuItem3);
        
        menuColors = new JMenu("Color theme");
        menuOptions.add(menuColors);
        
        submenuItem1 = new JMenuItem("Background color");
        submenuItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BGColor = JColorChooser.showDialog(submenuItem1, "Choose background color", getForeground());
				centerPanel.BGColor = BGColor;
			}
        });
        
        menuColors.add(submenuItem1);
        submenuItem2 = new JMenuItem("Big particle color");
        submenuItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bigParticleColor = JColorChooser.showDialog(submenuItem2, "Choose big particle color", getForeground());	
				centerPanel.colorBig = bigParticleColor;
			}
        });
        
        menuColors.add(submenuItem2);
        submenuItem3 = new JMenuItem("Small particles color");
        submenuItem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				smallParticlesColor = JColorChooser.showDialog(submenuItem3, "Choose small particles color", getForeground());	
				centerPanel.colorSmall = smallParticlesColor;
			}
        });
        
        menuColors.add(submenuItem3);
        
        menuLanguage = new JMenu("Language");
        JMenuItem menuLanEn = new JMenuItem("English");
        menuLanEn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Locale enLocale = new Locale("en");
				ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", enLocale);
				rightPanel.labelNumberSmall.setText(messages.getString("NumberSmall"));
				rightPanel.labelMassSmall.setText(messages.getString("MassSmall"));
				rightPanel.labelRadiusSmall.setText(messages.getString("RadiusSmall"));
				rightPanel.labelMassLarge.setText(messages.getString("MassLarge"));
				rightPanel.labelRadiusLarge.setText(messages.getString("RadiusLarge"));
				rightPanel.labelDisplayed.setText(messages.getString("Displayed"));
				
				rightPanel.start.setText(messages.getString("Start"));
				rightPanel.reset.setText(messages.getString("Reset"));
				
				menuExport.setText(messages.getString("Export"));
				menuItemExport.setText(messages.getString("ItemExport"));
		        
				menuOptions.setText(messages.getString("Options"));
		        menuItem1.setText(messages.getString("Algorithm"));
		        menuItem2.setText(messages.getString("Boundary")); 
		        menuItem3.setText(messages.getString("Distribution")); 
		    
		        menuColors.setText(messages.getString("Color"));
		        submenuItem1.setText(messages.getString("BgColor")); 
		        submenuItem2.setText(messages.getString("BigColor"));
		        submenuItem3.setText(messages.getString("SmallColor")); 
		        
		        menuLanguage.setText(messages.getString("Language"));
			}
        });
        menuLanguage.add(menuLanEn);
       
        JMenuItem menuLanPl = new JMenuItem("Polish");
        menuLanPl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Locale plLocale = new Locale("pl");
				ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", plLocale);
				rightPanel.labelNumberSmall.setText(messages.getString("NumberSmall"));
				rightPanel.labelMassSmall.setText(messages.getString("MassSmall"));
				rightPanel.labelRadiusSmall.setText(messages.getString("RadiusSmall"));
				rightPanel.labelMassLarge.setText(messages.getString("MassLarge"));
				rightPanel.labelRadiusLarge.setText(messages.getString("RadiusLarge"));
				rightPanel.labelDisplayed.setText(messages.getString("Displayed"));
				
				rightPanel.start.setText(messages.getString("Start"));
				rightPanel.reset.setText(messages.getString("Reset"));
				
				menuExport.setText(messages.getString("Export"));
				menuItemExport.setText(messages.getString("ItemExport"));
		        
				menuOptions.setText(messages.getString("Options"));
		        menuItem1.setText(messages.getString("Algorithm"));
		        menuItem2.setText(messages.getString("Boundary")); 
		        menuItem3.setText(messages.getString("Distribution")); 
		    
		        menuColors.setText(messages.getString("Color"));
		        submenuItem1.setText(messages.getString("BgColor")); 
		        submenuItem2.setText(messages.getString("BigColor"));
		        submenuItem3.setText(messages.getString("SmallColor")); 
		        
		        menuLanguage.setText(messages.getString("Language"));
			}
        });
        menuLanguage.add(menuLanPl);
        
        JMenuItem menuLanRu = new JMenuItem("Russian");
        menuLanRu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Locale ruLocale = new Locale("ru");
				ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", ruLocale);
				rightPanel.labelNumberSmall.setText(messages.getString("NumberSmall"));
				rightPanel.labelMassSmall.setText(messages.getString("MassSmall"));
				rightPanel.labelRadiusSmall.setText(messages.getString("RadiusSmall"));
				rightPanel.labelMassLarge.setText(messages.getString("MassLarge"));
				rightPanel.labelRadiusLarge.setText(messages.getString("RadiusLarge"));
				rightPanel.labelDisplayed.setText(messages.getString("Displayed"));
				
				rightPanel.start.setText(messages.getString("Start"));
				rightPanel.reset.setText(messages.getString("Reset"));
				
				menuExport.setText(messages.getString("Export"));
				menuItemExport.setText(messages.getString("ItemExport"));
		        
				menuOptions.setText(messages.getString("Options"));
		        menuItem1.setText(messages.getString("Algorithm"));
		        menuItem2.setText(messages.getString("Boundary")); 
		        menuItem3.setText(messages.getString("Distribution")); 
		    
		        menuColors.setText(messages.getString("Color"));
		        submenuItem1.setText(messages.getString("BgColor")); 
		        submenuItem2.setText(messages.getString("BigColor"));
		        submenuItem3.setText(messages.getString("SmallColor")); 
		        
		        menuLanguage.setText(messages.getString("Language"));
			}
        });
        menuLanguage.add(menuLanRu);
        this.add(menuLanguage);
		
	} // Koniec konstruktora
    
    public Color getBGColor() {
    	return BGColor;
    }
    
    public void setCenterPanel(CenterPanel centerPanel) {
    	this.centerPanel = centerPanel;
    }	
    
    public void setRightPanel(RightPanel rightPanel) {
    	this.rightPanel= rightPanel;
    }
    
    public void setCalculations(Calculations calc) {
    	this.calc = calc;
    }
}
