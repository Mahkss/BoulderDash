package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;




public class ViewFacade extends JFrame implements IView {
	private static final long serialVersionUID = 185615803024725338L;
	private JLabel bando;
	private JLabel image;
	private JButton but;
	private int diamandRamasser = 0;
	private int diamandMap = 18;
	private int diamandRestant = 9;
	private int time;
	private JLabel victoire;
    
    public ViewFacade() {
        super("Boulder Dash");
        init();
    }

    public ViewFacade(String titre) {
        super(titre);
        this.setVisible(true);
		initEnd();

    }
 
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void init(){
    	this.setLocationRelativeTo(null);
    	this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(10, 10);
		this.setResizable(false);
		this.setSize(960,1025);
		this.setLayout(new BorderLayout());
		getContentPane().setBackground(Color.black);
		this.bando = new JLabel("Diamand restant : " + diamandRestant + "                                 Diamand : " + diamandRamasser + "/" + diamandMap + "                            temps restant : ...");
		Font font = new Font("Arial",Font.BOLD,20);
		bando.setFont(font);
		this.but = new JButton("Map");
		this.image = new JLabel( new ImageIcon( "C:/Users/antoi/OneDrive/Images/Overwatch/13525295_134466833646876_1873999331_n.jpg"));
		bando.setForeground(new Color(255,255,255));     
		this.add(bando, BorderLayout.NORTH);
		this.add(image, BorderLayout.CENTER);
		this.add(but, BorderLayout.CENTER);
    }
    
    public void initEnd(){
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(10 ,10);
		this.setResizable(false);
		this.setSize(500, 550);
		this.setLayout(new BorderLayout());
		this.victoire = new JLabel("Bravo, Tu as Gagné la partie !!!    Tu est fort !!! <3");
		getContentPane().setBackground(Color.black);
		Font font = new Font("Arial",Font.BOLD,20);
		victoire.setFont(font);
		victoire.setForeground(new Color(255,255,255)); 
		this.image = new JLabel( new ImageIcon( "C:/Users/antoi/OneDrive/Images/Overwatch/13525295_134466833646876_1873999331_n.jpg"));
		this.add(victoire, BorderLayout.NORTH);
		this.add(image, BorderLayout.CENTER);
    }
    
    
    
    public void rammasserDiamand(){
    	this.diamandRamasser = this.diamandRamasser + 1;
    	this.diamandRestant = this.diamandRestant - 1;
    	System.out.println(diamandRamasser);
    	this.bando.setText("Diamand restant : " + diamandRestant + "                                 Diamand : " + diamandRamasser + "/" + diamandMap + "                            temps restant : ...");
    }
    
    public int gagner(){
    	if(diamandRestant == 0){
    		dispose();
    		return 0;
    	}
    	else{
    		return 1;
    	}
    		
    }
    
    public void finDuJeu(){
    	dispose();
    }
    
}
