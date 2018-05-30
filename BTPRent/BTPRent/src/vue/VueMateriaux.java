package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
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
import modele.ModeleMateriaux;

import controleur.Materiel;
import controleur.Tableau;

public class VueMateriaux extends JPanel  implements ActionListener
{
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btEditer = new JButton("Editer");
	
	
	private JTable tableMateriaux ;
	private Tableau unTableau ; //modele de tableau pour gerer la JTable
	
	private JTextField txtIdMateriel = new JTextField();
	private JTextField txtNom = new JTextField();
	private JTextField txtEtat = new JTextField();
	private JTextField txtPrix = new JTextField();
	private JTextField txtLieu = new JTextField();
	private JTextField txtRue = new JTextField();
	private JTextField txtCP = new JTextField();
	private JTextField txtdateDeb = new JTextField();
	private JTextField txtdateFin = new JTextField();
	private JTextField txtLibelle = new JTextField();
	
	//récuperer la dimension de l'écran
		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		int largeur = tailleMoniteur.width * 4/5;
		int hauteur = tailleMoniteur.height * 4/5;
	
	public VueMateriaux()
	{
		this.setBounds(0, hauteur/10, largeur, hauteur);
		this.setBackground(Color.green);
		this.setLayout(null); // les surface
		
		JPanel unPanel = new JPanel ();
		unPanel.setBounds(largeur/40, hauteur*2/3, largeur-(largeur/20), 120);
		unPanel.setLayout(new GridLayout(5, 4));
		
		 //premiere case vide
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel("ID Materiel"));
		unPanel.add(txtIdMateriel);
		unPanel.add(new JLabel("")); 
		
		unPanel.add(new JLabel("Nom :"));
		unPanel.add(this.txtNom);
		
		unPanel.add(new JLabel("Prix location/semaine : "));
		unPanel.add(this.txtPrix);
		
		unPanel.add(new JLabel("Lieu : "));
		unPanel.add(this.txtLieu);
		
		unPanel.add(new JLabel(" Code Postal : "));
		unPanel.add(this.txtCP);
		
		unPanel.add(new JLabel(" Rue : "));
		unPanel.add(this.txtRue);
		
		unPanel.add(new JLabel(" Type de matériel: "));
		unPanel.add(this.txtLibelle);		
		
		unPanel.add(new JLabel("")); 
		unPanel.add(new JLabel(" Etat du matériel : "));
		unPanel.add(this.txtEtat);
		unPanel.add(new JLabel("")); 
		
		unPanel.add(new JLabel("")); 
		unPanel.add(new JLabel(" Début : "));
		unPanel.add(this.txtdateDeb);
		unPanel.add(new JLabel("")); 
		
		unPanel.add(new JLabel("")); 
		unPanel.add(new JLabel(" Fin : "));
		unPanel.add(this.txtdateFin);
		unPanel.add(new JLabel("")); 
		
		unPanel.add(this.btAjouter);
		unPanel.add(this.btSupprimer);
		unPanel.add(this.btEditer);
		unPanel.add(new JLabel(""));
		this.txtIdMateriel.setEditable(false);
		
		unPanel.setVisible(true);
		this.add(unPanel);
		// rendre les boutons cliquables
		this.btAjouter.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btEditer.addActionListener(this);
		
		
		//construction de la JTable
		String entete [] = {"ID Materiel", "Nom du materiel", "Prix de la location/semaine", "Lieu", "Code Postal", "Rue", "Type Materiel", "Etat", "Debut", "Fin"};
		Object [][] lesDonnees = remplirDonnees ();
		this.tableMateriaux = new JTable(lesDonnees, entete);
		
