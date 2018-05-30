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

import controleur.Contrat;
import controleur.Salarie;
import controleur.Tableau;
import modele.ModeleContrats;

public class VueContrats extends JPanel implements ActionListener
{
	private JButton btAjouter = new JButton("Ajouter Référent");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btEditer = new JButton("Editer");
	
	
	private JTable tableContrats ;
	private Tableau unTableau ; //modele de tableau pour gerer la JTable
	
	private JTextField txtIdContrat = new JTextField();	
	private JTextField txtNomClient = new JTextField();
	private JTextField txtNomMateriel = new JTextField();
	private JTextField txtNomReferent = new JTextField();
	private JTextField txtDateDebut = new JTextField();
	private JTextField txtDateFin = new JTextField();	
	//récuperer la dimension de l'écran
	Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
	int largeur = tailleMoniteur.width * 4/5;
	int hauteur = tailleMoniteur.height * 4/5;
	
	public VueContrats()
	{
		this.setBounds(0, hauteur/10, largeur, hauteur);
		this.setBackground(Color.pink);
		this.setLayout(null); // les surface
		
		JPanel unPanel = new JPanel ();
		unPanel.setBounds(largeur/40, hauteur*2/3, largeur-(largeur/20), 120);
		unPanel.setLayout(new GridLayout(5, 4));
		System.out.println(+largeur+" "+hauteur);
		 //premiere case vide
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel("ID Contrat"));
		unPanel.add(txtIdContrat);
		unPanel.add(new JLabel("")); 
		
		unPanel.add(new JLabel("Nom :"));
		unPanel.add(this.txtNomClient);
		
		unPanel.add(new JLabel("Matériel loué : "));
		unPanel.add(this.txtNomMateriel);
		
		unPanel.add(new JLabel("Enployé référent "));
		unPanel.add(this.txtNomReferent);
	
		unPanel.add(new JLabel("Date de début : "));
		unPanel.add(this.txtDateDebut);
		
		unPanel.add(new JLabel("")); 
		unPanel.add(new JLabel("Date de Fin : "));
		unPanel.add(this.txtDateFin);
		unPanel.add(new JLabel("")); 
		
		unPanel.add(this.btAjouter);
		unPanel.add(this.btSupprimer);
		unPanel.add(this.btEditer);
		unPanel.add(new JLabel(""));
		this.txtIdContrat.setEditable(false);
		
		unPanel.setVisible(true);
		this.add(unPanel);
		// rendre les boutons cliquables
		this.btAjouter.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btEditer.addActionListener(this);
		//construction de la JTable
		String entete [] = {"ID Contrat", "Nom du client", "Matériel loué", "Employé référent", "Date de début", "Date de fin"};
		Object [][] lesDonnees = remplirDonnees ();
		this.tableContrats = new JTable(lesDonnees, entete);
		
		//gestion de la JTable avec le Tableau
		unTableau = new Tableau(lesDonnees, entete);
		this.tableContrats = new JTable (unTableau); 
		
		//ajouter l'evenement clic sur la table MouseListener
		this.tableContrats.addMouseListener(new MouseListener() {
			
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
				int ligne = tableContrats.getSelectedRow();
				txtIdContrat.setText(tableContrats.getValueAt(ligne, 0).toString());
				txtNomClient.setText(tableContrats.getValueAt(ligne, 1 ).toString());
				txtNomMateriel.setText(tableContrats.getValueAt(ligne, 2).toString());
				txtNomReferent.setText(tableContrats.getValueAt(ligne, 3).toString());
				txtDateDebut.setText(tableContrats.getValueAt(ligne, 4).toString());
				txtDateFin.setText(tableContrats.getValueAt(ligne, 5).toString());
				
			}
		});
		
		JScrollPane uneScroll = new JScrollPane(tableContrats);
		uneScroll.setBounds(largeur/40, largeur/60, largeur-(largeur/20), hauteur*3/5);
		this.add(uneScroll);
		this.setVisible(false);
	}


	private Object[][] remplirDonnees() 
	{
		ArrayList<Contrat> lesContrats = ModeleContrats.selectAllContrat();
		Object [][] lesDonnees = new Object[lesContrats.size()][6];
		int i = 0;
		for (Contrat unContrat : lesContrats)
		{
			/*lesDonnees[i][0] = unContrat.getIdContrat() +"";
			lesDonnees[i][1] = unContrat.getIdClient() +"";
			lesDonnees[i][2] = unContrat.getIdMateriel() +"";
			lesDonnees[i][3] = unContrat.getIdSalarie();
			lesDonnees[i][4] = unContrat.getDateDebut();
			lesDonnees[i][5] = unContrat.getDateFin();
			System.out.println(unContrat.getIdContrat());
			i++; */
			lesDonnees[i][0] = unContrat.getIdContrat() +"";
			lesDonnees[i][1] = unContrat.getNomClient() ;
			lesDonnees[i][2] = unContrat.getNomMateriel();
			lesDonnees[i][3] = unContrat.getNomSalarie();
			lesDonnees[i][4] = unContrat.getDateDebut();
			lesDonnees[i][5] = unContrat.getDateFin();
			System.out.println(unContrat.getIdContrat());
			i++; 
		}		
		return lesDonnees;
	} 

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand()) 
		{
			case "Ajouter Référent":
			{
				String nomClient = txtNomClient.getText();
				String nomMateriel = txtNomMateriel.getText();
				String nomRef = txtNomReferent.getText();
				String dateDeb = txtDateDebut.getText();
				String dateFin = txtDateFin.getText();
				
				if (txtIdContrat.getText().equals("") || nomRef.equals(""))
				{
					JOptionPane.showMessageDialog(this, "Veuillez sélectionner un contrat");
				}
				else
				{
					int idContrat = Integer.parseInt(txtIdContrat.getText());
					Salarie unSalarie = new Salarie(nomRef);		
					Contrat unContrat = new Contrat(idContrat, nomClient, nomMateriel, nomRef, dateDeb, dateFin);
					ModeleContrats.updateSalarieContrat(unContrat, unSalarie);
					JOptionPane.showMessageDialog(this, "Mise à jour réussie");
					Object ligne [] = {unContrat.getIdContrat(), unContrat.getNomClient(), unContrat.getNomMateriel(), unContrat.getNomSalarie(),
							unContrat.getDateDebut(), unContrat.getDateFin()};
					int rowIndex = this.tableContrats.getSelectedRow();
					unTableau.update(rowIndex, ligne);
					txtIdContrat.setText("");
					txtNomClient.setText("");
					txtNomMateriel.setText("");
					txtNomReferent.setText("");
					txtDateDebut.setText("");
					txtDateFin.setText("");							
				}			
			}			
		}
	
		
	}
}	
