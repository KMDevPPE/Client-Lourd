package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modele.Modele;
import modele.ModeleClients;
import controleur.Client;
import controleur.Entreprise;
import controleur.Particulier;
import controleur.Tableau;

public class VueClients extends JPanel implements ActionListener
{
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btEditer = new JButton("Modifier");
	
	
	private JTable tableClients ;
	private Tableau unTableau ; //modele de tableau pour gerer la JTable
	
	private JTextField txtIdclient = new JTextField();
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtDateNaiss = new JTextField();
	private JTextField txtRaison = new JTextField();
	private JTextField txtDomaine = new JTextField();
	private JTextField txtSiret = new JTextField();
	private JTextField txtRue = new JTextField();
	private JTextField txtVille = new JTextField();
	private JTextField txtCP = new JTextField();
	private JTextField txtTel = new JTextField();
	private JTextField txtMail = new JTextField();
	private JTextField txtMDP = new JTextField();
		
	public VueClients()
	{
		this.setBounds(40, 140, 1440, 760);
		this.setBackground(Color.cyan);
		this.setLayout(null); // les surface
		
		JPanel unPanel = new JPanel ();
		unPanel.setBounds(40, 550, 1350, 120);
		unPanel.setLayout(new GridLayout(7, 4));
		
		 //premiere case vide
		
		unPanel.add(new JLabel("ID Client"));
		unPanel.add(txtIdclient);
		
		
		unPanel.add(new JLabel(" Nom :"));
		unPanel.add(this.txtNom);
		
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel(" Prenom: "));
		unPanel.add(this.txtPrenom);
		
		unPanel.add(new JLabel(" Date Naissance : "));
		unPanel.add(this.txtDateNaiss);		
 
		unPanel.add(new JLabel("")); 
		unPanel.add(new JLabel(" Raison: "));
		unPanel.add(this.txtRaison);		 		
		 
		unPanel.add(new JLabel(" Domaine : "));
		unPanel.add(this.txtSiret); 
		
		unPanel.add(new JLabel("")); 
		unPanel.add(new JLabel(" Rue : "));
		unPanel.add(this.txtRue);
		
		unPanel.add(new JLabel(" Ville: "));
		unPanel.add(this.txtVille);
		
		unPanel.add(new JLabel("")); 
		unPanel.add(new JLabel(" Code Postal : "));
		unPanel.add(this.txtCP);		
		
		unPanel.add(new JLabel(" Téléphone : "));
		unPanel.add(this.txtTel);

		unPanel.add(new JLabel(""));
		
		unPanel.add(new JLabel(" Email : "));
		unPanel.add(this.txtMail); 
		
		unPanel.add(new JLabel("Mot de Passe"));
		unPanel.add(this.txtMDP);
		
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel(""));
		unPanel.add(this.btAjouter);
		unPanel.add(this.btSupprimer);
		unPanel.add(this.btEditer);
		unPanel.add(new JLabel(""));
		this.txtIdclient.setEditable(false);
		
		unPanel.setVisible(true);
		this.add(unPanel);
		// rendre les boutons cliquables
		this.btAjouter.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btEditer.addActionListener(this);
		
		//construction de la JTable
		String entete [] = {"ID Client", "Nom", "Prenom", "Date Naiss", "Rue", "Ville", "Code Postal", "Telephone", "Email", "MDP", "Raison", "Domaine", "Siret"};
		Object [][] lesDonnees = remplirDonnees ();
		this.tableClients = new JTable(lesDonnees, entete);
		
		//gestion de la JTable avec le Tableau
		unTableau = new Tableau(lesDonnees, entete);
		this.tableClients = new JTable (unTableau);
		
		//ajouter l'evenement clic sur la table MouseListener
		this.tableClients.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int ligne = tableClients.getSelectedRow();
				txtIdclient.setText(tableClients.getValueAt(ligne, 0).toString());
				txtNom.setText(tableClients.getValueAt(ligne, 1).toString());
				txtPrenom.setText(tableClients.getValueAt(ligne, 2).toString());
				txtDateNaiss.setText(tableClients.getValueAt(ligne, 3).toString());				
				txtRue.setText(tableClients.getValueAt(ligne, 4).toString());
				txtVille.setText(tableClients.getValueAt(ligne, 5).toString());
				txtCP.setText(tableClients.getValueAt(ligne, 6).toString());
				txtTel.setText(tableClients.getValueAt(ligne, 7).toString());				
				txtMail.setText(tableClients.getValueAt(ligne, 8).toString());
				txtMDP.setText(tableClients.getValueAt(ligne, 9).toString());
				txtRaison.setText(tableClients.getValueAt(ligne, 10).toString());
				txtDomaine.setText(tableClients.getValueAt(ligne, 11).toString());
				txtSiret.setText(tableClients.getValueAt(ligne, 12).toString());
			}
		});
		
		JScrollPane uneScroll = new JScrollPane(tableClients);
		uneScroll.setBounds(50, 20, 1340, 500);
		this.add(uneScroll);
		this.setVisible(false);
	}

