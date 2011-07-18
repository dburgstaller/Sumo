package sumo.empmanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import sumo.Constants.Constants;
import sumo.daos.MitarbeiterDao;
import sumo.logic.MyDate;
import sumo.model.Mitarbeiter;

public class EmployeemanagementShowEdit extends JFrame implements ActionListener,ItemListener {
	
	String bildpfad="";
	JPanel mainPanel = new JPanel();
	JPanel north=new JPanel();
	JPanel south=new JPanel();
	JPanel center=new JPanel();
	JPanel center_left=new JPanel();
	JPanel center_right=new JPanel();
	JPanel center_right_north=new JPanel();
	JPanel center_right_south=new JPanel();
	JButton close=new JButton("Schlie§en");
	JButton edit=new JButton("Bearbeiten");
	JButton speichern=new JButton("Speichern");
	JLabel north_label=new JLabel("Mitarbeiter anzeigen");
	
	
	//Labels left
	JLabel lblchosen,lblId,lblName,lblBemerkung, lblAnschrift, lblPLZ,lblOrt,lblGehalt,lblSeit,lblKontoNr,lblBLZ,lblUsername,lblPasswort,lblisAdmin;
	//Components left
	JTextField tfId,tfName,tfAnschrift,tfPLZ,tfOrt,tfGehalt,tfKontoNr,tfBLZ,tfUsername,tfBemerkung;
	JCheckBox cbIsAdmin;
	JPasswordField pfPasswort;
	JDateChooser dcSeit;
	JComboBox cbchosen;
	
	//Components Right
	ImageIcon logo = new ImageIcon("images/leerpic.jpg");
	JButton durchsuchen=new JButton("Durchsuchen ...");
	JLabel imgLabel;
		public EmployeemanagementShowEdit() {
			super("Anzeigen/Bearbeiten");
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			setSize(dim);
			initializeComponents();
			setVisible(true);
		}
		private void initializeComponents() {
			mainPanel.setLayout(new BorderLayout());
			//NORTH
			north_label.setForeground(Constants.cl_orange);
			north_label.setFont(new Font("Serief", Font.BOLD, 15));
			north.setBackground(Constants.cl_blue);
			north.add(north_label);
			
			//SOUTH
			south=new JPanel();
		
			close.addActionListener(this);
			edit.addActionListener(this);
			speichern.addActionListener(this);
			
			speichern.setVisible(false);
			south.add(speichern);
			south.add(edit);
			south.add(close);
			
			//CENTER
			center=new JPanel();
			center.setLayout(new GridLayout(1,2));
			
			//CENTER LEFT
			center_left=new JPanel();
			center_left.setLayout(new GridLayout(16,2,20,20));
			center_left.setBackground(Constants.cl_blue);
			initializeLabels();
			initializeComponentsLeft();
			tfId.setEnabled(false);
			
			cbchosen.addItemListener(this);
			addLabelsAndComponentsToCenterLeft();
			setComponentStates(false);
			//CENTER RIGHT
			center_right=new JPanel();
			center_right.setLayout(new GridLayout(2,1));
			
			imgLabel=new JLabel(logo);
			center_right_north.setBackground(Constants.cl_blue);
			durchsuchen.addActionListener(this);
			durchsuchen.setVisible(false);
			center_right_north.add(imgLabel);
			center_right_north.add(durchsuchen);
			
			center_right_south.setBackground(Constants.cl_blue);
			
			center_right.add(center_right_north);
			center_right.add(center_right_south);
			
			//ADDING LEFT
			FillComboBox();
			center.add(center_left);
			
			//ADDING RIGHT
			center.add(center_right);
			//ADDING
			mainPanel.add(north,BorderLayout.NORTH);
			mainPanel.add(south,BorderLayout.SOUTH);
			mainPanel.add(center,BorderLayout.CENTER);
			this.add(mainPanel);
		}
		private void setComponentStates(boolean b) {
			tfBemerkung.setEditable(b);
			tfName.setEditable(b);
			tfAnschrift.setEditable(b);
			tfPLZ.setEditable(b);
			tfOrt.setEditable(b);
			tfGehalt.setEditable(b);
			tfKontoNr.setEditable(b);
			tfBLZ.setEditable(b);
			tfUsername.setEditable(b);
			cbIsAdmin.setEnabled(b);
			pfPasswort.setEditable(b);
			dcSeit.setEnabled(b);
			cbchosen.setEditable(b);
		}
		private void FillComboBox() {
			MitarbeiterDao dao=new MitarbeiterDao();
		List<Mitarbeiter> mb=dao.getMitarbeiter();
			for(Mitarbeiter m:mb){
				cbchosen.addItem(m.getName());
			}
		}
		private void initializeComponentsLeft() {
			tfBemerkung=new JTextField();
			tfId=new JTextField();
			tfName=new JTextField();
			tfAnschrift=new JTextField();
			tfPLZ=new JTextField();
			tfOrt=new JTextField();
			tfGehalt=new JTextField();
			tfKontoNr=new JTextField();
			tfBLZ=new JTextField();
			tfUsername=new JTextField();
			cbIsAdmin=new JCheckBox();
			pfPasswort=new JPasswordField();
			dcSeit=new JDateChooser();
			cbchosen=new JComboBox();
		}//#initializeComponentsLeft
		
