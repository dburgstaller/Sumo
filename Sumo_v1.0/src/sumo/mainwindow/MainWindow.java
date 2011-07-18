package sumo.mainwindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import sumo.Constants.Constants;
import sumo.daos.MitarbeiterDao;
import sumo.empmanagement.Employeemanagement;
import sumo.logic.ClosingAdapter;
import sumo.login.Login;
import sumo.login.Logout;
import sumo.model.Mitarbeiter;
import sumo.movieManagement.MovieManagement;

/*
 * Ersteller: Thomas Kranzer, Daniel Burgstaller
 * Klassenname: MainWindow
 * Superklasse: JWindow
 * Interfaces:
 * 				ActionListener
 * 				KeyListener
 * Funktionen:
 *				Konstruktor
 *				initComponents
 *				actionPerformed
 *				keyPressed
 *				keyReleased
 *				keyTyped
 *				logout
 *				changeUser
 *
 *
 *
 * Shortcuts:
 * 				Filme: 			F
 * 				Kassa:			K
 * 				Kunden:			U
 * 				Lager:			L
 * 				Mitarbeiter:	M
 * 				Rechnungen:		R
 * 				Verkauf:		E
 * 				Verleih:		V
 * 				Logout:			Alt+L
 * 				Benutzer:		Alt+W
 *				
 */
public class MainWindow extends JFrame implements ActionListener, KeyListener {
	JPanel all = new JPanel();
	JPanel center = new JPanel();
	JPanel bottom = new JPanel();

	JButton kassa_button, kunden_button, verleih_button, lager_button,
			mitarbeiter_button, rechnung_button, verkauf_button, filme_button;
	JButton change_user = new JButton("Benutzer wechseln");
	JButton logout = new JButton("Logout");

	JLabel loged_in_user = new JLabel("Aktiver Benutzer:");

	ImageIcon kassa_image = new ImageIcon("images/Kassa.PNG");
	ImageIcon kunden_image = new ImageIcon("images/Kunden.PNG");
	ImageIcon verleih_image = new ImageIcon("images/Verleih.PNG");
	ImageIcon lager_image = new ImageIcon("images/Lager.PNG");
	ImageIcon mitarbeiter_image = new ImageIcon(
			"images/mitarbeiterverwaltung.jpg");
	ImageIcon rechnung_image = new ImageIcon("images/Rechnung.PNG");
	ImageIcon verkauf_image = new ImageIcon("images/Verkauf.PNG");
	ImageIcon filme_image = new ImageIcon("images/Filme.PNG");

	String username;

	public MainWindow(String username) {
		super();
		
		//TODO: Handling für die Anfangszeit von Arbeit einbauen!!!!!
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		all.setBackground(Constants.cl_blue);
		all.setLayout(new BorderLayout());
		this.username = username;
		this.add(all);
		setContentPane(all);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		initComponent();
		addKeyListener(this);
		this.addWindowListener(new ClosingAdapter(true));
		
		MitarbeiterDao dao=new MitarbeiterDao();
		
		Mitarbeiter mb=dao.getMitarbeiterByUsername(username);
		
		if (!mb.getIsAdmin()){
			mitarbeiter_button.setEnabled(false);
		}
		setSize(dim);
		setVisible(true);

	}// #MainWindow

