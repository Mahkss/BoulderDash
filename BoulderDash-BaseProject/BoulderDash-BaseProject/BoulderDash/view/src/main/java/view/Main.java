package view;

public class Main {
	
	
	public static void main(String[] args) throws InterruptedException {
		int game = 1;
		ViewFacade fenetre = new ViewFacade();
		while(game == 1){
			fenetre.repaint();
			fenetre.rammasserDiamand();
			Thread.sleep(500);
			game = fenetre.gagner();
		}
		ViewFacade victoire = new ViewFacade("Victoire");
		Thread.sleep(5000);
		victoire.finDuJeu();
	}

}
