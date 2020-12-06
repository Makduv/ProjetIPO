package gameCommons;

import java.awt.Color;
import java.util.Random;

import graphicalElements.Element;
import graphicalElements.IFroggerGraphics;

public class Game {

	public final Random randomGen = new Random();

	// Caracteristique de la partie
	public final int width;
	public final int height;
	public final int minSpeedInTimerLoops;
	public final double defaultDensity;

	// Lien aux objets utilisés (pas initialisés dans la méthode constructeur) :
	private IEnvironment environment; //c'est par ce biais qu'on invoque les méthodes IEnvrionment
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
	 * Lie l'objet frog à la partie
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
	 * Teste si la partie est perdue et lance un �cran de fin appropri� si tel
	 * est le cas
	 * 
	 * @return true si le partie est perdue
	 */
	public boolean testLose() {
		if(!environment.isSafe(frog.getPosition())){
			graphic.endGameScreen("You lost... :( ");
			return true;
		}
		return false;
	}

	/**
	 * Teste si la partie est gagnee et lance un �cran de fin appropri� si tel
	 * est le cas
	 * 
	 * @return true si la partie est gagn�e
	 */
	public boolean testWin() {
		if(environment.isWinningPosition(frog.getPosition())){ //on regarde si la position actuelle de frog est gagnante
			graphic.endGameScreen("You won ! :)");
			return true;
		}
		return false;
	}

	/*
		//il nous faut accéder à l'ordonnée de frog via iFrog seulement
		//on aurait pu stocker this.frog.getPosition() dans une Case, et ensuite consulter son ord
		if((this.height - 1) == (this.frog.getPosition()).ord) {
			graphic.endGameScreen("You won !");
			return true;
		}
		//j'ai utilisé une méthode de iFrog pour définir une autre méthode de iFrog
		//(car testWin est utilisé dans la méthode move)

		//on va combiner une iFrog avec une iEnvironment
		//return environment.isWinningPosition(this.frog.getPosition());
		return false;
	}


		//partie gagnée si frog a réussit à atteindre la dernière ligne
		//puisque la taille du jeu est définie et fixée au début, il suffit de s'y référer
		for (Case position : tableau) {
			if (tableau.(position) contient frog) {
				return true;
			}
		}
		return false;

		 */

	/**
	 * Actualise l'environnement, affiche la grenouille et verifie la fin de
	 * partie.
	 */
	public void update() {
		graphic.clear();
		environment.update();
		this.graphic.add(new Element(frog.getPosition(), Color.GREEN));
		testLose();
		testWin();
	}

}
