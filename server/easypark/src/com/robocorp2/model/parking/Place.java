package com.robocorp2.model.parking;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;
import com.robocorp2.core.PlaceStatus;
import com.robocorp2.core.PlaceType;

/**
 * 
 * @author Mathieu Passenaud
 * Une place de parking : 
 * - un emplacement dans l'espace
 * - une "rotation" (en bataille, en �pi, en cr�neau)
 * - libre ou non
 *
 */
@XmlRootElement
@Model(kind = "Place")
public class Place implements Serializable{

	private static final long serialVersionUID = 1L;
	@Attribute(primaryKey = true)
	private Key key;
	private int numeroDePlace;
	@Attribute(lob = true)
	private PointGPS point;
	private int rotation;
	private PlaceStatus status;
	private PlaceType type;
	
	public Place(){
		
	}
	/**
	 * Constructor
	 * @param point
	 * @param rotation
	 * @param free
	 */
	public Place(PointGPS point, int numero, int rotation, PlaceStatus status, PlaceType type) {
		super();
		this.key = Datastore.createKey(Place.class, numero);
		this.point = point;
		this.numeroDePlace = numero;
		this.rotation = rotation;
		this.status = status;
		this.type = type;
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
	 * @return the status
	 */
	public PlaceStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(PlaceStatus status) {
		this.status = status;
	}
	
	public boolean isFree(){
		if(this.status.equals(PlaceStatus.FREE)){
			return true;
		}
		return false;
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
	/**
	 * @return the type
	 */
	public PlaceType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(PlaceType type) {
		this.type = type;
	}
	
	
}
