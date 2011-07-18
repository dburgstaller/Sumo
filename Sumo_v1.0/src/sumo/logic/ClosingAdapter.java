package sumo.logic;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

import sumo.Constants.Constants;
/*
* Ersteller: Daniel Burgstaller
* Letzter Bearbeiter: Daniel Burgstaller
* Klassenname: ClosingAdapter
* Superklasse: WindowAdapater
* Interfaces:  
* Funktionen:
*			WindowClosing
*			saveConnectedUsers
*/
public class ClosingAdapter
extends WindowAdapter
{
	private boolean exitSystem;
	
	/**
	 * Erzeugt einen WindowClosingAdapter zum Schliessen 
	 * des Fensters. Ist exitSystem true, wird das komplette
	 * Programm beendet.
	 */
	public ClosingAdapter(boolean exitSystem)
	{
		this.exitSystem = exitSystem;
	}//#Konstruktor
	
	/**
	 * Erzeugt einen WindowClosingAdapter zum Schliessen 
	 * des Fensters. Das Programm wird nicht beendet.
	 */
	public ClosingAdapter()
	{
		this(true);
	}//#Konstruktor
	
	
	/*
* Ersteller: Daniel Burgstaller
* Funktionname: windowClosing
* Paramterliste:
*					WindowEvent event
* Funktion:
*          schlieﬂt fenster bzw. Fragt ob es wirklich geschlossen werden soll
*			Speichert td connectete User
*/
	
	public void windowClosing(WindowEvent event)
	{
		
		if (exitSystem) {
			Object[] options = {"Yes", "No"};
            int ret = JOptionPane.showOptionDialog(event.getWindow(), "User angemeldet! Wirklich schließen?", "Schließen", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.ERROR_MESSAGE,null, 
            options, options[0]);
          
			if (ret==0){
				
				saveConnectedUsers();
				event.getWindow().setVisible(false);
				event.getWindow().dispose();
				
				System.exit(0);
			}//#if
			
		}//#if
	}//#windowClosing
	
	
	/*
* Ersteller: Daniel Burgstaller
* Funktionname: saveConnectedUsers
* Paramterliste:
*					
* Funktion:
*          speichert die angemeldeten Benutzer, um einen Datenverlust zu verhindern
*/

	private void saveConnectedUsers() {
		// TODO Auto-generated method stub
		
	}//#saveConnectedUsers
}