package parking;

import java.io.Serializable;

/**
 * 
 * @author Mathieu Passenaud
 * un point dans l'espace
 *
 */
public class PointGPS implements Serializable {

	private static final long serialVersionUID = 1L;
	private double x;
	private double y;

	public PointGPS(){
		
	}
	
	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	public PointGPS(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	
}
