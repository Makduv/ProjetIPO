package gameCommons;

import util.Case;
import util.Direction;

public interface IFrog {
	
	/**
	 * Donne la position actuelle de la grenouille
	 * @return
	 */
	public Case getPosition();
	
	/**
	 * Donne la direction de la grenouille, c'est � dire de son dernier mouvement 
	 * @return
	 */
	public Direction getDirection();
	
	/**
	 * D�place la grenouille dans la direction donn�e et teste la fin de partie
	 * @param key
	 */
	public void move(Direction key);


	/**
	 * Donne l'indice de la grenouille
	 * @param
	 */
	public int getOrd();

	/**
	 * Permet de stocker le score de fin de jeu
	 * @param
	 */
	public int getScore();

}
