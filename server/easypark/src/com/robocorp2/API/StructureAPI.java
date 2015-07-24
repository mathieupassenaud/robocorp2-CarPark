package com.robocorp2.API;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.appengine.api.datastore.Key;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.robocorp2.DAO.ParkingDAO;
import com.robocorp2.core.KeyAdapterSerializer;
import com.robocorp2.core.PlaceStatus;
import com.robocorp2.model.parking.Camera;
import com.robocorp2.model.parking.Etage;
import com.robocorp2.model.parking.Parking;
import com.robocorp2.model.parking.Place;
import com.robocorp2.model.parking.PointGPS;
import com.robocorp2.model.parking.Vecteur;
import com.simplapi.jersey.doc.annotation.ApiAuthor;
import com.simplapi.jersey.doc.annotation.ApiDoc;
import com.simplapi.jersey.doc.annotation.ApiVersion;

@Path("structure")
@ApiDoc("Ce sont les data de démos, permet de voir la structure des données")
@ApiAuthor("Mathieu Passenaud")
@ApiVersion("0.1")
public class StructureAPI {
	public static Gson gson = (new GsonBuilder()).serializeNulls()
			.setPrettyPrinting().registerTypeAdapter(Key.class, new KeyAdapterSerializer()).create();
	@GET
	@Path("parking")
	@Produces("application/JSON")
	@ApiDoc("Retourne un modèle de parking")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public String getDemoParking(){
		String nom = "Parking de démo";
		String adresse = "Adresse - 31000 Toulouse";
		ArrayList<Etage> etages = new ArrayList<Etage>();
		ArrayList<Place> places = new ArrayList<Place>();
		ArrayList<Vecteur> chemins = new ArrayList<Vecteur>();
		ArrayList<Camera> cameras = new ArrayList<Camera>(); 
		
		places.add(new Place(new PointGPS(1.0, 2.0), 1, 90, PlaceStatus.FREE));
		places.add(new Place(new PointGPS(2.0, 3.0), 2, 90, PlaceStatus.FREE));
		
		chemins.add(new Vecteur(new PointGPS(2.0, 4.0), new PointGPS(4.0, 7.0)));
		chemins.add(new Vecteur(new PointGPS(4.0, 7.0), new PointGPS(9.0, 8.0)));
		
		cameras.add(new Camera(new PointGPS(1.0,1.0), 4, 90, 120));
		etages.add(new Etage(places, chemins, cameras));
		
		
		Parking parking = new Parking(etages, nom, adresse, new PointGPS( 43.600000, 1.433333));
		return gson.toJson(parking);
	}
	
	@GET
	@Path("place")
	@Produces("application/JSON")
	@ApiDoc("Retourne une place")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public String getDemoPlace(){
		return gson.toJson(new Place(new PointGPS(1.0, 2.0), 1, 90, PlaceStatus.FREE));
	}
	
	@GET
	@Path("etage")
	@Produces("application/JSON")
	@ApiDoc("Retourne un étage")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public String getDemoEtage(){
		ArrayList<Place> places = new ArrayList<Place>();
		ArrayList<Vecteur> chemins = new ArrayList<Vecteur>();
		ArrayList<Camera> cameras = new ArrayList<Camera>(); 
		
		places.add(new Place(new PointGPS(1.0, 2.0), 1, 90, PlaceStatus.FREE));
		places.add(new Place(new PointGPS(2.0, 3.0), 2, 90, PlaceStatus.FREE));
		
		chemins.add(new Vecteur(new PointGPS(2.0, 4.0), new PointGPS(4.0, 7.0)));
		chemins.add(new Vecteur(new PointGPS(4.0, 7.0), new PointGPS(9.0, 8.0)));
		
		cameras.add(new Camera(new PointGPS(1.0,1.0), 4, 90, 120));
		return gson.toJson(new Etage(places, chemins, cameras));
	}
	
	@GET
	@Path("vecteur")
	@Produces("application/JSON")
	@ApiDoc("Retourne un vecteur, utilisé pour les chemins")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public String getDemoVecteur(){
		return gson.toJson(new Vecteur(new PointGPS(2.0, 4.0), new PointGPS(4.0, 7.0)));
	}
	
	@GET
	@Path("camera")
	@Produces("application/JSON")
	@ApiDoc("Retourne une caméra")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public String getDemoCamera(){
		return gson.toJson(new Camera(new PointGPS(1.0,1.0), 4, 90, 120));
	}
	
	@GET
	@Path("createCNAM")
	@Produces("application/JSON")
	@ApiDoc("Crée le parking CNAM")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public void createCNAMParking(){
		ArrayList<Etage> etages = new ArrayList<Etage>();
		ArrayList<Place> places = new ArrayList<Place>();
		ArrayList<Camera> cameras = new ArrayList<Camera>();
		ArrayList<Vecteur> chemins = new ArrayList<Vecteur>();
		
		for(int i=1; i<100; i++){
			places.add(new Place(new PointGPS( 43.566566+(i*0.00002), 1.466449+(i*0.00002)), i, 90, PlaceStatus.FREE));
		}
		
		cameras.add(new Camera(new PointGPS(43.566566, 1.466449), 3, 0, 120));
		chemins.add(new Vecteur(new PointGPS(43.566566, 1.466449), new PointGPS( 43.566566+(100*0.00002), 1.466449+(100*0.00002))));
		
		etages.add(new Etage(places, chemins, cameras));
		
		Parking parkingCNAM = new Parking(etages, "Parking CNAM", "Université Paul Sabatier", new PointGPS(43.566791, 1.466735));
		ParkingDAO.getInstance().saveParking(parkingCNAM);
	}
	
}
