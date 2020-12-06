package environment;

import java.util.ArrayList;
import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

//import environment.Lane;  -> pas besoin d'importer cette classe, "lane.update" méthode publique

public class Environment implements IEnvironment {
		
	private Game game;
	private ArrayList<Lane> lanes;

	//On se fonde sur cette ligne du main : " IEnvironment env = new Environment(game); "
	public Environment(Game game){
		this.game = game;
		this.lanes = new ArrayList<>();

		//Remplissage du tableau des voies : lanes
		this.lanes.add(new Lane(this.game, 0, 0 )); //première ligne sans voiture (grenouille)
		for(int i = 1; i < this.game.height -1; i++){
			this.lanes.add(new Lane(this.game, i));
		}
		this.lanes.add(new Lane(this.game, this.game.height-1, 0)); //dernière ligne sans voiture (arrivé)
	}

	@Override
	public boolean isSafe(Case pos){
		return this.lanes.get(pos.ord).isSafe(pos);
	}

	@Override
	public boolean isWinningPosition(Case pos){
		return pos.ord  == this.game.height -1;
	}

	public void update(){
		for(Lane voie : this.lanes){
			voie.update();
		}
	}
}
