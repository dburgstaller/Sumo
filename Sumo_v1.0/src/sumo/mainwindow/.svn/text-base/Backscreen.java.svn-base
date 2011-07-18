package sumo.mainwindow;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

import sumo.Constants.Constants;


/*
* Ersteller: Daniel Burgstaller, Christian BAuer
* Klassenname: Backscreen
* Superklasse: JWindow
* Interfaces: - 
* Funktionen:
*				Konstruktor
*/
public class Backscreen extends JWindow {
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	ImageIcon logo = new ImageIcon("images/logo.png");

	JPanel all=new JPanel();

	public Backscreen(){
		super();
		this.setSize(dim);
		
		all.setBackground(Constants.cl_blue);
		all.setSize(dim);
		all.setLayout(new BorderLayout());
		
		all.add(new JLabel(logo,JLabel.HORIZONTAL),BorderLayout.NORTH);
		all.add(new JLabel("Copyright by Daniel Burgstaller, Christian Bauer, Thomas Kranzer, Patrick Fršschl"),BorderLayout.SOUTH);
		
		
		this.add(all);
		this.setVisible(true);
		
		
	}
}
