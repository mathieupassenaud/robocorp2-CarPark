package obj;

import java.awt.Color;

import detectionParking.JsonIgnore;

public class Place {
	private String key;
	private int numeroDePlace;
	private PointGPS point;
	
	@JsonIgnore
	private Point pointLocal;
	
	private int rotation;
	private boolean free;
	@JsonIgnore
	private Blob blobDetecte;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getNumeroDePlace() {
		return numeroDePlace;
	}
	public void setNumeroDePlace(int numeroDePlace) {
		this.numeroDePlace = numeroDePlace;
	}
	public PointGPS getPoint() {
		return point;
	}
	public void setPoint(PointGPS point) {
		this.point = point;
	}
	public int getRotation() {
		return rotation;
	}
	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}

	public Place clone(){
		Place place = new Place();
		place.setFree(this.isFree());
		place.setKey(this.getKey());
		place.setNumeroDePlace(this.getNumeroDePlace());
		place.setPoint(this.getPoint());
		place.setRotation(this.getRotation());
		return place;
		
	}
	@JsonIgnore
	public Blob getBlob() {
		return blobDetecte;
	}
	@JsonIgnore
	public void setBlob(Blob blob) {
		this.blobDetecte = blob;
	}
	@JsonIgnore
	public Point getPointLocal() {
		return pointLocal;
	}
	@JsonIgnore
	public void setPointLocal(Point pointLocal) {
		this.pointLocal = pointLocal;
	}
}
