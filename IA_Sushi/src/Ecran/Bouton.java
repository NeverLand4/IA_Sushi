package Ecran;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class Bouton{
	// Les coordonnées indiquent la position relative par rapport au coin supérieur gauche du jeu
	private int coord_rel_x;
	private int coord_rel_y;
	private int coin_jeu_x;
	private int coin_jeu_y;
	private int delay;
	
	public Bouton(int x, int y, Repere r){
		this.coord_rel_x = x;
		this.coord_rel_y = y;
		this.coin_jeu_x = r.getCoord_x();
		this.coin_jeu_y = r.getCoord_y();
		this.delay = 1000;
	}
	
	public Bouton(int x, int y, Repere r, int delay){
		this.coord_rel_x = x;
		this.coord_rel_y = y;
		this.coin_jeu_x = r.getCoord_x();
		this.coin_jeu_y = r.getCoord_y();
		this.delay = delay;
	}
	
	public int computeCoord_x (){
		return this.coin_jeu_x+this.coord_rel_x;
	}
	
	public int computeCoord_y (){
		return this.coin_jeu_y+this.coord_rel_y;

	}
	public void clicGauche(Robot robot){
		robot.mouseMove(computeCoord_x(),computeCoord_y());
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(this.delay);
	}
	public void clicGauche(Robot robot, int d){
		robot.mouseMove(computeCoord_x(),computeCoord_y());
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(d);
	}
	
}