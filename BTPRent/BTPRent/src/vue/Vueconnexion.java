package vue; // 1**** on a commeencer par le fichier puis ensuite la vue

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Main;

import modele.Modele;

public class Vueconnexion extends JFrame implements ActionListener, KeyListener
{
	private JPanel unPanel = new JPanel (); // variable représentant notre pannel
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btSeConnecter = new JButton("Se Connecter");
	private JTextField txtLogin = new JTextField(); // zone de saisie de texte
	private JPasswordField pvMdp = new JPasswordField(); // zone de saisie de mdp
	
	public Vueconnexion() 
	{	
		Font uneFont = new Font("Helvetica", Font.BOLD, 20);//INSTANCIATION DE LA POLICE
		this.setTitle("BTPRentGestion des locations"); //titre de la fenetre
		this.setBounds(400, 200, 1000, 600);
		this.setLayout(null); //pas de layout par defaut
		this.setResizable(false); //ne pas l'agrandir
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.GRAY);
		this.unPanel.setFont(uneFont);
		//construction du panel
		this.unPanel.setBounds(100, 300, 800, 250);
		this.unPanel.setLayout(new GridLayout (3, 2)); // grille de 3lignes / 2colonnes
		this.unPanel.setBackground(Color.CYAN);
		// champs et bouttons du pannel
		this.unPanel.add(new JLabel("Login : "));
		this.unPanel.add(this.txtLogin);
		this.unPanel.add(new JLabel("MDP : "));
		this.unPanel.add(this.pvMdp);
		this.unPanel.add(this.btAnnuler);
		this.unPanel.add(this.btSeConnecter);
		
		this.unPanel.setVisible(true); // on rend visible notre pannel
		
		this.add(this.unPanel); // on l'ajoute a la fenetre
		
		//ajout du logo
		ImageIcon logo = new ImageIcon("src/image/banner.jpg");
		JLabel lbLogo = new JLabel(logo);
		lbLogo.setBounds(100, 40, 800, 240);
		this.add(lbLogo);
		
		this.setVisible(true); // rendre visite la fenetre principale
		
		//changer l'icone de l'application
		ImageIcon logopetit = new ImageIcon("src/image/petit logo.jpg");
		this.setIconImage(logopetit.getImage());
		
		//rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		// rendre les zones de textes ecoutables avec la touche entrée
		this.txtLogin.addKeyListener(this);
		this.pvMdp.addKeyListener(this);
		
		this.setVisible(true); //rendre visite la fenetre principale
		
		// CHANGEMENT DE LA POLICE
		 
		this.btAnnuler.setFont(uneFont);
		this.btSeConnecter.setFont(uneFont);
	}
	
	public void traitement ()
	{
		String login = this.txtLogin.getText();
		String mdp = new String (this.pvMdp.getPassword());
		if(login.equals("") || mdp.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Veuillez saisir vos identifiants");
		}
		else{
			//on verifie dans la BDD la connexion
			String droits = Modele.VerifConnexion(login, mdp);
			if(droits.equals("")) // si droit est vide n'existe dans la BDD
			{
				JOptionPane.showMessageDialog(this, "Erreur de connexion","Erreur", JOptionPane.ERROR_MESSAGE);
				this.txtLogin.setText("");
				this.pvMdp.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Bienvenue !", "Connexion de réussie", JOptionPane.INFORMATION_MESSAGE);
				//lancement de la jframe principale
				Main.rendreVisible(false);
				new VueGenerale();
			}
		}
	}

	public void actionPerformed(ActionEvent e) { // e pour event
		switch (e.getActionCommand())
		{
		case "Annuler" :
			this.txtLogin.setText("");
			this.pvMdp.setText("");
			break;
		
		case "Se Connecter" :
			traitement();
			break;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyChar() == KeyEvent.VK_ENTER)//test de la touche entree
		{
			traitement();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
