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

import controleur.Client;
import controleur.Tableau;

public class VueClients extends JPanel implements ActionListener
{
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btEditer = new JButton("Editer");
	
	
	private JTable tableClients ;
	private Tableau unTableau ; //modele de tableau pour gerer la JTable
	
	private JTextField txtNom = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtIdclient = new JTextField();
	
	 
	
	
	
	
	public VueClients()
	{
		this.setBounds(40, 140, 1440, 760);
		this.setBackground(Color.magenta);
		this.setLayout(null); // les surface
		
		JPanel unPanel = new JPanel ();
		unPanel.setBounds(40, 550, 1400, 80);
		unPanel.setLayout(new GridLayout(3, 4));
		
		unPanel.add(new JLabel("")); //premiere case vide
		unPanel.add(new JLabel("ID client"));
		unPanel.add(txtIdclient);
		unPanel.add(new JLabel("")); 
		
		unPanel.add(new JLabel("Nom : "));
		unPanel.add(this.txtNom);
		unPanel.add(new JLabel("Adresse : "));
		unPanel.add(this.txtAdresse);
		
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
		String entete [] = {"ID Client", "Nom du client", "Adresse Client"};
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
				txtAdresse.setText(tableClients.getValueAt(ligne, 2).toString());
				
			}
		});
		
		JScrollPane uneScroll = new JScrollPane(tableClients);
		uneScroll.setBounds(50, 20, 500, 150);
		this.add(uneScroll);
		this.setVisible(false);
	}


	private Object[][] remplirDonnees() {
		ArrayList<Client> lesClients = Modele.selectAllClients();
		Object [][] lesDonnees = new Object[lesClients.size()][3];
		int i = 0;
		for (Client unClient : lesClients)
		{
			lesDonnees[i][0] = unClient.getIdclient() +"";
			lesDonnees[i][1] = unClient.getNom();
			lesDonnees[i][2] = unClient.getAdresse();
			System.out.println(unClient.getNom());
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
		}
		}	
		
	}
}
