package environment;

import java.awt.Color;
import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

public class Car {
	private Game game;
	private Case leftPosition; //coordonnées de l'extrémitié gauche de la voiture
	private boolean leftToRight; //1(true) si gauche a droite  et 0(false) si droite a gauche
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	//Constructeur de la voiture : //Construit à partir de cette ligne dans Lane : "cars.add(new Car(game, getBeforeFirstCase(), leftToRight));"
	public Car(Game game, Case leftPosition, boolean leftToRight){
		this.game = game;
		this.leftPosition = leftPosition;
		this.leftToRight = leftToRight; //ne peut pas être choisi aléatoirement, car le sens de la voiture doit être coordonné avec celui des autres voitures de sa voie
		this.length = game.randomGen.nextInt(2)+1; //methode random( (max-min)+1) qui permet d'entrer en arg une valeur entière qui servira de limite
	}

	//Voiture qui bouge selon son sens mais uniquement sur l'axe des absc
	public void move(boolean car) {
		if (car) { //Déplacement s'il y a une voiture
			if(leftToRight){ //Si ca va de gauche à droite on avance de 1 à droite
				this.leftPosition = new Case(this.leftPosition.absc+1, this.leftPosition.ord);
			} else{ //inversement
				this.leftPosition = new Case(this.leftPosition.absc -1, this.leftPosition.ord);
			}
		}
		this.addToGraphics(); //l'excécute quelque soit la valeur de car
	}

	//Regarde si case occupée(1) ou vide(0);
	public boolean isTaken(Case pos) {
		//On regarde d'abord si la voiture est sur la voie qui nous intèresse
		//Si oui, on regarde ensuite si la voiture couvre l'abscisse de notre case

		if (pos.ord != this.leftPosition.ord) {
			return false;
		} else {  //La voiture est sur la bonne voie
			//leftPosition.absc : abscisse de "départ" de la voiture, length : sa longueur
			//donc le nombre de cases (de la voie) sur lesquelles la voiture s'étale
			if (pos.absc >= this.leftPosition.absc && pos.absc < (this.leftPosition.absc + this.length)) {
				return true;
			}
		}
		return false;
	}


	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
