package com.robocorp2.model.parking;

/**
 * 
 * @author Mathieu Passenaud
 * Un vecteur avec un point de début et un point de fin.
 * On peut donc en déduire le sens
 *
 */
public class Vecteur {
	private Point pointDebut;
	private Point pointFin;
	
	/**
	 * Constructor
	 * @param pointDebut
	 * @param pointFin
	 */
	public Vecteur(Point pointDebut, Point pointFin) {
		super();
		this.pointDebut = pointDebut;
		this.pointFin = pointFin;
	}
	
	/**
	 * @return the pointDebut
	 */
	public Point getPointDebut() {
		return pointDebut;
	}
	/**
	 * @param pointDebut the pointDebut to set
	 */
	public void setPointDebut(Point pointDebut) {
		this.pointDebut = pointDebut;
	}
	/**
	 * @return the pointFin
	 */
	public Point getPointFin() {
		return pointFin;
	}
	/**
	 * @param pointFin the pointFin to set
	 */
	public void setPointFin(Point pointFin) {
		this.pointFin = pointFin;
	}
	
	
}
