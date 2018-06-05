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
	private JTextField txtImage = new JTextField();
	private JTextField txtStock = new JTextField();
	private JTextField txtType = new JTextField();
	
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
		unPanel.setLayout(new GridLayout(6, 4));
		
		 //premiere case vide
		
		unPanel.add(new JLabel("ID Materiel"));
		unPanel.add(txtIdMateriel);
		
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel("Nom :"));
		unPanel.add(this.txtNom);
		
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel("Prix location/semaine : "));
		unPanel.add(this.txtPrix);
		
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel("Lieu : "));
		unPanel.add(this.txtLieu);
		
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel(" Code Postal : "));
		unPanel.add(this.txtCP);
		
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel(" Rue : "));
		unPanel.add(this.txtRue);
		
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel(" Type de matériel: "));
		unPanel.add(this.txtType);		
		
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel(" Etat du matériel : "));
		unPanel.add(this.txtEtat);
		
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel(" Adresse de l'image : "));
		unPanel.add(this.txtImage); 
		
		unPanel.add(new JLabel("")); 
		unPanel.add(new JLabel(" Stock : "));
		unPanel.add(this.txtStock);
		unPanel.add(new JLabel(""));
		
		unPanel.add(new JLabel(""));
		unPanel.add(this.btAjouter);
		unPanel.add(this.btSupprimer);
		unPanel.add(this.btEditer);
		this.txtIdMateriel.setEditable(false);
		
		unPanel.setVisible(true);
		this.add(unPanel);
		// rendre les boutons cliquables
		this.btAjouter.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btEditer.addActionListener(this);
		
		
		//construction de la JTable
		String entete [] = {"ID Materiel", "Nom du materiel", "Prix de la location/semaine", "Lieu", "Code Postal", "Rue", "Type Materiel", "Etat", "Stock", "Image"};
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
				txtPrix.setText(tableMateriaux.getValueAt(ligne, 2).toString());
				txtLieu.setText(tableMateriaux.getValueAt(ligne, 3).toString());
				txtCP.setText(tableMateriaux.getValueAt(ligne, 4).toString());
				txtRue.setText(tableMateriaux.getValueAt(ligne, 5).toString());
				txtType.setText(tableMateriaux.getValueAt(ligne, 6).toString());
				txtEtat.setText(tableMateriaux.getValueAt(ligne, 7).toString());
				txtStock.setText(tableMateriaux.getValueAt(ligne, 8).toString());
				txtImage.setText(tableMateriaux.getValueAt(ligne, 9).toString());
				//"ID Materiel", "Nom du materiel", "Prix de la location/semaine", "Lieu", "Code Postal", "Rue", "Type Materiel", "Etat", "Stock", "Image"
				
			}
		});
		
		JScrollPane uneScroll = new JScrollPane(tableMateriaux);
		uneScroll.setBounds(largeur/40, largeur/60, largeur-(largeur/20), hauteur*3/5);
		this.add(uneScroll);
		this.setVisible(false);
	}

	
	private Object[][] remplirDonnees() {
		ArrayList<Materiel> lesMateriaux = ModeleMateriaux.selectAllMateriel();
		Object [][] lesDonnees = new Object[lesMateriaux.size()][10];
		int i = 0;
		for (Materiel unMateriel : lesMateriaux)
		{
			lesDonnees[i][0] = unMateriel.getIdMateriel() +"";
			lesDonnees[i][1] = unMateriel.getNom();
			lesDonnees[i][2] = unMateriel.getPrix();
			lesDonnees[i][3] = unMateriel.getLieu();
			lesDonnees[i][4] = unMateriel.getCp();
			lesDonnees[i][5] = unMateriel.getRue();
			lesDonnees[i][6] = unMateriel.getNomType();
			lesDonnees[i][7] = unMateriel.getNomEtat();
			lesDonnees[i][8] = unMateriel.getStock();
			lesDonnees[i][9] = unMateriel.getImage();
			
			System.out.println(unMateriel.getNom());
			i++;
		}
		
		return lesDonnees;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String nom = this.txtNom.getText();
		String etat = this.txtEtat.getText();
		String prixM = this.txtPrix.getText();
		String lieu = this.txtLieu.getText();
		String cp = this.txtCP.getText();
		String rue = this.txtRue.getText();
		String type = this.txtType.getText();
		String image = this.txtImage.getText();
		String stockM = this.txtStock.getText();
		
		int stock = Integer.parseInt(stockM);
		float prix = Float.parseFloat(prixM);
		
		
		switch (e.getActionCommand()) { 
		case "Ajouter":
		{
				
			if (nom.equals("") || etat.equals("") || prix == 0 || lieu.equals("") || type.equals("") || cp.equals("") || rue.equals("") || image.equals("") || stockM.equals("") )
			{
				JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs");
			}
			else
			{
				Materiel unMateriel = new Materiel (prix, nom, lieu, cp, rue, stock, image, etat, type);
				ModeleMateriaux.insertMateriel(unMateriel);
				JOptionPane.showMessageDialog(this, "Materiel inséré avec succès");
				// mise a jour de la Jtable
				Materiel leMateriel = ModeleMateriaux.selectWhere(unMateriel);
				
				Object ligne [] = {leMateriel.getIdMateriel(), leMateriel.getNom(),leMateriel.getPrix(), leMateriel.getLieu(), leMateriel.getCp(), leMateriel.getRue(),leMateriel.getNomType(),leMateriel.getNomEtat(),leMateriel.getStock(),leMateriel.getImage()};
				
				
				//appel de la methode pour ajouter cette ligne dans la tablea
				unTableau.add(ligne);
				
				this.txtIdMateriel.setText("");
				this.txtPrix.setText("");
				this.txtNom.setText("");
				this.txtLieu.setText("");
				this.txtCP.setText("");
				this.txtRue.setText("");
				this.txtImage.setText("");
				this.txtStock.setText("");
				this.txtEtat.setText("");
				this.txtType.setText("");
			}
		}
			break;
		case "Supprimer":
		{			
			
			if (nom.equals("") || etat.equals("") || prix == 0 || lieu.equals("") || type.equals("") || cp.equals("") || rue.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez sélectionner un materiel");
			}
			else
			{
				int idMateriel = Integer.parseInt(txtIdMateriel.getText());
				Materiel unMateriel = new Materiel(idMateriel, 0, nom, "", "", "", 0,"","","");
				ModeleMateriaux.deleteMateriel(unMateriel);
				JOptionPane.showMessageDialog(this, "Suppression réussie");
				
				int rowIndex = this.tableMateriaux.getSelectedRow();
				unTableau.delete(rowIndex);
				
				this.txtIdMateriel.setText("");
				this.txtPrix.setText("");
				this.txtNom.setText("");
				this.txtLieu.setText("");
				this.txtCP.setText("");
				this.txtRue.setText("");
				this.txtImage.setText("");
				this.txtStock.setText("");
				this.txtEtat.setText("");
				this.txtType.setText("");
			}				
				
		}
			break;
		case "Editer":
		{
			
			if (nom.equals("") || etat.equals("") || prix == 0 || lieu.equals("") || type.equals("") || cp.equals("") || rue.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez sélectionner un materiel");
			}
			else
			{
				int idMateriel = Integer.parseInt(txtIdMateriel.getText());			
				Materiel unMateriel = new Materiel(prix, nom, lieu, cp, rue, stock, image, etat, type);
				ModeleMateriaux.updateMateriel(unMateriel);
				JOptionPane.showMessageDialog(this, "Mise à jour réussie");
				
				Object ligne [] = {unMateriel.getPrix(),unMateriel.getNom(), unMateriel.getLieu(), unMateriel.getCp(), unMateriel.getRue(),unMateriel.getStock(),unMateriel.getImage(),unMateriel.getNomEtat(),unMateriel.getNomType()};
				
				int rowIndex = this.tableMateriaux.getSelectedRow();
				unTableau.update(rowIndex, ligne);
				
				this.txtIdMateriel.setText("");
				this.txtPrix.setText("");
				this.txtNom.setText("");
				this.txtLieu.setText("");
				this.txtCP.setText("");
				this.txtRue.setText("");
				this.txtImage.setText("");
				this.txtStock.setText("");
				this.txtEtat.setText("");
				this.txtType.setText("");						
			}			
		}			
	}
		
}
}
