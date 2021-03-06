package com.robocorp2.model.parking;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * A parking
 * 
 * Model : 
 * - key
 * - List Etages
 * - name
 * - adress
 * @author Mathieu Passenaud
 *
 */
@XmlRootElement
@Entity
@Model(kind = "Parking")
public class Parking implements Serializable {


	private static final long serialVersionUID = -4208347064635298120L;
	@Attribute(primaryKey = true)
	@Id
	private Key key;
	@Attribute(lob = true)
	private List<Etage> etages;
	
	private String nom;
	

	private String adresse;
	private double pointGPSLat;
	private double pointGPSLon;
	

	public Parking() {
		super();
	}

	public Parking(List<Etage> etages, String nom, String adresse, PointGPS gps) {
		super();
		
		this.key = Datastore.createKey(Parking.class, nom);
		this.nom = nom;
		this.adresse = adresse;
		this.etages = etages;
		this.pointGPSLat = gps.getX();
		this.pointGPSLon = gps.getY();
	}
	
	public Parking(Key key, List<Etage> etages, String nom, String adresse) {
		super();
		this.key = key;
		this.nom = nom;
		this.adresse = adresse;
		this.etages = etages;
		
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
	 * @return the etages
	 */
	public List<Etage> getEtages() {
		return etages;
	}

	/**
	 * @param etages the etages to set
	 */
	public void setEtages(List<Etage> etages) {
		this.etages = etages;
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
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

	/**
	 * @return the pointGPSLat
	 */
	public double getPointGPSLat() {
		return pointGPSLat;
	}

	/**
	 * @param pointGPSLat the pointGPSLat to set
	 */
	public void setPointGPSLat(double pointGPSLat) {
		this.pointGPSLat = pointGPSLat;
	}

	/**
	 * @return the pointGPSLon
	 */
	public double getPointGPSLon() {
		return pointGPSLon;
	}

	/**
	 * @param pointGPSLon the pointGPSLon to set
	 */
	public void setPointGPSLon(double pointGPSLon) {
		this.pointGPSLon = pointGPSLon;
	}

	
}
