package parking;

import java.io.Serializable;
import java.util.List;


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

public class Parking implements Serializable {


	private static final long serialVersionUID = -4208347064635298120L;

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
		this.nom = nom;
		this.adresse = adresse;
		this.etages = etages;
		this.pointGPSLat = gps.getX();
		this.pointGPSLon = gps.getY();
	}
	
	public Parking(List<Etage> etages, String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.etages = etages;
		
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
