package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
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
	private JButton btInterventions = new JButton("Interventions");
	private JButton btSalaries = new JButton("Salariés");
	private JButton btMateriaux = new JButton("Matériaux");
	private JButton btContrats = new JButton("Contrats");
	
	//récuperer la dimension de l'écran
	Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
	int longueur = tailleMoniteur.width * 4/5;
	int hauteur = tailleMoniteur.height * 4/5;
	
	
	//creation des panels
	private VueClients uneVueClients = new VueClients();
	private VueInterventions uneVueInterventions = new VueInterventions();
	private VueTechs uneVueTechs = new VueTechs();
	private VueSalarie uneVueSalaries = new VueSalarie();
	private VueMateriaux uneVueMateriaux = new VueMateriaux();
	private VueContrats uneVueContrats = new VueContrats();
	
	
	public VueGenerale() {
		this.setTitle("Logiciel de gestion des locations");
		this.setLayout(null);
		//this.setBounds(300, 100, longueur, hauteur);
		this.setSize(longueur, hauteur);
		this.setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		this.setResizable(true); //On interdit la redimensionnement de la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.lightGray);
		
		//place le boutton quitter
		this.btQuitter.setBounds((longueur-longueur/10)/2, hauteur-(hauteur/12), longueur/10, hauteur/20);
		this.add(this.btQuitter);
		this.btQuitter.addActionListener(this);
		
		//construction du panel menu
		this.plMenu.setBounds(0, 10, longueur, 60);
		this.plMenu.setLayout(new GridLayout(1, 6));
		this.plMenu.add(btClients);
		this.plMenu.add(btTechs);
		this.plMenu.add(btInterventions);
		this.plMenu.add(btSalaries);
		this.plMenu.add(btMateriaux);
		this.plMenu.add(btContrats);
		this.add(this.plMenu);
		
		//rendre les trois boutons cliquables
		this.btClients.addActionListener(this);
		this.btInterventions.addActionListener(this);
		this.btTechs.addActionListener(this);
		this.btSalaries.addActionListener(this);
		this.btMateriaux.addActionListener(this);
		this.btContrats.addActionListener(this);
		
		//ajout des panels a la vue
		this.add(this.uneVueClients);
		this.add(this.uneVueInterventions);
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
					this.uneVueInterventions.setVisible(false);
					this.uneVueTechs.setVisible(false);
					this.uneVueSalaries.setVisible(false);
					this.uneVueMateriaux.setVisible(false);
					this.uneVueContrats.setVisible(false);
					break;
		case "Techniciens" :
			this.uneVueClients.setVisible(false);
			this.uneVueInterventions.setVisible(false);
			this.uneVueTechs.setVisible(true);
			this.uneVueSalaries.setVisible(false);
			this.uneVueMateriaux.setVisible(false);
			this.uneVueContrats.setVisible(false);
			break;
		case "Interventions" :
			this.uneVueClients.setVisible(false);
			this.uneVueInterventions.setVisible(true);
			this.uneVueTechs.setVisible(false);
			this.uneVueSalaries.setVisible(false);
			this.uneVueMateriaux.setVisible(false);
			this.uneVueContrats.setVisible(false);
			break;
		case "Salariés" :
			this.uneVueClients.setVisible(false);
			this.uneVueInterventions.setVisible(false);
			this.uneVueTechs.setVisible(false);
			this.uneVueSalaries.setVisible(true);
			this.uneVueMateriaux.setVisible(false);
			this.uneVueContrats.setVisible(false);
			break;
		case "Matériaux" :
			this.uneVueClients.setVisible(false);
			this.uneVueInterventions.setVisible(false);
			this.uneVueTechs.setVisible(false);
			this.uneVueSalaries.setVisible(false);
			this.uneVueMateriaux.setVisible(true);
			this.uneVueContrats.setVisible(false);
			break;
		case "Contrats" :
			this.uneVueClients.setVisible(false);
			this.uneVueInterventions.setVisible(false);
			this.uneVueTechs.setVisible(false);
			this.uneVueSalaries.setVisible(false);
			this.uneVueMateriaux.setVisible(false);
			this.uneVueContrats.setVisible(true);
			break;
		}
		
	}

}
