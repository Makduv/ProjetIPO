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
		this.position = new Case(game.width/2 - 1, 0);
	}

	@Override
	public Case getPosition() {
		return this.position;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}

	@Override
	public void move(Direction key) {
		switch(key){
			case down:
				if(this.position.ord > 0){
					this.position = new Case(this.position.absc, this.position.ord - 1);
				}
				break;
			case up:
				if(this.position.ord < game.height-1){
					this.position = new Case(this.position.absc, this.position.ord+1);
				}
				break;
			case left:
				if(this.position.absc > 0){
					this.position = new Case(this.position.absc-1, this.position.ord);
				}
				break;
			case right:
				if(this.position.absc < game.width-1){
					this.position = new Case(this.position.absc+1, this.position.ord);
				}
		}
	}


}
