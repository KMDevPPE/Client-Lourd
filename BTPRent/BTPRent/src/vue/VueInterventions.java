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

import modele.ModeleInterventions;
import modele.ModeleTechniciens;
import controleur.Tableau;
import controleur.Technicien;
import controleur.Intervention;


public class VueInterventions extends JPanel implements ActionListener
{
		private JButton btAjouter = new JButton("Ajouter");
		private JButton btSupprimer = new JButton("Supprimer");
		private JButton btEditer = new JButton("Editer");
		
		
		private JTable tableInterventions ;
		private Tableau unTableau ; //modele de tableau pour gerer la JTable
		
		private JTextField txtIdIntervention = new JTextField();
		private JTextField txtNomTechnicien = new JTextField();
		private JTextField txtIdMateriel = new JTextField();
		private JTextField txtDateDeb = new JTextField();
		private JTextField txtDateFin = new JTextField();
			
		
		//récuperer la dimension de l'écran
		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		int largeur = tailleMoniteur.width * 4/5;
		int hauteur = tailleMoniteur.height * 4/5;		
		
		public VueInterventions()
		{
			this.setBounds(0, hauteur/10, largeur, hauteur);
			this.setBackground(Color.red);
			this.setLayout(null); // les surface
			
			JPanel unPanel = new JPanel ();
			unPanel.setBounds(largeur/40, hauteur*2/3, largeur-(largeur/20), 120);
			unPanel.setLayout(new GridLayout(4, 4));
		
			unPanel.add(new JLabel("ID de l'intervention:"));
			unPanel.add(this.txtIdIntervention);
			unPanel.add(new JLabel(""));
			unPanel.add(new JLabel(""));
		
			unPanel.add(new JLabel("Nom du Technicien:"));
			unPanel.add(this.txtNomTechnicien);
			
			unPanel.add(new JLabel("ID du matériel : "));
			unPanel.add(this.txtIdMateriel);
			
			unPanel.add(new JLabel("Date de début de l'intervention: "));
			unPanel.add(this.txtDateDeb);
		
			unPanel.add(new JLabel("Date de fin de l'intervention : "));
			unPanel.add(this.txtDateFin);			

			unPanel.add(this.btAjouter);
			unPanel.add(this.btSupprimer);
			unPanel.add(this.btEditer);
			
			unPanel.add(new JLabel(""));
			
			
			unPanel.setVisible(true);
			this.txtIdIntervention.setEditable(false);
			this.add(unPanel);
			// rendre les boutons cliquables
			this.btAjouter.addActionListener(this);
			this.btSupprimer.addActionListener(this);
			this.btEditer.addActionListener(this);
			
			//construction de la JTable
			String entete [] ={"Id de l'intervention", "Nom  du Technicien", "Nom du matériel", "Date de début", "Date de fin"};
			Object [][] lesDonnees = remplirDonnees ();
			this.tableInterventions = new JTable(lesDonnees, entete);
			
			//gestion de la JTable avec le Tableau
			unTableau = new Tableau(lesDonnees, entete);
			this.tableInterventions = new JTable (unTableau);
			
			//ajouter l'evenement clic sur la table MouseListener
			this.tableInterventions.addMouseListener(new MouseListener() {
				
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
					int ligne = tableInterventions.getSelectedRow();
					txtIdIntervention.setText(tableInterventions.getValueAt(ligne, 0 ).toString());
					txtNomTechnicien.setText(tableInterventions.getValueAt(ligne, 1 ).toString());
					txtIdMateriel.setText(tableInterventions.getValueAt(ligne, 2).toString());
					txtDateDeb.setText(tableInterventions.getValueAt(ligne, 3).toString());
					txtDateFin.setText(tableInterventions.getValueAt(ligne, 4).toString());					
				}
			});
			
