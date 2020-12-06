package gameCommons;

import environment.EnvInf;
//import environment.Environment;
import frog_J1.FrogInf_J1;
import frog_J2.FrogInf_J2;
import graphicalElements.FroggerGraphic;
import graphicalElements.IFroggerGraphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

	public static void main(String[] args) {

		//Caractéristiques du jeu
		int width = 26;
		int height = 20;
		int tempo = 100;
		int minSpeedInTimerLoops = 2;
		double defaultDensity = 0.02;

		//Création de l'interface graphique
		IFroggerGraphics graphic = new FroggerGraphic(width, height);
		//Création de la partie
		Game game = new Game(graphic, width, height, minSpeedInTimerLoops, defaultDensity);
		//Création et liason de la grenouille

		//Nouvelle grenouille joueur 1
		IFrog frog1 = new FrogInf_J1(game);
		game.setFrog(frog1);
		graphic.setFrog(frog1);

		//Nouvelle grenouille joueur 2
		IFrog frog2 = new FrogInf_J2(game);
		game.setFrog(frog2);
		graphic.setFrog(frog2);
		//Création et liaison de l'environnement

		//Nouvel Environment
		IEnvironment env = new EnvInf(game);
		game.setEnvironment(env);

		//Boucle principale : l'environnement s'acturalise tous les tempo milisecondes
		Timer timer = new Timer(tempo, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.update();
				graphic.repaint();
			}
		});
		timer.setInitialDelay(0);
		timer.start();
	}
}
