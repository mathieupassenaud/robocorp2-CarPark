package com.robocorp2.model.parking;

import java.io.Serializable;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * 
 * @author Mathieu
 *
 */
@XmlRootElement
@Model(kind = "Camera")
public class Camera implements Serializable{

	private static final long serialVersionUID = 1L;
	@Attribute(primaryKey = true)
	private Key key;
	@Attribute(lob = true)
	private PointGPS point;
	private double hauteur;
	private int rotationInDegrees;
	private int focal;
	private String adresse;
	
	public Camera(PointGPS point, double hauteur, int rotationInDegrees, int focal, String adresse) {
		super();
		this.key = Datastore.createKey(Camera.class, UUID.randomUUID().toString());
		this.point = point;
		this.hauteur = hauteur;
		this.rotationInDegrees = rotationInDegrees;
		this.focal = focal;
		this.adresse = adresse;
	}
	public Camera() {
		super();
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
	 * @return the hauteur
	 */
	public double getHauteur() {
		return hauteur;
	}
	/**
	 * @param hauteur the hauteur to set
	 */
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	/**
	 * @return the rotationInDegrees
	 */
	public int getRotationInDegrees() {
		return rotationInDegrees;
	}
	/**
	 * @param rotationInDegrees the rotationInDegrees to set
	 */
	public void setRotationInDegrees(int rotationInDegrees) {
		this.rotationInDegrees = rotationInDegrees;
	}
	/**
	 * @return the focal
	 */
	public int getFocal() {
		return focal;
	}
	/**
	 * @param focal the focal to set
	 */
	public void setFocal(int focal) {
		this.focal = focal;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
