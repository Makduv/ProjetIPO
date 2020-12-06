package gameCommons;

import java.awt.Color;
import java.util.Random;

import environment.EnvInf;
import graphicalElements.Element;
import graphicalElements.IFroggerGraphics;
import util.Case;

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
		if(!environment.isSafe(frog.getPosition())){
			graphic.endGameScreen("You lost...   Score : "+ frog.getScore()); //on a ajouté le score ici
			return true;
		}
		return false;
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
		testLose();
		testWin(); //normalement c'est un jeu à l'infini donc on peut l'enlever
	}

	/**
	 * @Return la voie de la grenouille
	 * mit ici parce qu'on a les liens aux objetcs et la classe EnvInf la contient
	 */
	public int getFrogOrd() {
		return frog.getOrd();
	}

}
