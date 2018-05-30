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

import controleur.Salarie;
import controleur.Tableau;

public class VueSalarie extends JPanel implements ActionListener
{
		private JButton btAjouter = new JButton("Ajouter");
		private JButton btSupprimer = new JButton("Supprimer");
		private JButton btEditer = new JButton("Editer");
		
		
		private JTable tableSalaries ;
		private Tableau unTableau ; //modele de tableau pour gerer la JTable
		
		private JTextField txtNom = new JTextField();
		private JTextField txtPrenom = new JTextField();
		private JTextField txtMail = new JTextField();
		private JTextField txtMdp = new JTextField();
		private JTextField txtDroits = new JTextField();
		private JTextField txtIdsalarie = new JTextField();		
		
		
		public VueSalarie()
		{
			this.setBounds(30, 100, 1440, 760);
			this.setBackground(Color.blue);
			this.setLayout(null); // les surface
			
			JPanel unPanel = new JPanel ();
			unPanel.setBounds(40, 550, 1350, 120);
			unPanel.setLayout(new GridLayout(5, 4));
			
			 //premiere case vide
			unPanel.add(new JLabel(""));
			unPanel.add(new JLabel("ID Salarie"));
			unPanel.add(txtIdsalarie);
			unPanel.add(new JLabel("")); 
			
			unPanel.add(new JLabel("Nom :"));
			unPanel.add(this.txtNom);
			
			unPanel.add(new JLabel("Prénom : "));
			unPanel.add(this.txtPrenom);
			
			unPanel.add(new JLabel("Mail: "));
			unPanel.add(this.txtMail);
		
			unPanel.add(new JLabel("Mot de passe : "));
			unPanel.add(this.txtMdp);
			
			unPanel.add(new JLabel("")); 
			unPanel.add(new JLabel("Droits : "));
			unPanel.add(this.txtDroits);
			unPanel.add(new JLabel("")); 
			
			unPanel.add(this.btAjouter);
			unPanel.add(this.btSupprimer);
			unPanel.add(this.btEditer);
			unPanel.add(new JLabel(""));
			this.txtIdsalarie.setEditable(false);
			
			unPanel.setVisible(true);
			this.add(unPanel);
			// rendre les boutons cliquables
			this.btAjouter.addActionListener(this);
			this.btSupprimer.addActionListener(this);
			this.btEditer.addActionListener(this);
			
			//construction de la JTable
			String entete [] = {"ID Salarié", "Nom du salarié", "Prénom du Salarié", "Mail du Salarié", "Mot de passe", "Droits"};
			Object [][] lesDonnees = remplirDonnees ();
			this.tableSalaries = new JTable(lesDonnees, entete);
			
			//gestion de la JTable avec le Tableau
			unTableau = new Tableau(lesDonnees, entete);
			this.tableSalaries = new JTable (unTableau);
			
			//ajouter l'evenement clic sur la table MouseListener
			this.tableSalaries.addMouseListener(new MouseListener() {
				
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
					int ligne = tableSalaries.getSelectedRow();
					txtIdsalarie.setText(tableSalaries.getValueAt(ligne, 0).toString());
					txtNom.setText(tableSalaries.getValueAt(ligne, 1 ).toString());
					txtPrenom.setText(tableSalaries.getValueAt(ligne, 2).toString());
					txtMail.setText(tableSalaries.getValueAt(ligne, 3).toString());
					txtMdp.setText(tableSalaries.getValueAt(ligne, 4).toString());
					txtDroits.setText(tableSalaries.getValueAt(ligne, 5).toString());
					
				}
			});
			
