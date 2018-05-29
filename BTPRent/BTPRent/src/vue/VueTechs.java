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

import modele.ModeleTechniciens;
import controleur.Tableau;
import controleur.Technicien;

public class VueTechs extends JPanel implements ActionListener
{
		private JButton btAjouter = new JButton("Ajouter");
		private JButton btSupprimer = new JButton("Supprimer");
		private JButton btEditer = new JButton("Editer");
		
		
		private JTable tableTechniciens ;
		private Tableau unTableau ; //modele de tableau pour gerer la JTable
		
		private JTextField txtNom = new JTextField();
		private JTextField txtPrenom = new JTextField();
		private JTextField txtMail = new JTextField();
		private JTextField txtMdp = new JTextField();
		private JTextField txtIdTechnicien = new JTextField();		
		
		
		public VueTechs()
		{
			this.setBounds(40, 100, 1440, 760);
			this.setBackground(Color.yellow);
			this.setLayout(null); // les surface
			
			JPanel unPanel = new JPanel ();
			unPanel.setBounds(40, 550, 1350, 120);
			unPanel.setLayout(new GridLayout(4, 4));
			
			 //premiere case vide
			unPanel.add(new JLabel(""));
			unPanel.add(new JLabel("ID Technicien"));
			unPanel.add(txtIdTechnicien);
			unPanel.add(new JLabel("")); 
			
			unPanel.add(new JLabel("")); 
			unPanel.add(new JLabel("Nom :"));
			unPanel.add(this.txtNom);
			
			unPanel.add(new JLabel("")); 
			unPanel.add(new JLabel("Prénom : "));
			unPanel.add(this.txtPrenom);
			
			unPanel.add(new JLabel("Mail: "));
			unPanel.add(this.txtMail);
		
			unPanel.add(new JLabel(""));
			unPanel.add(new JLabel("Mot de passe : "));
			unPanel.add(this.txtMdp);			
			  
			unPanel.add(new JLabel("")); 
			
			unPanel.add(this.btAjouter);
			unPanel.add(this.btSupprimer);
			unPanel.add(this.btEditer);
			unPanel.add(new JLabel(""));
			this.txtIdTechnicien.setEditable(false);
			
			unPanel.setVisible(true);
			this.add(unPanel);
			// rendre les boutons cliquables
			this.btAjouter.addActionListener(this);
			this.btSupprimer.addActionListener(this);
			this.btEditer.addActionListener(this);
			
			//construction de la JTable
			String entete [] = {"ID Technicien", "Nom du technicien", "Prénom du Technicien", "Mail du Technicien", "Mot de passe"};
			Object [][] lesDonnees = remplirDonnees ();
			this.tableTechniciens = new JTable(lesDonnees, entete);
			
			//gestion de la JTable avec le Tableau
			unTableau = new Tableau(lesDonnees, entete);
			this.tableTechniciens = new JTable (unTableau);
			
			//ajouter l'evenement clic sur la table MouseListener
			this.tableTechniciens.addMouseListener(new MouseListener() {
				
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
					int ligne = tableTechniciens.getSelectedRow();
					txtIdTechnicien.setText(tableTechniciens.getValueAt(ligne, 0).toString());
					txtNom.setText(tableTechniciens.getValueAt(ligne, 1 ).toString());
					txtPrenom.setText(tableTechniciens.getValueAt(ligne, 2).toString());
					txtMail.setText(tableTechniciens.getValueAt(ligne, 3).toString());
					txtMdp.setText(tableTechniciens.getValueAt(ligne, 4).toString());					
				}
			});
			