		//gestion de la JTable avec le Tableau
		unTableau = new Tableau(lesDonnees, entete);
		this.tableMateriaux = new JTable (unTableau);
		
		
		//ajouter l'evenement clic sur la table MouseListener
		this.tableMateriaux.addMouseListener(new MouseListener() {
			
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
				int ligne = tableMateriaux.getSelectedRow();
				txtIdMateriel.setText(tableMateriaux.getValueAt(ligne, 0).toString());
				txtNom.setText(tableMateriaux.getValueAt(ligne, 1).toString());
				txtLibelle.setText(tableMateriaux.getValueAt(ligne, 2).toString());
				txtEtat.setText(tableMateriaux.getValueAt(ligne, 3).toString());
				txtPrix.setText(tableMateriaux.getValueAt(ligne, 4).toString());
				txtLieu.setText(tableMateriaux.getValueAt(ligne, 5).toString());
				txtCP.setText(tableMateriaux.getValueAt(ligne, 6).toString());
				txtRue.setText(tableMateriaux.getValueAt(ligne, 7).toString());
				txtdateDeb.setText(tableMateriaux.getValueAt(ligne, 8).toString());
				txtdateFin.setText(tableMateriaux.getValueAt(ligne, 9).toString());
				
				
			}
		});
		
		JScrollPane uneScroll = new JScrollPane(tableMateriaux);
		uneScroll.setBounds(largeur/40, largeur/60, largeur-(largeur/20), hauteur*3/5);
		this.add(uneScroll);
		this.setVisible(false);
	}

	
	private Object[][] remplirDonnees() {
		ArrayList<Materiel> lesMateriaux = ModeleMateriaux.selectAllMateriel();
		Object [][] lesDonnees = new Object[lesMateriaux.size()][6];
		int i = 0;
		for (Materiel unMateriel : lesMateriaux)
		{
			lesDonnees[i][0] = unMateriel.getIdMateriel() +"";
			lesDonnees[i][1] = unMateriel.getNom();
			lesDonnees[i][1] = unMateriel.getPrix();
			lesDonnees[i][2] = unMateriel.getLieu();
			lesDonnees[i][1] = unMateriel.getCp();
			lesDonnees[i][1] = unMateriel.getRue();
			lesDonnees[i][4] = unMateriel.getLibelle();
			lesDonnees[i][1] = unMateriel.getNomEtat();
			lesDonnees[i][1] = unMateriel.getDateDeb();
			lesDonnees[i][1] = unMateriel.getDateFin();
			
			System.out.println(unMateriel.getNom());
			i++;
		}
		
		return lesDonnees;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String nom = this.txtNom.getText();
		String etat = this.txtEtat.getText();
		String prixT = this.txtPrix.getText();
		String lieu = this.txtLieu.getText();
		String cp = this.txtCP.getText();
		String rue = this.txtRue.getText();
		String libelle = this.txtLibelle.getText();
		String dateDeb = this.txtdateDeb.getText();
		String dateFin = this.txtdateFin.getText();
		
		
		float prix = Float.parseFloat(prixT);
		
		
		switch (e.getActionCommand()) { 
		case "Ajouter":
		{
				
			if (nom.equals("") || etat.equals("") || prix == 0 || lieu.equals("") || libelle.equals("") || cp.equals("") || rue.equals("") )
			{
				JOptionPane.showMessageDialog(this, "Veuillez remplir les champs obligatoires");
			}
			else
			{
				Materiel unMateriel = new Materiel (prix, nom, lieu, cp, rue, dateDeb, dateFin, etat, libelle);
				ModeleMateriaux.insertMateriel(unMateriel);
				JOptionPane.showMessageDialog(this, "Materiel inséré avec succès");
				// mise a jour de la Jtable
				Materiel leMateriel = ModeleMateriaux.selectWhere(unMateriel);
				
				Object ligne [] = {leMateriel.getPrix(),leMateriel.getNom(), leMateriel.getLieu(), leMateriel.getCp(), leMateriel.getRue(),leMateriel.getDateDeb(),leMateriel.getDateFin(),leMateriel.getNomEtat(),leMateriel.getLibelle()};
				
				
				//appel de la methode pour ajouter cette ligne dans la tablea
				unTableau.add(ligne);
				
				this.txtPrix.setText("");
				this.txtNom.setText("");
				this.txtLieu.setText("");
				this.txtCP.setText("");
				this.txtRue.setText("");
				this.txtdateDeb.setText("");
				this.txtdateFin.setText("");
				this.txtEtat.setText("");
				this.txtLibelle.setText("");
			}
		}
			break;
		case "Supprimer":
		{			
			
			if (nom.equals("") || etat.equals("") || prix == 0 || lieu.equals("") || libelle.equals("") || cp.equals("") || rue.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez sélectionner un materiel");
			}
			else
			{
				int idMateriel = Integer.parseInt(txtIdMateriel.getText());
				Materiel unMateriel = new Materiel(idMateriel, nom, "", "", "", "","","","");
				ModeleMateriaux.deleteMateriel(unMateriel);
				JOptionPane.showMessageDialog(this, "Suppression réussie");
				
				int rowIndex = this.tableMateriaux.getSelectedRow();
				unTableau.delete(rowIndex);
				
				this.txtPrix.setText("");
				this.txtNom.setText("");
				this.txtLieu.setText("");
				this.txtCP.setText("");
				this.txtRue.setText("");
				this.txtdateDeb.setText("");
				this.txtdateFin.setText("");
				this.txtEtat.setText("");
				this.txtLibelle.setText("");
			}				
				
		}
			break;
		case "Editer":
		{
			
			if (nom.equals("") || etat.equals("") || prix == 0 || lieu.equals("") || libelle.equals("") || cp.equals("") || rue.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez sélectionner un materiel");
			}
			else
			{
				int idMateriel = Integer.parseInt(txtIdMateriel.getText());			
				Materiel unMateriel = new Materiel(prix, nom, lieu, cp, rue, dateDeb, dateFin, etat, libelle);
				ModeleMateriaux.updateMateriel(unMateriel);
				JOptionPane.showMessageDialog(this, "Mise à jour réussie");
				
				Object ligne [] = {unMateriel.getPrix(),unMateriel.getNom(), unMateriel.getLieu(), unMateriel.getCp(), unMateriel.getRue(),unMateriel.getDateDeb(),unMateriel.getDateFin(),unMateriel.getNomEtat(),unMateriel.getLibelle()};
				
				int rowIndex = this.tableMateriaux.getSelectedRow();
				unTableau.update(rowIndex, ligne);
				
				this.txtPrix.setText("");
				this.txtNom.setText("");
				this.txtLieu.setText("");
				this.txtCP.setText("");
				this.txtRue.setText("");
				this.txtdateDeb.setText("");
				this.txtdateFin.setText("");
				this.txtEtat.setText("");
				this.txtLibelle.setText("");						
			}			
		}			
	}
		
}
}