			JScrollPane uneScroll = new JScrollPane(tableSalaries);
			uneScroll.setBounds(50, 20, 1340, 500);
			this.add(uneScroll);
			this.setVisible(false);
		}


		private Object[][] remplirDonnees() {
			ArrayList<Salarie> lesSalaries = Modele.selectAllSalarie();
			Object [][] lesDonnees = new Object[lesSalaries.size()][6];
			int i = 0;
			for (Salarie unSalarie : lesSalaries)
			{
				lesDonnees[i][0] = unSalarie.getIdsalarie() +"";
				lesDonnees[i][1] = unSalarie.getNom();
				lesDonnees[i][2] = unSalarie.getPrenom();
				lesDonnees[i][3] = unSalarie.getMail();
				lesDonnees[i][4] = unSalarie.getMdp();
				lesDonnees[i][5] = unSalarie.getDroits();
				System.out.println(unSalarie.getNom());
				i++;
			}
			
			return lesDonnees;
		}


		@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand()) 
		{
			case "Ajouter":
			{
				String nom = this.txtNom.getText();
				String prenom = this.txtPrenom.getText();
				String mail = this.txtMail.getText();
				String mdp = this.txtMdp.getText();
				String droits = this.txtDroits.getText();
				if (nom.equals("") || prenom.equals("") || mail.equals("") || mdp.equals("") || droits.equals(""))
				{
					JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
				}
				else
				{
					Salarie unSalarie = new Salarie (nom, prenom, mail, mdp, droits);
					Modele.insertSalarie(unSalarie);
					JOptionPane.showMessageDialog(this, "Salarié inséré avec succès");
					// mise a jour de la Jtable
					Salarie leSalarie = Modele.selectWhere(unSalarie);
					
					Object ligne [] = {leSalarie.getIdsalarie(), leSalarie.getNom(),leSalarie.getPrenom(), leSalarie.getMail(), leSalarie.getMdp(), leSalarie.getDroits()};
					
					
					//appel de la methode pour ajouter cette ligne dans la tableau
					unTableau.add(ligne);
					
					this.txtIdsalarie.setText("");
					this.txtNom.setText("");
					this.txtPrenom.setText("");
					this.txtMail.setText("");
					this.txtMdp.setText("");
					this.txtDroits.setText("");
				}
			}
				break;
			case "Supprimer":
			{			
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String mail = txtMail.getText();
				String mdp = txtMdp.getText();
				String droits = txtDroits.getText();
				if (txtIdsalarie.getText().equals("") || nom.equals("") || prenom.equals(""))
				{
					JOptionPane.showMessageDialog(this, "Veuillez sélectionner une personne");
				}
				else
				{
					int idsalarie = Integer.parseInt(txtIdsalarie.getText());
					Salarie unSalarie = new Salarie(idsalarie, nom, prenom, "", "", "");
					Modele.deleteSalarie(unSalarie);
					JOptionPane.showMessageDialog(this, "Suppression réussie");
					
					int rowIndex = this.tableSalaries.getSelectedRow();
					unTableau.delete(rowIndex);
					
					txtIdsalarie.setText("");
					txtNom.setText("");
					txtPrenom.setText("");
					txtMail.setText("");
					txtMdp.setText("");
					txtDroits.setText("");
				}				
					
			}
				break;
			case "Editer":
			{
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();				
				String mail = txtMail.getText();
				String mdp = txtMdp.getText();
				String droits = txtDroits.getText();
				if (txtIdsalarie.getText().equals("") || nom.equals("") || prenom.equals(""))
				{
					JOptionPane.showMessageDialog(this, "Veuillez sélectionner une personne");
				}
				else
				{
					int idsalarie = Integer.parseInt(txtIdsalarie.getText());			
					Salarie unSalarie = new Salarie(idsalarie, nom, prenom, mail, mdp, droits);
					Modele.updateSalarie(unSalarie);
					JOptionPane.showMessageDialog(this, "Mise à jour réussie");
					Object ligne [] = {unSalarie.getIdsalarie(), unSalarie.getNom(), unSalarie.getPrenom(), unSalarie.getMail(), unSalarie.getMdp(), unSalarie.getDroits()};
					int rowIndex = this.tableSalaries.getSelectedRow();
					unTableau.update(rowIndex, ligne);
					txtIdsalarie.setText("");
					txtNom.setText("");
					txtPrenom.setText("");
					txtMail.setText("");
					txtMdp.setText("");
					txtDroits.setText("");							
				}			
			}			
		}
	}
}
