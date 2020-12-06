package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;


public class Frog implements IFrog {

	private Game game;
	private Case position;
	private Direction direction;

	public Frog(Game game){
		this.game = game;
		this.position = new Case(game.width/2 - 1, 0); //-1 car on démarre à l'indice 0
	}

	@Override
	public Case getPosition() { //on renvoit une Case
		return this.position;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}

	@Override
	//on entre la touche de direction que l'on veut
	//l'objet frog est modifié
	//on fait bouger la frog
	public void move(Direction key) {
		switch(key){
			case down:
				if(this.position.ord > 0){ //On fixe le bord du bas
					this.position = new Case(this.position.absc, this.position.ord - 1);
				}
				break;
			case up:
				if(this.position.ord < game.height-1){ //On fixe bord du haut
					this.position = new Case(this.position.absc, this.position.ord+1);
				}
				break;
			case left:
				if(this.position.absc > 0){ //On fixe bord de gauche
					this.position = new Case(this.position.absc-1, this.position.ord);
				}
				break;
			case right:
				if(this.position.absc < game.width-1){ //On fixe bord de droite
					this.position = new Case(this.position.absc+1, this.position.ord);
				}
		}
	}
}
