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
 * Une place de parking : 
 * - un emplacement dans l'espace
 * - une "rotation" (en bataille, en épi, en créneau)
 * - libre ou non
 *
 */
@XmlRootElement
@Model
public class Place implements Serializable{

	private static final long serialVersionUID = 1L;
	@Attribute(primaryKey = true)
	private Key key;
	private int numeroDePlace;
	@Attribute(lob = true)
	private PointGPS point;
	private int rotation;
	private boolean free;
	
	public Place(){
		
	}
	/**
	 * Constructor
	 * @param point
	 * @param rotation
	 * @param free
	 */
	public Place(PointGPS point, int numero, int rotation, boolean free) {
		super();
		this.key = Datastore.createKey(this.getClass(), numero);
		this.point = point;
		this.numeroDePlace = numero;
		this.rotation = rotation;
		this.free = free;
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
	 * @return the point
	 */
	public PointGPS getPoint() {
		return point;
	}
	/**
	 * @param point the point to set
	 */
	public void setPoint(PointGPS point) {
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
	/**
	 * @return the numeroDePlace
	 */
	public int getNumeroDePlace() {
		return numeroDePlace;
	}
	/**
	 * @param numeroDePlace the numeroDePlace to set
	 */
	public void setNumeroDePlace(int numeroDePlace) {
		this.numeroDePlace = numeroDePlace;
	}
	
	
}
