package gameCommons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import frog.Frog;
import givenEnvironment.GivenEnvironment;
import graphicalElements.FroggerGraphic;
import graphicalElements.IFroggerGraphics;

public class Main {

	public static void main(String[] args) {

		//Caract�ristiques du jeu
		int width = 26;
		int height = 20;
		int tempo = 100; //vitesse d'affichage
		int minSpeedInTimerLoops = 3; //nombre de vitesses différentes possibles
		double defaultDensity = 0.2;
		
		//Cr�ation de l'interface graphique
		IFroggerGraphics graphic = new FroggerGraphic(width, height);
		//Cr�ation de la partie
		Game game = new Game(graphic, width, height, minSpeedInTimerLoops, defaultDensity);
		//Cr�ation et liason de la grenouille
		IFrog frog = new Frog(game);	//appel au constructeur frog
		game.setFrog(frog);
		graphic.setFrog(frog);
		//Cr�ation et liaison de l'environnement
		IEnvironment env = new GivenEnvironment(game);
		game.setEnvironment(env);

		/*
		while (caractère diff de l'annulatif')
			(tout le processus d'update)
			demande caractère
			modifie direction de la frog si le caractère est bon
			(prit en compte au prochain update toutes les tempo milisecondes)
		 */


		//Scanner clavier = new Scanner(System.in);
		//System.out.println("Entrez un entier :");
		//int e = clavier.nextInt();

		// j'ajoute un objet implémentant l'interface KeyListener à ma fenetre
		//FroggerGraphic.addKeyListener(this);
		// je demande à ce que ce soit ma fenetre qui intercepte les touches du clavier
		//FroggerGraphic.requestFocusInWindow();
		//FroggerGraphic.keyPressed(e);

		//FroggerGraphic(width, height) = new FroggerGraphic(width, height);



		//Boucle principale : l'environnement s'acturalise tous les tempo milisecondes
		Timer timer = new Timer(tempo, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.update();	//chaque update lance un testWin et testLose, donc nul besoin de les ajouter ailleurs
				graphic.repaint();
			}
		});
		timer.setInitialDelay(0);
		timer.start();
	}
}
