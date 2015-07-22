package com.robocorp2.API;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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

	@GET
	@Path("parking")
	@Produces("application/JSON")
	@ApiDoc("Retourne un modèle de parking")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public Parking getDemoParking(){
		String nom = "Parking de démo";
		String adresse = "Adresse - 31000 Toulouse";
		ArrayList<Etage> etages = new ArrayList<Etage>();
		ArrayList<Place> places = new ArrayList<Place>();
		ArrayList<Vecteur> chemins = new ArrayList<Vecteur>();
		ArrayList<Camera> cameras = new ArrayList<Camera>(); 
		
		places.add(new Place(new PointGPS(1.0, 2.0), 1, 90, true));
		places.add(new Place(new PointGPS(2.0, 3.0), 2, 90, true));
		
		chemins.add(new Vecteur(new PointGPS(2.0, 4.0), new PointGPS(4.0, 7.0)));
		chemins.add(new Vecteur(new PointGPS(4.0, 7.0), new PointGPS(9.0, 8.0)));
		
		cameras.add(new Camera(new PointGPS(1.0,1.0), 4, 90, 120));
		etages.add(new Etage(places, chemins, cameras));
		
		
		Parking parking = new Parking(etages, nom, adresse, new PointGPS( 43.600000, 1.433333));
		return parking;
	}
	
	@GET
	@Path("place")
	@Produces("application/JSON")
	@ApiDoc("Retourne une place")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public Place getDemoPlace(){
		return new Place(new PointGPS(1.0, 2.0), 1, 90, true);
	}
	
	@GET
	@Path("etage")
	@Produces("application/JSON")
	@ApiDoc("Retourne un étage")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public Etage getDemoEtage(){
		ArrayList<Place> places = new ArrayList<Place>();
		ArrayList<Vecteur> chemins = new ArrayList<Vecteur>();
		ArrayList<Camera> cameras = new ArrayList<Camera>(); 
		
		places.add(new Place(new PointGPS(1.0, 2.0), 1, 90, true));
		places.add(new Place(new PointGPS(2.0, 3.0), 2, 90, true));
		
		chemins.add(new Vecteur(new PointGPS(2.0, 4.0), new PointGPS(4.0, 7.0)));
		chemins.add(new Vecteur(new PointGPS(4.0, 7.0), new PointGPS(9.0, 8.0)));
		
		cameras.add(new Camera(new PointGPS(1.0,1.0), 4, 90, 120));
		return new Etage(places, chemins, cameras);
	}
	
	@GET
	@Path("vecteur")
	@Produces("application/JSON")
	@ApiDoc("Retourne un vecteur, utilisé pour les chemins")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public Vecteur getDemoVecteur(){
		return new Vecteur(new PointGPS(2.0, 4.0), new PointGPS(4.0, 7.0));
	}
	
	@GET
	@Path("camera")
	@Produces("application/JSON")
	@ApiDoc("Retourne une caméra")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public Camera getDemoCamera(){
		return new Camera(new PointGPS(1.0,1.0), 4, 90, 120);
	}
	
}
