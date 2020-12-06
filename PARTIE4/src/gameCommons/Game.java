package gameCommons;

import java.awt.Color;
import java.time.Instant;
import java.util.Random;


import graphicalElements.Element;
import graphicalElements.IFroggerGraphics;

import java.time.Instant;
import java.time.Duration;

//On a besoin d'importer Instant pour représenter un moment dans le temps (ici debut de jeu et fin pour savoir cb de temps on a tenu)
//On a besoin d'importer Duration pour convertir en secondes

public class Game {

	public final Random randomGen = new Random();

	// Caracteristique de la partie
	public final int width;
	public final int height;
	public final int minSpeedInTimerLoops;
	public final double defaultDensity;

	// Lien aux objets utilisés
	private IEnvironment environment;
	private IFrog frog;
	private IFroggerGraphics graphic;

	//On a ici les paramètres de la game. On met donc le temps ici.
	private Instant t0 = Instant.now(); //Des que le jeu commence la fonction enregistre l'heure exacte a la nano secondes près
	private Instant t1;
	//Si on ne créer pas une condition d'arret le temps continuera a tourner même si la partie est terminée
	private boolean stop = false;


	/**
	 *
	 * @param graphic
	 *            l'interface graphique
	 * @param width
	 *            largeur en cases
	 * @param height
	 *            hauteur en cases
	 * @param minSpeedInTimerLoop
	 *            Vitesse minimale, en nombre de tour de timer avant déplacement
	 * @param defaultDensity
	 *            densite de voiture utilisee par defaut pour les routes
	 */
	public Game(IFroggerGraphics graphic, int width, int height, int minSpeedInTimerLoop, double defaultDensity) {
		super();
		this.graphic = graphic;
		this.width = width;
		this.height = height;
		this.minSpeedInTimerLoops = minSpeedInTimerLoop;
		this.defaultDensity = defaultDensity;

	}

	/**
	 * Lie l'objet frog � la partie
	 *
	 * @param frog
	 */
	public void setFrog(IFrog frog) {
		this.frog = frog;
	}

	/**
	 * Lie l'objet environment a la partie
	 *
	 * @param environment
	 */
	public void setEnvironment(IEnvironment environment) {
		this.environment = environment;
	}

	/**
	 *
	 * @return l'interface graphique
	 */
	public IFroggerGraphics getGraphic() {
		return graphic;
	}

	/**
	 * Teste si la partie est perdue et lance un écran de fin approprié si tel
	 * est le cas
	 *
	 * @return true si le partie est perdue
	 */
	public boolean testLose() {
		return !environment.isSafe(frog.getPosition());
	}

	/**
	 * Teste si la partie est gagnee et lance un écran de fin approprié si tel
	 * est le cas
	 *
	 * @return true si la partie est gagnée
	 */
	//Vu que le jeu est infini on en a pas vraiment besoin ici
	public boolean testWin() {
		return environment.isWinningPosition(frog.getPosition());
	}

	/**
	 * Actualise l'environnement, affiche la grenouille et verifie la fin de
	 * partie.
	 */
	public void update() {
		graphic.clear();
		environment.update();
		this.graphic.add(new Element(frog.getPosition(), Color.GREEN)); //met graphiquement la grenouille a sa position a chaaque update
		if(testLose()){
			if(!stop){ //Ca permet de stop le temps comme indiqué plus haut
				stop = true;
				t1 = Instant.now(); //Prend le temps quand la partie est perdue
			}
			double temps = Duration.between(t0, t1).toSeconds();//On fait la différence entre les deux et on le veut en secondes

			graphic.endGameScreen("You lost...\nScore : "+ frog.getScore()+"\nTemps : " + temps); //on a ajouté le score ici
		}

		//Par contre je comprends pas pq ca prend pas plus que les secondes.
		//Millisecondes c'est trop galère

		//testWin(); //normalement c'est un jeu à l'infini donc on peut l'enlever
	}

	/**
	 * @Return la voie de la grenouille
	 * mit ici parce qu'on a les liens aux objetcs et la classe EnvInf la contient
	 */
	public int getFrogOrd() {
		return frog.getOrd();
	}

}