			JScrollPane uneScroll = new JScrollPane(tableInterventions);
			uneScroll.setBounds(largeur/40, largeur/60, largeur-(largeur/20), hauteur*3/5);
			this.add(uneScroll);
			this.setVisible(false);
		}


		private Object[][] remplirDonnees() { 
			ArrayList<Intervention> lesInterventions = ModeleInterventions.selectAllIntervention();
			Object [][] lesDonnees = new Object[lesInterventions.size()][5];
			int i = 0;
			for (Intervention uneIntervention : lesInterventions)
			{
				lesDonnees[i][0] = uneIntervention.getIdIntervention() +"";
				lesDonnees[i][1] = uneIntervention.getNomTechnicien();
				lesDonnees[i][2] = uneIntervention.getNomMateriel();
				lesDonnees[i][3] = uneIntervention.getDateDebut();
				lesDonnees[i][4] = uneIntervention.getDateFin();
				
				i++;
			} 
			
			return lesDonnees;
		}


		@Override
		public void actionPerformed(ActionEvent e) { 
			switch (e.getActionCommand()) {
				case "Ajouter":
				{
					String nomTechnicien = this.txtNomTechnicien.getText();
					String txtMateriel = this.txtIdMateriel.getText();
					int idMateriel = Integer.parseInt(this.txtIdMateriel.getText());
					String DateDeb = this.txtDateDeb.getText();
					String DateFin = this.txtDateFin.getText();
					if (nomTechnicien.equals("") || txtMateriel.equals(""))
					{
						JOptionPane.showMessageDialog(this, "Veuillez entrer un nom de Technicien et l'ID du matériel en question");
					}
					else
					{
						
						Intervention uneIntervention = new Intervention (idMateriel, nomTechnicien, DateDeb, DateFin);
						ModeleInterventions.insertIntervention(uneIntervention);
						JOptionPane.showMessageDialog(this, "Intervention insérée avec succès");
						// mise a jour de la Jtable
						Intervention lIntervention = ModeleInterventions.selectWhere(uneIntervention);
						
						Object ligne [] = {lIntervention.getIdIntervention(), lIntervention.getNomTechnicien(), lIntervention.getNomMateriel(), lIntervention.getDateDebut(), lIntervention.getDateFin()};
						
						
						//appel de la methode pour ajouter cette ligne dans la tableau
						unTableau.add(ligne);
						
						this.txtIdIntervention.setText("");
						this.txtNomTechnicien.setText("");
						this.txtIdMateriel.setText("");
						this.txtDateDeb.setText("");
						this.txtDateFin.setText("");
					}
				}
					break;
				case "Supprimer":
				{			
					String nomTechnicien = this.txtNomTechnicien.getText();
					String txtMateriel = this.txtIdMateriel.getText();
					int idMateriel = Integer.parseInt(this.txtIdMateriel.getText());
					String DateDeb = this.txtDateDeb.getText();
					String DateFin = this.txtDateFin.getText();
					if (nomTechnicien.equals("") || txtMateriel.equals(""))
					{
						JOptionPane.showMessageDialog(this, "Veuillez entrer un nom de Technicien et l'ID du matériel en question");
					}
					else
					{
						int idIntervention = Integer.parseInt(this.txtIdIntervention.getText());
						Intervention uneIntervention = new Intervention(idIntervention, idMateriel,nomTechnicien, "", "");
						ModeleInterventions.deleteIntervention(uneIntervention);
						JOptionPane.showMessageDialog(this, "Suppression de l'intervention réussie");
						
						int rowIndex = this.tableInterventions.getSelectedRow();
						unTableau.delete(rowIndex);
						
						txtIdIntervention.setText("");
						txtNomTechnicien.setText("");
						txtIdMateriel.setText("");
						txtDateDeb.setText("");
						txtDateFin.setText("");
					}				
						
				}
					break;
				case "Editer":
				{
					String nomTechnicien = this.txtNomTechnicien.getText();
					String txtMateriel = this.txtIdMateriel.getText();
					int idMateriel = Integer.parseInt(this.txtIdMateriel.getText());
					String DateDeb = this.txtDateDeb.getText();
					String DateFin = this.txtDateFin.getText();					
					if (nomTechnicien.equals("") || txtMateriel.equals(""))
					{
						JOptionPane.showMessageDialog(this, "Veuillez entrer un nom de Technicien et l'ID du matériel en question");
					}
					else
					{		
						int idIntervention = Integer.parseInt(this.txtIdIntervention.getText());
						Intervention uneIntervention = new Intervention(idIntervention, idMateriel, nomTechnicien, DateDeb, DateFin);
						ModeleInterventions.updateIntervention(uneIntervention);
						JOptionPane.showMessageDialog(this, "Mise à jour réussie");
						Object ligne [] = {uneIntervention.getIdIntervention(), uneIntervention.getNomTechnicien(), uneIntervention.getNomMateriel(), uneIntervention.getDateDebut(), uneIntervention.getDateFin()};
						int rowIndex = this.tableInterventions.getSelectedRow();
						unTableau.update(rowIndex, ligne);
						
						txtIdIntervention.setText("");
						txtNomTechnicien.setText("");
						txtIdMateriel.setText("");
						txtDateDeb.setText("");
						txtDateFin.setText("");						
					}			
				}
			}	
		}
	} 

