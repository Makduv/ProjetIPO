package frog_J1;

import util.Case;
import gameCommons.Game;
import gameCommons.IFrog;
import util.Direction;

public class FrogInf_J1 implements IFrog {
    private Case position;
    private Game game;
    private int ord;
    private int score = 0;
    private Direction direction;

    public FrogInf_J1(Game game){
        this.game = game;
        this.position = new Case(20, 1);
        this.ord = 1; //On a besoin de stocker la voie
    }

    @Override
    //Fonction inutilisé mais dans IFrog donc ??
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    //Donne la voie de la grenouille
    // Va nous servir a créer un indice sur lequelle on se basera pour faire bouger le tableau tout en la gardant "static".
    public int getOrd() {
        return ord;
    }

    @Override
    //Va permettre de stocker le score.
    public int getScore() {
        return score;
    }

    @Override
    public Case getPosition() {
        return position;
    }

    @Override
    public void move(Direction key) {
        switch (key) {
            case down:
                if (this.ord > 1) { // on veut pas aller en dessous de 1 pour esthétique
                    this.ord--; //On descend de 1
                }
                break;
            case up:
                this.ord++; //On monte de 1
                if (this.ord - 1 > score) { //On va enregistrer le score ici
                    score = ord - 1; // On commence à 1 donc le score doit avoir -1
                }
                break;
            case left:
                if (this.position.absc > 0) {
                    this.position = new Case(this.position.absc - 1, this.position.ord);
                }
                break;
            case right:
                if (this.position.absc < game.width - 1) {
                    this.position = new Case(this.position.absc + 1, this.position.ord);
                }
        }
    }
}