// "ID Client", "Nom", "Prenom", "Date Naiss", "Rue", "Ville", "Code Postal", "Telephone", "Email", "MDP", "Raison", "Domaine", "Siret
	private Object[][] remplirDonnees() {
		ArrayList<Client> lesClients = ModeleClients.selectAllClients();
		Particulier unParti = new Particulier();
		Entreprise uneEntre = new Entreprise();
		Object [][] lesDonnees = new Object[lesClients.size()][13];
		int i = 0;
		for (Client unClient : lesClients)
		{
			lesDonnees[i][0] = unClient.getIdclient() +"";
			lesDonnees[i][1] = unClient.getNom();
			lesDonnees[i][2] = unClient.getPrenom();
			lesDonnees[i][3] = unParti.getDatenaiss();
			lesDonnees[i][4] = unClient.getRue();
			lesDonnees[i][5] = unClient.getVille();
			lesDonnees[i][6] = unClient.getCp();
			lesDonnees[i][7] = unClient.getTel();
			lesDonnees[i][8] = unClient.getMail();
			lesDonnees[i][9] = unClient.getMdp();
			lesDonnees[i][10] = uneEntre.getRaison();
			lesDonnees[i][11] = uneEntre.getDomaine();
			lesDonnees[i][12] = uneEntre.getSiret();
			System.out.println(unClient.getNom());
			i++;
		}
		
		return lesDonnees;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
	/*	case "Ajouter":
		{
			String nom = this.txtNom.getText();
			String adresse = this.txtAdresse.getText();
			if (nom.equals("") || adresse.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
			}
			else
			{
				Client unClient = new Client (nom, adresse);
				Modele.insertClient(unClient);
				JOptionPane.showMessageDialog(this, "Client inséré avec succès");
				// mise a jour de la Jtable
				Client leClient = Modele.selectWhere(unClient);
				
				Object ligne [] = {leClient.getIdclient(), leClient.getNom(), leClient.getAdresse()};
				
				
				//appel de la methode pour ajouter cette ligne dans la tablea
				unTableau.add(ligne);
				
				this.txtAdresse.setText("");
				this.txtNom.setText("");							
			}
		}
			break;
		case "Supprimer":
		{			
			String nom = txtNom.getText();
			String adresse = txtAdresse.getText();
			if (txtIdclient.getText().equals("") || nom.equals("") || adresse.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
			}
			else
			{
				int idclient = Integer.parseInt(txtIdclient.getText());
				Client unClient = new Client(idclient, nom, adresse);
				Modele.deleteClient(unClient);
				JOptionPane.showMessageDialog(this, "Suppression réussie");
				
				int rowIndex = this.tableClients.getSelectedRow();
				unTableau.delete(rowIndex);
				
				txtIdclient.setText("");
				txtNom.setText("");
				txtAdresse.setText("");								
			}				
				
		}
			break;
		case "Editer":
		{
			String nom = txtNom.getText();
			String adresse = txtAdresse.getText();
			if (txtIdclient.getText().equals("") || nom.equals("") || adresse.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
			}
			else
			{
				int idclient = Integer.parseInt(txtIdclient.getText());			
				Client unClient = new Client(idclient, nom, adresse);
				Modele.updateClient(unClient);
				JOptionPane.showMessageDialog(this, "Mise à jour réussie");
				Object ligne [] = {unClient.getIdclient(), unClient.getNom(), unClient.getAdresse()};
				int rowIndex = this.tableClients.getSelectedRow();
				unTableau.update(rowIndex, ligne);
				txtIdclient.setText("");
				txtNom.setText("");
				txtAdresse.setText("");							
			}			
		} */
		}	
		
	}
}
