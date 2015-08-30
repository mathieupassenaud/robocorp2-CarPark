package obj;

import java.util.ArrayList;

import detectionParking.JsonIgnoreProperties;


public class Etage {
	private String key;
	private ArrayList<Place> places;
	private ArrayList<Camera> cameras;
	@JsonIgnoreProperties({"chemins" })
	public Etage(){
		
	}

	public ArrayList<Place> getPlaces() {
		return places;
	}

	public void setPlaces(ArrayList<Place> places) {
		this.places = places;
	}

	public ArrayList<Camera> getCameras() {
		return cameras;
	}

	public void setCameras(ArrayList<Camera> cameras) {
		this.cameras = cameras;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
