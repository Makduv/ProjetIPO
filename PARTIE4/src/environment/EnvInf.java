package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class EnvInf implements IEnvironment {
    private ArrayList<Lane> lanes;
    private ArrayList<Lane> lanesInf;
    private Game game;

    //Même construction que l'ancien Environment
    public EnvInf(Game game){
        this.lanes = new ArrayList<>();
        this.game = game;
        this.lanes.add(new Lane(game, 0, 0)); //première voie sans rien pour visibilité
        this.lanes.add(new Lane(game, 1, 0)); //voie libre pour le depart de la grenouille
        for (int i = 2; i < game.height; i++) {
            this.lanes.add(new Lane(game, i));
        }
    }

    @Override
    public boolean isSafe(Case pos) {
        return lanesInf.get(pos.ord).isSafe(pos); //On veut connaitre la sureté d'une case dans le tableau infini
    }

    @Override
    //pas besoin vu que c'est infini, on ne peut que perdre
    public boolean isWinningPosition(Case pos) {
        return (pos.ord == game.height - 1);
    }

    @Override
    public void update() { //on update le tableau pour qu'il soit à l'infini

        int indice = game.getFrogOrd() - 1; //On commence à 0 mais notre grenouille est à 1
        if (indice + game.height > lanes.size()){ //si on depasse on crée une nouvelle ligne en haut de lanes
            this.lanes.add(new Lane(game, indice + game.height));
        }

        this.lanesInf = new ArrayList<>(); //On crée le nouveau tableau infini
        for (int i = 0; i < game.height; i++) {
            this.lanes.get(i + indice).setOrd(i);
            this.lanesInf.add(this.lanes.get(i + indice)); //ajoute les lignes aux tableau effet infini
        }
        for (int i = 0; i < lanesInf.size(); i++) { //actualise se tableau infini en permanence
            this.lanesInf.get(i).update();
        }
    }
}