	/*
	 * Ersteller: Daniel Burgstaller, Thomas Kranzer 
	 * Funktionname:
	 * initComponents 
	 * Paramterliste: 
	 * Funktion: Initialisiert die Komponenten des
	 * Fensters
	 */
	private void initComponent() {
		center.setLayout(new GridLayout(2, 4));

		center.setBackground(Constants.cl_blue);

		kassa_button = new JButton(kassa_image);
		kassa_button.addKeyListener(this);
		kassa_button.setFocusTraversalKeysEnabled(true);
		kassa_button.setOpaque(false);
		kassa_button.setBackground(Constants.cl_orange);
		kassa_button.setBorderPainted(false);
		kassa_button.setContentAreaFilled(false);
		kassa_button.addActionListener(this);

		kunden_button = new JButton(kunden_image);
		kunden_button.addKeyListener(this);
		kunden_button.setFocusTraversalKeysEnabled(true);
		kunden_button.setOpaque(false);
		kunden_button.setBackground(Constants.cl_orange);
		kunden_button.setBorderPainted(false);
		kunden_button.setContentAreaFilled(false);
		kunden_button.addActionListener(this);

		verleih_button = new JButton(verleih_image);
		verleih_button.addKeyListener(this);
		verleih_button.setFocusTraversalKeysEnabled(true);
		verleih_button.setOpaque(false);
		verleih_button.setBackground(Constants.cl_orange);
		verleih_button.setBorderPainted(false);
		verleih_button.setContentAreaFilled(false);
		verleih_button.addActionListener(this);

		lager_button = new JButton(lager_image);
		lager_button.addKeyListener(this);
		lager_button.setFocusTraversalKeysEnabled(true);
		lager_button.setOpaque(false);
		lager_button.setBackground(Constants.cl_orange);
		lager_button.setBorderPainted(false);
		lager_button.setContentAreaFilled(false);
		lager_button.addActionListener(this);

		mitarbeiter_button = new JButton(mitarbeiter_image);
		mitarbeiter_button.setActionCommand("Mitarbeiter");
		mitarbeiter_button.addKeyListener(this);
		mitarbeiter_button.setFocusTraversalKeysEnabled(true);
		mitarbeiter_button.setOpaque(false);
		mitarbeiter_button.setBackground(Constants.cl_orange);
		mitarbeiter_button.setBorderPainted(false);
		mitarbeiter_button.setContentAreaFilled(false);
		mitarbeiter_button.addActionListener(this);

		rechnung_button = new JButton(rechnung_image);
		rechnung_button.addKeyListener(this);
		rechnung_button.setFocusTraversalKeysEnabled(true);
		rechnung_button.setOpaque(false);
		rechnung_button.setBackground(Constants.cl_orange);
		rechnung_button.setBorderPainted(false);
		rechnung_button.setContentAreaFilled(false);
		rechnung_button.addActionListener(this);

		verkauf_button = new JButton(verkauf_image);
		verkauf_button.addKeyListener(this);
		verkauf_button.setFocusTraversalKeysEnabled(true);
		verkauf_button.setOpaque(false);
		verkauf_button.setBackground(Constants.cl_orange);
		verkauf_button.setBorderPainted(false);
		verkauf_button.setContentAreaFilled(false);
		verkauf_button.addActionListener(this);

		filme_button = new JButton(filme_image);
		filme_button.setActionCommand("Film");
		filme_button.addKeyListener(this);
		filme_button.setFocusTraversalKeysEnabled(true);
		filme_button.setOpaque(false);
		filme_button.setBackground(Constants.cl_orange);
		filme_button.setBorderPainted(false);
		filme_button.setContentAreaFilled(false);
		filme_button.addActionListener(this);

		// TODO: Shortcuts erstellen und andere Felder einfügen!
		center.add(kassa_button);
		center.add(kunden_button);
		center.add(verleih_button);
		center.add(lager_button);
		center.add(mitarbeiter_button);
		center.add(rechnung_button);
		center.add(verkauf_button);
		center.add(filme_button);

		all.add(center, BorderLayout.CENTER);

		// Bottom Field

		logout.addActionListener(this);
		logout.addKeyListener(this);
		KeyStroke strg_c = KeyStroke
				.getKeyStroke('l', InputEvent.ALT_DOWN_MASK);
		// TODO: Keystroke zuweisen
		change_user.addKeyListener(this);
		change_user.addActionListener(this);

		loged_in_user.setText(loged_in_user.getText() + " " + username);
		bottom.add(loged_in_user);
		bottom.add(change_user);
		bottom.add(logout);
		all.add(bottom, BorderLayout.SOUTH);

	}// #initComponents

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd=e.getActionCommand();
		
		if (cmd.equals("Logout")){
			logout(username);
		}else{
			if (cmd.equals("Benutzer wechseln")){
				changeUser();
			}//#if
		}//#if
		
		if (cmd.equals("Mitarbeiter")){
			Employeemanagement m = new Employeemanagement();
		
		}//#if
		
		if (cmd.equals("Film")){
			MovieManagement m = new MovieManagement();
		}//#if
		
		
	}//#actionPerformed

	/*
	 * Ersteller: Daniel Burgstaller, Thomas Kranzer 
	 * Funktionname: changeUser
	 * Paramterliste: Funktion: Wechselt den Benutzer ( loggt ihn nicht aus! )
	 * sondern ein 2. benutzer kann sich anmelden
	 */
	private void changeUser() {
		// TODO Auto-generated method stub
		this.dispose();
		Login login = new Login();
	}// #changeUser

	/*
	 * Ersteller: Daniel Burgstaller Funktionname: logout Paramterliste: String
	 * name Funktion: Loggt den aktuellen User aus.
	 */
	private void logout(String name) {

		Logout l = new Logout(name);
	}// #logout

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_M) {
			System.out.println("Mitglieder");
			Employeemanagement man = new Employeemanagement();
		} else {
			if (e.getKeyCode() == KeyEvent.VK_L) {
				Logout l = new Logout(username);
			} else {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					this.dispose();
					Login l = new Login();
				}// #if
			}// #if
		}// #if
	} // # keyPressed

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}// #keyReleased

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}// #keyTyped
}// #MainWindow
