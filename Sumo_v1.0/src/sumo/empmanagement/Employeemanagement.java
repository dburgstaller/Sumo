package sumo.empmanagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jCharts.chartData.ChartDataException;

import sumo.Constants.Constants;
import sumo.daos.MitarbeiterDao;
import sumo.daos.MitarbeiterstundenDao;
import sumo.login.Logout;
import sumo.model.Mitarbeiter;
import sumo.model.Mitarbeiterstunde;

/*
* Ersteller: Christian Bauer, Daniel Burgstaller, Thomas Kranzer
* Letzter Bearbeiter: Daniel Burgstaller
* Klassenname: Employeemanagement
* Superklasse: JFram
* Interfaces: ActionListener, KeyListener 
* Funktionen:
*			createEmployee
*			editEmployee
*			deleteEmployee
*			print
*			actionPerformed
*			KeyPressed
*			KeyReleased
*			Key		
*/

public class Employeemanagement extends JFrame implements ActionListener,KeyListener,PropertyChangeListener,ItemListener{
	JPanel mainPanel = new JPanel();
	JPanel northside = new JPanel();
	JTable centerside = new JTable();
	JPanel southside = new JPanel();
	JPanel search_panel = new JPanel();
	JPanel image_panel = new JPanel();
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc;
	JScrollPane scrollpane_center;
	ImageIcon logo = new ImageIcon("images/mitarbeiterverwaltung_kl.jpg");
	JTextField search = new JTextField("Mitarbeitersuche");
	JComboBox filter = new JComboBox();

	JButton create = new JButton("<html>Mitarbeiter <U>e</U>rstellen</font></blink></html>");

	JButton show = new JButton("Mitarbeiter anzeigen");
	
	JButton print = new JButton ("Drucken");
	JButton stat=new JButton("Statistiken");
	JButton close=new JButton("Schlie§en");
	
