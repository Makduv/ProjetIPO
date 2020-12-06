package environment;

import java.util.ArrayList;
import util.Case;
import gameCommons.Game;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars;
	private boolean leftToRight;
	private double density;
	private double timer; //double selon les valeurs qu'on veut donner à timer

	public Lane(Game game, int ord, double density){
		this.cars = new ArrayList<>();
		this.game = game;
		this.ord = ord; //son indice dans la liste des voies du jeu
		this.density = density; //pas de méthode pour définir ça de façon aléatoire
		this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops)+1; //méthode random qui permet d'entrer en arg une valeur entière qui servira de limite
		//+1 parce que sinon on a des voitures trop trop lentes wsh // x))
		this.leftToRight = game.randomGen.nextBoolean(); //aléatoire entre 0 ( droite a gauche) et 1 (gauche à droite)
		timer = 0;

		//Remplissage initial du tableau de voitures : cars
		for(int i = 0; i < game.width; ++i) {
			//this.cars.ADD -> car on peut faire .add sur un ArrayList
			//this.cars.add(new Car...) -> car c'est un ArrayList contenant des Car, on ne peut donc qu'ajouter des Car
			//this.cars.add(new Car(this.game, ,this.leftToRight)

			this.moveCars(true); //au début : pas de voiture, aucun déplacement
			this.mayAddCar();
		}

	}

	//Création de voie avec moins de paramètres.
	//Plus cool pour les lignes sans contraintes.
	public Lane(Game game, int ord){
		this(game, ord, game.defaultDensity);
	}

	public void update() {

		// Toutes les voitures se déplacent d'une case au bout d'un nombre "tic
		// d'horloge" égal à leur vitesse
		// Notez que cette méthode est appelée à chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut être ajoutée

		this.timer++;
		if (this.timer >= this.speed) {  //il faut qu'assez de temps se soit écoulé pour que les voitures se déplacent
			this.moveCars(true); //actualisation de l'affichage fait à l'intérieur
			this.mayAddCar(); //si les voitures se déplacent, la première case de la voie se libère
			this.timer = 0;
		} else { // if (timer < this.speed) -> donc les voitures ne se déplacent pas
			this.moveCars(false); //pour pouvoir exécuter addToGraphics malgré tout
		}

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas
		//(DEMOI) : je pense via la méthode dans Cars : addGraphics
	}

	//actualisation de l'affichage des voitures fait à l'intérieur
	private void moveCars(boolean bool){
		for(Car voiture : this.cars){
			voiture.move(bool);
		}
	}

	//On regarde si la case ou est notre voiture est vide, on parcours donc tout le tableau
	public boolean isSafe(Case pos){
		for(Car voiture : this.cars){ //on étudie chaque voiture du tableau de voitures associé à la voie
			if(voiture.isTaken(pos)){
				return false;
				//si voiture.testCarCase est true, la case est couverte donc NOT freeCase -> on renvoit False
				//il est ou le testCarCase wtf dude
			}
		}
		return true;
		//si on ne trouve aucune voiture sur cette case, renvoie True car la case est libre
	}

	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
	 * densit�, si la premi�re case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight)); //leftToRight : le sens de déplacement sur la voie
			}
		}
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}
}
