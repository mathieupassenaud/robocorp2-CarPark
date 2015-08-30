package obj;

import java.util.ArrayList;

import detectionParking.JsonIgnoreProperties;

public class Parking {
	@JsonIgnoreProperties({"nom", "adresse","pointGPSLat","pointGPSLon" })
	private String key;
	private ArrayList<Etage> etages;
//	private String nom;
//	private String adresse;
//	private double pointGPSLat;
//	private double pointGPSLon;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public ArrayList<Etage> getEtages() {
		return etages;
	}
	public void setEtages(ArrayList<Etage> etages) {
		this.etages = etages;
	}
//	public String getNom() {
//		return nom;
//	}
//	public void setNom(String nom) {
//		this.nom = nom;
//	}
//	public String getAdresse() {
//		return adresse;
//	}
//	public void setAdresse(String adresse) {
//		this.adresse = adresse;
//	}
//	public double getPointGPSLat() {
//		return pointGPSLat;
//	}
//	public void setPointGPSLat(double pointGPSLat) {
//		this.pointGPSLat = pointGPSLat;
//	}
//	public double getPointGPSLon() {
//		return pointGPSLon;
//	}
//	public void setPointGPSLon(double pointGPSLon) {
//		this.pointGPSLon = pointGPSLon;
//	}
}