	public Employeemanagement(){
		super("Mitarbeiter");
		close.setActionCommand("Close");
		addKeyListener(this);
		
		northside.setBackground(Constants.cl_blue);
		centerside.setBackground(Constants.cl_blue);
		
		search_panel.setBackground(Constants.cl_blue);
		fillFilter();
		setLayout(new BorderLayout());
		search.addKeyListener(this);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(dim);
		search_panel.setLayout(new GridLayout(1,2,30,30));
		search_panel.add(search);
	
		search_panel.add(filter);
		
		image_panel.setLayout(new BorderLayout());
		image_panel.add(new JLabel(logo));
		northside.setLayout(new FlowLayout());
		northside.add(image_panel, BorderLayout.WEST);
		northside.setLocation(0, 0);
		northside.add(search_panel, BorderLayout.EAST);
		//northside.add(new JLabel());
		//northside.add(search_panel);
		
		southside.setLayout(new FlowLayout());	
		create.addActionListener(this);
		show.addActionListener(this);
		
	stat.addActionListener(this);
	
		print.addActionListener(this);
		
		close.addActionListener(this);
		
		southside.add(create);
		southside.add(show);
		
		southside.add(print);
		southside.add(stat);
		southside.add(close);
		
		centerside=createCenter();
		scrollpane_center = new JScrollPane(centerside);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(northside, BorderLayout.NORTH);
		mainPanel.add(scrollpane_center, BorderLayout.CENTER);
		mainPanel.add(southside, BorderLayout.SOUTH);
		mainPanel.setBackground(Constants.cl_blue);
		this.add(mainPanel);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	private void fillFilter() {
		MitarbeiterDao dao=new MitarbeiterDao();
		List<Mitarbeiter> mb=dao.getMitarbeiter();
		
		for(Mitarbeiter m: mb){
			filter.addItem(m.getName());
		}
		filter.addPropertyChangeListener(this);
		filter.addItemListener(this);
	}
	private JTable createCenter() {
		JTable ret;
		MitarbeiterstundenDao dao=new MitarbeiterstundenDao();
		MitarbeiterDao mbdao=new MitarbeiterDao();
		List<Mitarbeiterstunde> stunden=dao.getMitarbeiterStunden();
		String[] columns={"ID","Name","Angekommen","Gegangen","Bemerkung"};
		Object[][] data=new Object[stunden.size()][5];
		int row=0;
		for(Mitarbeiterstunde m: stunden){
			data[row][0]=m.getId();
			
			data[row][1]=m.getMitarbeiter().getName();
			data[row][2]=m.getAngekommen();
			data[row][3]=m.getGegangen();
			data[row][4]=m.getBemerkung();
			row++;
		}
		DefaultTableModel model=new DefaultTableModel(data,columns);
		ret=new JTable(model);
		ret.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return ret;
	}
	/*
* Ersteller: Daniel Burgstaller
* Funktionname: actionPerformed
* Paramterliste:
*					ActionEvent e 
* Funktion:
*            Actionlistener
*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd=e.getActionCommand();
		if (cmd.equals("Close")){
			this.dispose();
		}else{
			if (cmd.equals("<html>Mitarbeiter <U>e</U>rstellen</font></blink></html>")){
				System.out.println("asdf");
				EmployeemanagementAdd m = new EmployeemanagementAdd();
				m.setVisible(true);
				//mainPanel.add(m);
			}else{
				if (cmd.equals("Mitarbeiter anzeigen")) {
					EmployeemanagementShowEdit ese=new EmployeemanagementShowEdit();
				}else{
					if (cmd.equals("Statistiken")){

							Employeestats stats=new Employeestats("test","test chart");
					
					}
				}
			}
		}
		
		
	}//#actionPerformed
	
	/*
* Ersteller: Thomas Kranzer
* Funktionname: makegbc
* Paramterliste:
*					int x, int y, int width, int height
* Funktion:
*            set GridBagConstraints zu den parametern
*/

	private GridBagConstraints makegbc (int x, int y, int width, int height){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.insets = new Insets(1, 1, 1, 1);
		return gbc;
	}//#makegbc
	
	
	/*
* Ersteller: Daniel Burgstaller
* Funktionname: keyPressed
* Paramterliste:
*					KeyEvent e
* Funktion:
*            KeyListener
*/
	static String chosen="";
	JPopupMenu menu;
	@Override
	public void keyPressed(KeyEvent e) {
		/// TODO Auto-generated method stub
		
		System.out.println("In KeyPressed");
		if (e.getKeyCode() == KeyEvent.VK_E){
			System.out.println("hallo");
			EmployeemanagementAdd add=new EmployeemanagementAdd();
			add.setVisible(true);
		}else{
			if (((JTextField)e.getSource())==search){
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					System.out.println("ich suche nach: "+search.getText());
					
					MitarbeiterDao dao=new MitarbeiterDao();
					List<Mitarbeiter> mb=dao.getMitarbeiterBySearch(search.getText());
					menu=new JPopupMenu();
					for(Mitarbeiter m: mb){
						System.out.println(m.getName());
						JMenuItem mi=new JMenuItem(m.getName());
						mi.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								chosen=((JMenuItem)arg0.getSource()).getText();
								refreshTable();
							}

						});
						menu.add(mi);
					}
					menu.setLocation(search.getLocationOnScreen().x, search.getLocationOnScreen().y+search.getHeight());
					menu.setVisible(true);
				}
			}
		}//#if
		
	}//#keypressed
	
	public void refreshTable(){
		DefaultTableModel model=(DefaultTableModel) centerside.getModel();
		model.setRowCount(0);
		
		Object[][] data=createFilteredCenter(chosen);
		for(int i=0;i<data.length;i++){
			model.addRow(data[i]);
		}
		centerside=new JTable(model);
		menu.setVisible(false);
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		System.out.println("item:" + filter.getSelectedItem());
		
		DefaultTableModel model=(DefaultTableModel) centerside.getModel();
		model.setRowCount(0);
		
		Object[][] data=createFilteredCenter(filter.getSelectedItem().toString());
		for(int i=0;i<data.length;i++){
			model.addRow(data[i]);
		}
		centerside=new JTable(model);
	}
	public Object[][] createFilteredCenter(String name){
	
		MitarbeiterstundenDao dao=new MitarbeiterstundenDao();
		MitarbeiterDao mbdao=new MitarbeiterDao();
		List<Mitarbeiterstunde> stunden=dao.getMitarbeiterstundenByMitarbeiter(mbdao.getMitarbeiterByName(name));
		String[] columns={"ID","Name","Angekommen","Gegangen","Bemerkung"};
		Object[][] data=new Object[stunden.size()][5];
	
		int row=0;
		for(Mitarbeiterstunde m: stunden){
			data[row][0]=m.getId();
			
			data[row][1]=m.getMitarbeiter().getName();
			data[row][2]=m.getAngekommen();
			data[row][3]=m.getGegangen();
			data[row][4]=m.getBemerkung();
			row++;
		}
		return data;
		
	}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}//#Employeemanagement
