package com.robocorp2.model.parking;

import java.util.List;

/**
 * 
 * @author Mathieu Passenaud
 * Un étage de parking contenant : 
 * - des places
 * - des itinéraires 
 *
 */
public class Etage {

	private List<Place> places;
	private List<Vecteur> chemins;
	
	/**
	 * Constructor
	 * @param places
	 * @param chemins
	 */
	public Etage(List<Place> places, List<Vecteur> chemins) {
		super();
		this.places = places;
		this.chemins = chemins;
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
	
	
}
