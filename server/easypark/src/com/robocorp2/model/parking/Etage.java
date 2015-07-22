package com.robocorp2.model.parking;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * 
 * @author Mathieu Passenaud
 * Un étage de parking contenant : 
 * - des places
 * - des itinéraires 
 *
 */
@XmlRootElement
@Model
public class Etage implements Serializable {

	private static final long serialVersionUID = 1L;
	@Attribute(primaryKey = true)
	private Key key;
	@Attribute(lob = true)
	private List<Place> places;
	@Attribute(lob = true)
	private List<Vecteur> chemins;
	@Attribute(lob = true)
	private List<Camera> cameras;
	
	public Etage(){
		
	}
	/**
	 * Constructor
	 * @param places
	 * @param chemins
	 */
	public Etage(List<Place> places, List<Vecteur> chemins, List<Camera> cameras) {
		super();
		this.key = Datastore.createKey(this.getClass(), "etage");
		this.places = places;
		this.chemins = chemins;
		this.cameras = cameras;
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
	 * @return the places
	 */
	public List<Place> getPlaces() {
		return places;
	}
	/**
	 * @param places the places to set
	 */
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	/**
	 * @return the chemins
	 */
	public List<Vecteur> getChemins() {
		return chemins;
	}
	/**
	 * @param chemins the chemins to set
	 */
	public void setChemins(List<Vecteur> chemins) {
		this.chemins = chemins;
	}
	/**
	 * @return the cameras
	 */
	public List<Camera> getCameras() {
		return cameras;
	}
	/**
	 * @param cameras the cameras to set
	 */
	public void setCameras(List<Camera> cameras) {
		this.cameras = cameras;
	}
	
	
	
}