		private void addLabelsAndComponentsToCenterLeft() {
			center_left.add(lblchosen);
			center_left.add(cbchosen);
			center_left.add(lblId);
			center_left.add(tfId);
			center_left.add(lblName);
			center_left.add(tfName);
			center_left.add(lblAnschrift);
			center_left.add(tfAnschrift);
			center_left.add(lblPLZ);
			center_left.add(tfPLZ);
			center_left.add(lblOrt);
			center_left.add(tfOrt);
			center_left.add(lblGehalt);
			center_left.add(tfGehalt);
			center_left.add(lblKontoNr);
			center_left.add(tfKontoNr);
			center_left.add(lblBLZ);
			center_left.add(tfBLZ);
			center_left.add(lblSeit);
			center_left.add(dcSeit);
			
			center_left.add(lblUsername);
			center_left.add(tfUsername);
			center_left.add(lblPasswort);
			center_left.add(pfPasswort);
			center_left.add(lblBemerkung);
			center_left.add(tfBemerkung);
			center_left.add(lblisAdmin);
			center_left.add(cbIsAdmin);
		}//#addLabelsAndComponentsToCenterLeft
		
		private void initializeLabels() {
			lblBemerkung=new JLabel("Bemerkung");
			lblchosen=new JLabel("Mitarbeiter");
			lblId=new JLabel("ID");
			lblName=new JLabel("Name");
			lblAnschrift=new JLabel("Anschrift");
			lblPLZ=new JLabel("PLZ");
			lblOrt=new JLabel("Ort");
			lblGehalt=new JLabel("Gehalt");
			lblSeit=new JLabel("Mitarbeiter seit");
			lblKontoNr=new JLabel("Kontonummer");
			lblBLZ=new JLabel("BLZ");
			lblUsername=new JLabel("Username");
			lblPasswort=new JLabel("Passwort");
			lblisAdmin=new JLabel("Administrator");
			
			setFonts();
		}//#initializeLabels
		
		
		private void setFonts() {
			// TODO Auto-generated method stub
			lblchosen.setFont(new Font("Serief", Font.BOLD, 20));
			lblchosen.setHorizontalAlignment(SwingConstants.RIGHT);
			lblchosen.setForeground(Color.WHITE);
			
			lblBemerkung.setFont(new Font("Serief", Font.BOLD, 20));
			lblBemerkung.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBemerkung.setForeground(Color.WHITE);
			
			lblId.setFont(new Font("Serief", Font.BOLD, 20));
			lblId.setHorizontalAlignment(SwingConstants.RIGHT);
			lblId.setForeground(Color.WHITE);
			
			lblName.setFont(new Font("Serief", Font.BOLD, 20));
			lblName.setHorizontalAlignment(SwingConstants.RIGHT);
			lblName.setForeground(Color.WHITE);
			
			lblAnschrift.setFont(new Font("Serief", Font.BOLD, 20));
			lblAnschrift.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAnschrift.setForeground(Color.WHITE);
			
			lblKontoNr.setFont(new Font("Serief", Font.BOLD, 20));
			lblKontoNr.setHorizontalAlignment(SwingConstants.RIGHT);
			lblKontoNr.setForeground(Color.WHITE);
			
			lblPLZ.setFont(new Font("Serief", Font.BOLD, 20));
			lblPLZ.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPLZ.setForeground(Color.WHITE);
			
			lblOrt.setFont(new Font("Serief", Font.BOLD, 20));
			lblOrt.setHorizontalAlignment(SwingConstants.RIGHT);
			lblOrt.setForeground(Color.WHITE);
			
			lblGehalt.setFont(new Font("Serief", Font.BOLD, 20));
			lblGehalt.setHorizontalAlignment(SwingConstants.RIGHT);
			lblGehalt.setForeground(Color.WHITE);
			
			lblSeit.setFont(new Font("Serief", Font.BOLD, 20));
			lblSeit.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSeit.setForeground(Color.WHITE);
			
			lblBLZ.setFont(new Font("Serief", Font.BOLD, 20));
			lblBLZ.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBLZ.setForeground(Color.WHITE);
			
			lblUsername.setFont(new Font("Serief", Font.BOLD, 20));
			lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
			lblUsername.setForeground(Color.WHITE);
			
			lblPasswort.setFont(new Font("Serief", Font.BOLD, 20));
			lblPasswort.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPasswort.setForeground(Color.WHITE);
			
			lblisAdmin.setFont(new Font("Serief", Font.BOLD, 20));
			lblisAdmin.setHorizontalAlignment(SwingConstants.RIGHT);
			lblisAdmin.setForeground(Color.WHITE);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd=e.getActionCommand();
			if (cmd.equals("Bearbeiten")){
				speichern.setVisible(true);
				edit.setVisible(false);
				durchsuchen.setVisible(true);
				setComponentStates(true);
				cbchosen.setEnabled(false);
			}else{
				if (cmd.equals("Schlie§en")){
					if (!speichern.isVisible()){
						this.dispose();
					}else{
						Object[] options = {"Yes", "No"};
			            int ret = JOptionPane.showOptionDialog(this, "Es wurden €nderungen vorgenommen. Speichern?", "€nderungen", 
			            JOptionPane.YES_NO_OPTION, 
			            JOptionPane.ERROR_MESSAGE,null, 
			            options, options[0]);
			          
						if (ret==0){
							this.dispose();
						}//#if ja 
					}//#if speichern aktiv
				}else{
					if (cmd.equals("Speichern")){
						cbchosen.setEnabled(true);
						durchsuchen.setVisible(false);
						edit.setVisible(true);
						speichern.setVisible(false);
						setComponentStates(false);
						save();
					}else{
						if (cmd.equals("Durchsuchen ...")){
							JFileChooser chooser = new JFileChooser();
							// Note: source for ExampleFileFilter can be found in
							// FileChooserDemo,
							// under the demo/jfc directory in the Java 2 SDK, Standard
							// Edition.

							int returnVal = chooser.showOpenDialog(this);
							if (returnVal == JFileChooser.APPROVE_OPTION) {
								bildpfad = chooser.getSelectedFile().getAbsolutePath();
								logo=new ImageIcon(bildpfad);
								Image img=logo.getImage();
								
								int width=0;
								int height=0;
								int act_width=img.getWidth(this);
								int act_height=img.getHeight(this);
								while(act_height>400 || act_width>300) {
									act_height/=2;
									act_width/=2;
								};
								Image scaledImage=img.getScaledInstance(act_width, act_height,Image.SCALE_SMOOTH);
								
								logo=new ImageIcon(scaledImage);
								System.out.println(logo.getIconWidth());
								imgLabel.setIcon(logo);
							}//#if ret
						}//#if durchsuchen
					}//#if speichern					
				}//#if schlie§en
			}//#if bearbeiten
			
		}//#actionPerformed
		
		
		private void save() {
			// TODO Auto-generated method stub
			MitarbeiterDao dao=new MitarbeiterDao();
			
			Long id=null;
			try{
				id=Long.parseLong(tfId.getText());
			}catch (Exception e){
				System.out.println("Fehler beikm ID parsen!");
			}
			
			Mitarbeiter m=dao.getMitarbeiterById(id);
			try{
				
			
			m.setName(tfName.getText());
			m.setAnschrift(tfAnschrift.getText());
			m.setPlz(Short.parseShort(tfPLZ.getText()));
			m.setOrt(tfOrt.getText());
			m.setGehalt(Float.parseFloat(tfGehalt.getText()));
			m.setKontoNr(Long.parseLong(tfKontoNr.getText()));
			m.setBlz(Short.parseShort(tfBLZ.getText()));
			
		System.out.println(dcSeit.getDateFormatString());
		Date einstiegsdatum=dcSeit.getDate();
				java.sql.Date dat = new java.sql.Date(einstiegsdatum.getTime());
		m.setEinstiegsdatum(dat);
		
			m.setUsername(tfUsername.getText());
			m.setPasswort(pfPasswort.getText());
			m.setIsAdmin(cbIsAdmin.isSelected());
			m.setBemerkung(tfBemerkung.getText());
			try {
				if (!bildpfad.equals("")){
					copy(bildpfad,"images/Mitarbeiter/"+m.getUsername()+".jpg");
					m.setBildpfad("images/Mitarbeiter/"+m.getUsername()+".jpg");

				}//#if
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("Fehler copy");
				//e.printStackTrace();
			}
			dao.saveOrUpdate(m);
			}catch(Exception e){
				//ERROR Handling
				System.err.print("Fehler parse");
		e.printStackTrace();
			}
		}//#save
		
