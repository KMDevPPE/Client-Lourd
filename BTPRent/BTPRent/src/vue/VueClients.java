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
import javax.swing.JCheckBox;

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
	
	private JCheckBox cbParticulier = new JCheckBox("Particulier");
	private JCheckBox cbEntreprise = new JCheckBox("Entreprise");
	
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
		unPanel.setLayout(new GridLayout(8, 4));
		
		 //premiere case vide
		
		unPanel.add(new JLabel("ID Client"));
		unPanel.add(txtIdclient);
		
		
		unPanel.add(new JLabel(" Nom :"));
		unPanel.add(this.txtNom);
		
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel(" Prenom : "));
		unPanel.add(this.txtPrenom);
		
		unPanel.add(new JLabel(" Date Naissance : "));
		unPanel.add(this.txtDateNaiss);		
		
		unPanel.add(new JLabel("")); 
		unPanel.add(new JLabel(" Rue : "));
		unPanel.add(this.txtRue);
		
		unPanel.add(new JLabel(" Ville : "));
		unPanel.add(this.txtVille);
		
		unPanel.add(new JLabel("")); 
		unPanel.add(new JLabel(" Code Postal : "));
		unPanel.add(this.txtCP);		
		
		unPanel.add(new JLabel(" Téléphone : "));
		unPanel.add(this.txtTel);

		unPanel.add(new JLabel(""));
		
		unPanel.add(new JLabel(" Email : "));
		unPanel.add(this.txtMail); 
		
		unPanel.add(new JLabel(" Mot de Passe :"));
		unPanel.add(this.txtMDP);
		
		unPanel.add(new JLabel("")); 
		unPanel.add(new JLabel(" Raison : "));
		unPanel.add(this.txtRaison);		 		
		 
		unPanel.add(new JLabel(" Domaine : "));
		unPanel.add(this.txtDomaine); 
		
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel(" Siret :"));
		unPanel.add(this.txtSiret); 
		
		unPanel.add(this.cbParticulier);
		unPanel.add(this.cbEntreprise);
		
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
		ArrayList<Particulier> lesParticuliers = ModeleClients.selectAllParticuliers();
		ArrayList<Entreprise> lesEntreprises = ModeleClients.selectAllEntreprises();
		ArrayList<Client> lesClients = ModeleClients.selectAllClients();
		Object [][] lesDonnees = new Object[lesClients.size()][13];
		int i = 0;
		for (Client unClient : lesClients)
		{
			for (Particulier unParticulier : lesParticuliers)
			{
				if(unClient.getIdclient() == unParticulier.getIdclient())
				{
			lesDonnees[i][0] = unClient.getIdclient() +"";
			lesDonnees[i][1] = unClient.getNom();
			lesDonnees[i][2] = unClient.getPrenom();
			lesDonnees[i][3] = unParticulier.getDatenaiss();			
			lesDonnees[i][4] = unClient.getRue();
			lesDonnees[i][5] = unClient.getVille();
			lesDonnees[i][6] = unClient.getCp();
			lesDonnees[i][7] = unClient.getTel();
			lesDonnees[i][8] = unClient.getMail();
			lesDonnees[i][9] = unClient.getMdp();		
			System.out.println(unClient.getNom());
			i++;	
				}				
			}
			for (Entreprise uneEntreprise : lesEntreprises)
			{
				if(unClient.getIdclient() == uneEntreprise.getIdclient())
				{
			lesDonnees[i][0] = unClient.getIdclient() +"";
			lesDonnees[i][1] = unClient.getNom();
			lesDonnees[i][2] = unClient.getPrenom();
					
			lesDonnees[i][4] = unClient.getRue();
			lesDonnees[i][5] = unClient.getVille();
			lesDonnees[i][6] = unClient.getCp();
			lesDonnees[i][7] = unClient.getTel();
			lesDonnees[i][8] = unClient.getMail();
			lesDonnees[i][9] = unClient.getMdp();
			lesDonnees[i][10] = uneEntreprise.getRaison();
			lesDonnees[i][11] = uneEntreprise.getDomaine();
			lesDonnees[i][12] = uneEntreprise.getSiret();	
			System.out.println(unClient.getNom());
			i++;	
				}
			}	
		}
		
		return lesDonnees;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		  ((JCheckBox) e.getSource()).setSelected(false);
		switch (e.getActionCommand()) {
		case "Ajouter":
		{
			boolean particulier = this.cbParticulier.isSelected();
			boolean entreprise = this.cbEntreprise.isSelected();
//------------------------------------------------------AJOUT PARTICULIER------------------------------------------------------------------------------------------------
			if(particulier == true) 
			{				
				String nom = this.txtNom.getText();
				String prenom = this.txtPrenom.getText();
				String datenaiss = this.txtDateNaiss.getText();
				String rue = this.txtRue.getText(); 
				String ville = this.txtVille.getText(); 
				String cp = this.txtCP.getText(); 
				String tel = this.txtTel.getText();
				String mail = this.txtMail.getText(); 
				String mdp = this.txtMDP.getText();
						
				if (nom.equals("") || prenom.equals("") || mail.equals("") || mdp.equals("") || datenaiss.equals(""))
				{
					JOptionPane.showMessageDialog(this, "Veuillez remplir le ou les champs suivants: Nom, Prenom, Date de Naissance, Mail, Mdp");
				}
				else
				{
					Particulier unParticulier = new Particulier (nom, prenom, rue, ville, cp, tel, mail, mdp, datenaiss);
					ModeleClients.insertParticulier(unParticulier);
					JOptionPane.showMessageDialog(this, "Particulier inséré avec succès");
					// mise a jour de la Jtable
					Particulier leParticulier = ModeleClients.selectWhereP(unParticulier);
					
					Object ligne [] = {leParticulier.getIdclient(), leParticulier.getNom(), leParticulier.getPrenom(), leParticulier.getDatenaiss(),
							leParticulier.getRue(), leParticulier.getVille(), leParticulier.getCp(), leParticulier.getTel(), leParticulier.getMail(),
							leParticulier.getMdp(),"","",""}; 
					
					
					//appel de la methode pour ajouter cette ligne dans la tableau
					unTableau.add(ligne);
					
					this.txtIdclient.setText("");
					this.txtNom.setText("");
					this.txtPrenom.setText("");
					this.txtDateNaiss.setText("");
					this.txtRue.setText("");
					this.txtVille.setText("");
					this.txtCP.setText("");
					this.txtTel.setText("");
					this.txtMail.setText("");
					this.txtMDP.setText(""); 
					this.txtRaison.setText("");
					this.txtDomaine.setText("");
					this.txtSiret.setText("");
				}
			}
//---------------------------------------------------------------------------------AJOUT ENTREPRISE-------------------------------------------------------------
			else if(entreprise == true)
			{
				String nom = this.txtNom.getText();
				String prenom = this.txtPrenom.getText();
				String rue = this.txtRue.getText(); 
				String ville = this.txtVille.getText(); 
				String cp = this.txtCP.getText(); 
				String tel = this.txtTel.getText();
				String mail = this.txtMail.getText(); 
				String mdp = this.txtMDP.getText();
				String raison = this.txtRaison.getText();
				String domaine = this.txtDomaine.getText();
				String siret = this.txtSiret.getText();
						
				if (nom.equals("") || prenom.equals("") || mail.equals("") || mdp.equals("") || raison.equals("") || siret.equals("") )
				{
					JOptionPane.showMessageDialog(this, "Veuillez remplir le ou les champs suivants: Nom, Prenom, Mail, Mdp, Raison, Siret");
				}
				else
				{
					Entreprise uneEntreprise = new Entreprise (nom, prenom, rue, ville, cp, tel, mail, mdp, raison, domaine, siret);
					ModeleClients.insertEntreprise(uneEntreprise);
					JOptionPane.showMessageDialog(this, "Entreprise insérée avec succès");
					// mise a jour de la Jtable
					Entreprise lEntreprise = ModeleClients.selectWhereE(uneEntreprise);
					
					Object ligne [] = {lEntreprise.getIdclient(), lEntreprise.getNom(), lEntreprise.getPrenom(), "", lEntreprise.getRue(), lEntreprise.getVille(), lEntreprise.getCp(), 
							lEntreprise.getTel(), lEntreprise.getMail(), lEntreprise.getMdp(), lEntreprise.getRaison(), lEntreprise.getDomaine(), lEntreprise.getSiret()}; 
					
					
					//appel de la methode pour ajouter cette ligne dans la tableau
					unTableau.add(ligne);
					
					this.txtIdclient.setText("");
					this.txtNom.setText("");
					this.txtPrenom.setText("");					
					this.txtRue.setText("");
					this.txtVille.setText("");
					this.txtCP.setText("");
					this.txtTel.setText("");
					this.txtMail.setText("");
					this.txtMDP.setText(""); 
					this.txtRaison.setText("");
					this.txtDomaine.setText("");
					this.txtSiret.setText("");
				}
			}
			else
				JOptionPane.showMessageDialog(this, "Veuillez cocher le type de votre client : Entreprise ou Particulier ?");
			
		}
			break;
		/*	
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
