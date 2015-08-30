package obj;

import detectionParking.JsonIgnoreProperties;

public class Camera {
	private String key;
	private PointGPS point;
	private double hauteur;
	private int rotationInDegrees;
	private int focal;
	private String adresse;
	@JsonIgnoreProperties({"key"})

	public PointGPS getPoint() {
		return point;
	}
	public void setPoint(PointGPS point) {
		this.point = point;
	}
	public double getHauteur() {
		return hauteur;
	}
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	public int getRotationInDegrees() {
		return rotationInDegrees;
	}
	public void setRotationInDegrees(int rotationInDegrees) {
		this.rotationInDegrees = rotationInDegrees;
	}
	public int getFocal() {
		return focal;
	}
	public void setFocal(int focal) {
		this.focal = focal;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