		/*
		 * Funktionsname: parseDate
		 * Parameter: Date
		 * 
		 */
		private MyDate parseDate(Date date) {
			MyDate ret=new MyDate();
			String dat=date.toString();
			
			String[] parts=dat.split(" ");
			System.out.println(dat);
			
			int tag,jahr,monat;
			tag=Integer.parseInt(parts[2]);
			jahr=Integer.parseInt(parts[5]);
			
			String month=parts[1];
			monat=0;
			if (month.equals("Jan")){
				monat=1;
			}else{
				if (month.equals("Feb")){
					monat=2;
				}
				else{
					if (month.equals("Mar")){
					monat=3;	
					}else{
						if (month.equals("Apr")){
							monat=4;
						}else{
							if (month.equals("May")){
								monat=5;
							}else{
								if(month.equals("Jun")){
									monat=6;
								}else{
									if (month.equals("Jul")){
										monat=7;
									}else{
										if(month.equals("Aug")){
											monat=8;
										}else{
											if (month.equals("Sep")){
												monat=9;
											}else{
												if (month.equals("Oct")){
													monat=10;
												}else{
													if (month.equals("Nov")){
														monat=11;
													}else{
														monat=12;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			ret.jahr=jahr;
			ret.monat=monat;
			ret.tag=tag;
			System.out.println(jahr+" - "+monat+" - "+tag);
			System.out.println(ret.jahr+"-"+ret.monat+"-"+ret.tag);
			return ret;
		}
		public static void copy(String from, String to) throws IOException{
		        InputStream in = null;
		        OutputStream out = null; 
		        try {
		           InputStream inFile = new FileInputStream(from);
		           in = new BufferedInputStream(inFile);
		           OutputStream outFile = new FileOutputStream(to);
		           out = new BufferedOutputStream(outFile);
		           while (true) {
		              int data = in.read();
		              if (data == -1) {
		                 break;
		              }
		              out.write(data);
		           }
		        } finally {
		           if (in != null) {
		              in.close();
		           }
		           if (out != null) {
		              out.close();
		           }
		        }
		     }


		
		private void setFieldsToMitarbeiter(Mitarbeiter m) {
			tfBemerkung.setText(m.getBemerkung());
			tfId.setText(""+m.getId());
			tfName.setText(m.getName());
			tfAnschrift.setText(m.getAnschrift());
			tfPLZ.setText(""+m.getPlz());
			tfOrt.setText(m.getOrt());
			tfGehalt.setText(""+m.getGehalt());
			tfKontoNr.setText(""+m.getKontoNr());
			tfBLZ.setText(""+m.getBlz());
			tfUsername.setText(m.getUsername());
			cbIsAdmin.setSelected(m.getIsAdmin());
			pfPasswort.setText(m.getPasswort());
			dcSeit.setDate(m.getEinstiegsdatum());
			logo=new ImageIcon(m.getBildpfad());
			Image img=logo.getImage();
			
			int width=0;
			int height=0;
			int act_width=img.getWidth(this);
			int act_height=img.getHeight(this);
			while(act_height>400 || act_width>300) {
				act_height/=2;
				act_width/=2;
			};
			Image scaledImage=img.getScaledInstance(act_width, act_height,Image.SCALE_SMOOTH);
			
			logo=new ImageIcon(scaledImage);
			System.out.println(logo.getIconWidth());
			imgLabel.setIcon(logo);
			
		}
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			MitarbeiterDao dao=new MitarbeiterDao();
			
			Mitarbeiter m=dao.getMitarbeiterByName(cbchosen.getSelectedItem().toString());
			setFieldsToMitarbeiter(m);
			System.out.println("chosen:"+ m.getName());
			
		}
}
