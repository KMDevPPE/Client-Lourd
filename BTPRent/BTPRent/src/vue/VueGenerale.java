package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.Main;

public class VueGenerale extends JFrame implements ActionListener 
{
	private JButton btQuitter = new JButton("Quitter");
	private JPanel plMenu = new JPanel();
	private JButton btClients = new JButton("Clients");
	private JButton btTechs = new JButton("Techniciens");
	private JButton btInters = new JButton("Interventions");
	private JButton btSalaries = new JButton("Salari�s");
	private JButton btMateriaux = new JButton("Mat�riaux");
	private JButton btContrats = new JButton("Contrats");
	
	
	
	//creation des panels
	private VueClients uneVueClients = new VueClients();
	private VueInters uneVueInters = new VueInters();
	private VueTechs uneVueTechs = new VueTechs();
	private VueSalarie uneVueSalaries = new VueSalarie();
	private VueMateriaux uneVueMateriaux = new VueMateriaux();
	private VueContrats uneVueContrats = new VueContrats();
	
	
	public VueGenerale() {
		this.setTitle("Logiciel de gestion des locations");
		this.setLayout(null);
		this.setBounds(300, 100, 1500, 900);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.lightGray);
		
		//place le boutton quitter
		this.btQuitter.setBounds(600, 820, 200, 40);
		this.add(this.btQuitter);
		this.btQuitter.addActionListener(this);
		
		//construction du panel menu
		this.plMenu.setBounds(0, 40, 1500, 60);
		this.plMenu.setLayout(new GridLayout(1, 3));
		this.plMenu.add(btClients);
		this.plMenu.add(btTechs);
		this.plMenu.add(btInters);
		this.plMenu.add(btSalaries);
		this.plMenu.add(btMateriaux);
		this.plMenu.add(btContrats);
		this.add(this.plMenu);
		
		//rendre les trois boutons cliquables
		this.btClients.addActionListener(this);
		this.btInters.addActionListener(this);
		this.btTechs.addActionListener(this);
		this.btSalaries.addActionListener(this);
		this.btMateriaux.addActionListener(this);
		this.btContrats.addActionListener(this);
		
		//ajout des panels a la vue
		this.add(this.uneVueClients);
		this.add(this.uneVueInters);
		this.add(this.uneVueTechs);
		this.add(this.uneVueSalaries);
		this.add(this.uneVueMateriaux);
		this.add(this.uneVueContrats);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Quitter" : this.dispose(); 
						Main.rendreVisible(true);
						break;
		case "Clients" :
					this.uneVueClients.setVisible(true);
					this.uneVueInters.setVisible(false);
					this.uneVueTechs.setVisible(false);
					this.uneVueSalaries.setVisible(false);
					this.uneVueMateriaux.setVisible(false);
					this.uneVueContrats.setVisible(false);
					break;
		case "Techniciens" :
			this.uneVueClients.setVisible(false);
			this.uneVueInters.setVisible(false);
			this.uneVueTechs.setVisible(true);
			this.uneVueSalaries.setVisible(false);
			this.uneVueMateriaux.setVisible(false);
			this.uneVueContrats.setVisible(false);
			break;
		case "Interventions" :
			this.uneVueClients.setVisible(false);
			this.uneVueInters.setVisible(true);
			this.uneVueTechs.setVisible(false);
			this.uneVueSalaries.setVisible(false);
			this.uneVueMateriaux.setVisible(false);
			this.uneVueContrats.setVisible(false);
			break;
		case "Salari�s" :
			this.uneVueClients.setVisible(false);
			this.uneVueInters.setVisible(false);
			this.uneVueTechs.setVisible(false);
			this.uneVueSalaries.setVisible(true);
			this.uneVueMateriaux.setVisible(false);
			this.uneVueContrats.setVisible(false);
			break;
		case "Mat�riaux" :
			this.uneVueClients.setVisible(false);
			this.uneVueInters.setVisible(false);
			this.uneVueTechs.setVisible(false);
			this.uneVueSalaries.setVisible(false);
			this.uneVueMateriaux.setVisible(true);
			this.uneVueContrats.setVisible(false);
			break;
		case "Contrats" :
			this.uneVueClients.setVisible(false);
			this.uneVueInters.setVisible(false);
			this.uneVueTechs.setVisible(false);
			this.uneVueSalaries.setVisible(false);
			this.uneVueMateriaux.setVisible(false);
			this.uneVueContrats.setVisible(true);
			break;
		}
		
	}

}
