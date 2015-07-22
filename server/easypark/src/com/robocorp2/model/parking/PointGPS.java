package com.robocorp2.model.parking;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * 
 * @author Mathieu Passenaud
 * un point dans l'espace
 *
 */
@XmlRootElement
@Model(kind = "PointGPS")
public class PointGPS implements Serializable {

	private static final long serialVersionUID = 1L;
	@Attribute(primaryKey = true)
	private Key key;
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
		this.key=Datastore.createKey(PointGPS.class, x+","+y);
		this.x = x;
		this.y = y;
	}
	
	
	
	/**
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(Key key) {
		this.key = key;
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
