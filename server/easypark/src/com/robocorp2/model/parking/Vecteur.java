package com.robocorp2.model.parking;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * 
 * @author Mathieu Passenaud
 * Un vecteur avec un point de début et un point de fin.
 * On peut donc en déduire le sens
 *
 */
@XmlRootElement
@Model
public class Vecteur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Attribute(primaryKey = true)
	private Key key;
	@Attribute(lob = true)
	private PointGPS pointDebut;
	@Attribute(lob = true)
	private PointGPS pointFin;
	
	
	public Vecteur(){
		
	}
	/**
	 * Constructor
	 * @param pointDebut
	 * @param pointFin
	 */
	public Vecteur(PointGPS pointDebut, PointGPS pointFin) {
		super();
		this.pointDebut = pointDebut;
		this.pointFin = pointFin;
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
	 * @return the pointDebut
	 */
	public PointGPS getPointDebut() {
		return pointDebut;
	}
	/**
	 * @param pointDebut the pointDebut to set
	 */
	public void setPointDebut(PointGPS pointDebut) {
		this.pointDebut = pointDebut;
	}
	/**
	 * @return the pointFin
	 */
	public PointGPS getPointFin() {
		return pointFin;
	}
	/**
	 * @param pointFin the pointFin to set
	 */
	public void setPointFin(PointGPS pointFin) {
		this.pointFin = pointFin;
	}
	
	
}
