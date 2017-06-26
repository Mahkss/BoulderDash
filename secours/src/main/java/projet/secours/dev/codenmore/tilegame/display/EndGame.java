package projet.secours.dev.codenmore.tilegame.display;


	import java.awt.BorderLayout;

	import javax.swing.ImageIcon;
	import javax.swing.JFrame;
	import javax.swing.JLabel;



public class EndGame extends JFrame {

		private static final long serialVersionUID = 1487831485026866458L;
		private JFrame end;
		private JLabel image;
		
		public EndGame(boolean end){
			dispose();
			if(end == false){
				victory();
			}else defeat();
			init();
		}
		
		
		public void init(){
			end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			end.setResizable(false); 
			end.setLocationRelativeTo(null); 
			end.setLayout(new BorderLayout());
			end.add(image,BorderLayout.CENTER);
			end.setVisible(true); 
		}
		
		
		public void defeat(){
			end = new JFrame("Game Over");
			end.setSize(496, 285);
			image = new JLabel(new ImageIcon("C:/Users/antoi/Desktop/A1/10. Conception d'applications prientées objets/08.Projet Java/secours/res/textures/GameOver.png"));
		}
		
		public void victory(){
			end = new JFrame("Victory");
			end.setSize(650, 350);
			image = new JLabel(new ImageIcon("C:/Users/maxpa/Desktop/BoulderDash-master/BoulderDash-master/secours/src/main/resources/Victory.png"));
		}
	}