			JScrollPane uneScroll = new JScrollPane(tableTechniciens);
			uneScroll.setBounds(50, 20, 1340, 500);
			this.add(uneScroll);
			this.setVisible(false);
		}


		private Object[][] remplirDonnees() { 
			ArrayList<Technicien> lesTechniciens = ModeleTechniciens.selectAllTechnicien();
			Object [][] lesDonnees = new Object[lesTechniciens.size()][5];
			int i = 0;
			for (Technicien unTechnicien : lesTechniciens)
			{
				lesDonnees[i][0] = unTechnicien.getIdTechnicien() +"";
				lesDonnees[i][1] = unTechnicien.getNom();
				lesDonnees[i][2] = unTechnicien.getPrenom();
				lesDonnees[i][3] = unTechnicien.getMail();
				lesDonnees[i][4] = unTechnicien.getMdp();
				System.out.println(unTechnicien.getNom());
				i++;
			} 
			
			return lesDonnees;
		}


		@Override
		public void actionPerformed(ActionEvent e) { 
			switch (e.getActionCommand()) {
				case "Ajouter":
				{
					String nom = this.txtNom.getText();
					String prenom = this.txtPrenom.getText();
					String mail = this.txtMail.getText();
					String mdp = this.txtMdp.getText();
					if (nom.equals("") || prenom.equals("") || mail.equals("") || mdp.equals("") )
					{
						JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
					}
					else
					{
						Technicien unTechnicien = new Technicien (nom, prenom, mail, mdp);
						ModeleTechniciens.insertTechnicien(unTechnicien);
						JOptionPane.showMessageDialog(this, "Technicien inséré avec succès");
						// mise a jour de la Jtable
						Technicien leTechnicien = ModeleTechniciens.selectWhere(unTechnicien);
						
						Object ligne [] = {leTechnicien.getIdTechnicien(), leTechnicien.getNom(),leTechnicien.getPrenom(), leTechnicien.getMail(), leTechnicien.getMdp()};
						
						
						//appel de la methode pour ajouter cette ligne dans la tableau
						unTableau.add(ligne);
						
						this.txtIdTechnicien.setText("");
						this.txtNom.setText("");
						this.txtPrenom.setText("");
						this.txtMail.setText("");
						this.txtMdp.setText("");
					}
				}
					break;
				case "Supprimer":
				{			
					String nom = txtNom.getText();
					String prenom = txtPrenom.getText();
					String mail = txtMail.getText();
					String mdp = txtMdp.getText();
					if (txtIdTechnicien.getText().equals("") || nom.equals("") || prenom.equals(""))
					{
						JOptionPane.showMessageDialog(this, "Veuillez sélectionner un technicien");
					}
					else
					{
						int IdTechnicien = Integer.parseInt(txtIdTechnicien.getText());
						Technicien unTechnicien = new Technicien(IdTechnicien, nom, prenom, "", "");
						ModeleTechniciens.deleteTechnicien(unTechnicien);
						JOptionPane.showMessageDialog(this, "Suppression du technicien réussie");
						
						int rowIndex = this.tableTechniciens.getSelectedRow();
						unTableau.delete(rowIndex);
						
						txtIdTechnicien.setText("");
						txtNom.setText("");
						txtPrenom.setText("");
						txtMail.setText("");
						txtMdp.setText("");
					}				
						
				}
					break;
				case "Editer":
				{
					String nom = txtNom.getText();
					String prenom = txtPrenom.getText();				
					String mail = txtMail.getText();
					String mdp = txtMdp.getText();
					if (txtIdTechnicien.getText().equals("") || nom.equals("") || prenom.equals(""))
					{
						JOptionPane.showMessageDialog(this, "Veuillez sélectionner une personne");
					}
					else
					{
						int IdTechnicien = Integer.parseInt(txtIdTechnicien.getText());			
						Technicien unTechnicien = new Technicien(IdTechnicien, nom, prenom, mail, mdp);
						ModeleTechniciens.updateTechnicien(unTechnicien);
						JOptionPane.showMessageDialog(this, "Mise à jour réussie");
						Object ligne [] = {unTechnicien.getIdTechnicien(), unTechnicien.getNom(), unTechnicien.getPrenom(), unTechnicien.getMail(), unTechnicien.getMdp()};
						int rowIndex = this.tableTechniciens.getSelectedRow();
						unTableau.update(rowIndex, ligne);
						txtIdTechnicien.setText("");
						txtNom.setText("");
						txtPrenom.setText("");
						txtMail.setText("");
						txtMdp.setText("");						
					}			
				}
			}	
		}
	} 
