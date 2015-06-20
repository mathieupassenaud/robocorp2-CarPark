package com.robocorp2.model.parking;

/**
 * 
 * @author Mathieu Passenaud
 * Une place de parking : 
 * - un emplacement dans l'espace
 * - une "rotation" (en bataille, en épi, en créneau)
 * - libre ou non
 *
 */
public class Place {

	private Point point;
	private int rotation;
	private boolean free;
	
	/**
	 * Constructor
	 * @param point
	 * @param rotation
	 * @param free
	 */
	public Place(Point point, int rotation, boolean free) {
		super();
		this.point = point;
		this.rotation = rotation;
		this.free = free;
	}
	
	/**
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}
	/**
	 * @param point the point to set
	 */
	public void setPoint(Point point) {
		this.point = point;
	}
	/**
	 * @return the rotation
	 */
	public int getRotation() {
		return rotation;
	}
	/**
	 * @param rotation the rotation to set
	 */
	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	/**
	 * @return the free
	 */
	public boolean isFree() {
		return free;
	}
	/**
	 * @param free the free to set
	 */
	public void setFree(boolean free) {
		this.free = free;
	}
	
	
}
