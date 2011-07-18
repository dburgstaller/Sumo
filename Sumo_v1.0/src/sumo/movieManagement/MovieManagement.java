package sumo.movieManagement;


import java.awt.Event;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sumo.Constants.Constants;

import org.hibernate.annotations.Entity;

/*
* Ersteller: Thomas Kranzer
* Letzter Bearbeiter: Thomas Kranzer
* Klassenname: MovieManagement
* Superklasse: JFrame
* Interfaces: ActionListener, KeyListener 
* Funktionen:
	
*/

public class MovieManagement extends JFrame implements ActionListener, KeyListener{
	
	JPanel panel_center;
	
	public MovieManagement(){
		super("Filmverwaltung");
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(dim);
		
		panel_center = new JPanel();
		panel_center.setBackground(Constants.cl_blue);
		this.setLayout(new BorderLayout());
		
		this.add(panel_center, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean action(Event arg0, Object arg1) {
		// TODO Auto-generated method stub
		return super.action(arg0, arg1);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
