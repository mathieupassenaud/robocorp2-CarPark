package com.robocorp2.API;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.robocorp2.DAO.ParkingDAO;
import com.robocorp2.core.KeyAdapterSerializer;
import com.robocorp2.core.PlaceStatus;
import com.robocorp2.model.parking.Etage;
import com.robocorp2.model.parking.Parking;
import com.robocorp2.model.parking.Place;
import com.simplapi.jersey.doc.annotation.ApiAuthor;
import com.simplapi.jersey.doc.annotation.ApiDoc;
import com.simplapi.jersey.doc.annotation.ApiVersion;

@Path("places")
@ApiDoc("La gestion des places dans le parking")
@ApiAuthor("Mathieu Passenaud")
@ApiVersion("0.1")
public class PlacesAPI {

	public static Gson gson = (new GsonBuilder()).serializeNulls()
			.setPrettyPrinting().registerTypeAdapter(Key.class, new KeyAdapterSerializer()).create();
	
	@POST
	@Path("update/{idParking}/{idEtage}")
	@Consumes("Application/JSON")
	@Produces("Application/JSON")
	@ApiDoc("Modifie l'état de la place, et archive l'état pour les statistiques")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public void updatePlace(@PathParam("idParking") String keyParking, @PathParam("idEtage") String keyEtage, Place placeToModify){
		Parking parking = ParkingDAO.getInstance().getParkingByKey(Datastore.stringToKey(keyParking));
		for(Etage etage : parking.getEtages()){
			if(etage.getKey().compareTo(Datastore.stringToKey(keyEtage))==0){
				for(Place place : etage.getPlaces()){
					if(place.getNumeroDePlace() == (placeToModify.getNumeroDePlace())){
						
						place.setStatus(placeToModify.getStatus());
						
						// first remove the old object
						//List<Place> places = etage.getPlaces();
						//places.remove(place);
						//etage.setPlaces(places);
						// put the new in place
						//etage.getPlaces().add(placeToModify);
						
						//do the same
						//List<Etage> etages = parking.getEtages();
						//etages.remove(etage);
						//parking.setEtages(etages);
						
						//save the object to database, with stats
						ParkingDAO.getInstance().updateParkingWithStats(parking.getKey(), parking);
						return;
					}
				}
			}
		}
		
	}
	
	
	@GET
	@Path("getFreePlace/{idParking}")
	@Consumes("Application/JSON")
	@Produces("Application/JSON")
	@ApiDoc("Récupère une place libre dans un parking")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public String getAFreePlace(@PathParam("idParking") String keyParking){
		Parking parking = ParkingDAO.getInstance().getParkingByKey(Datastore.stringToKey(keyParking));
		for(Etage etage : parking.getEtages()){
			for(Place place : etage.getPlaces()){
				if(place.isFree()){
					place.setStatus(PlaceStatus.RESERVED);
					ParkingDAO.getInstance().updateParkingWithStats(parking.getKey(), parking);
					return gson.toJson(place);
				}
			}
		}
		return null;
	}
	
	@GET
	@Path("getFreePlace/{idParking}/{idEtage}/{idPlace}")
	@Consumes("Application/JSON")
	@Produces("Application/JSON")
	@ApiDoc("Donne l'état d'une place")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public String getPlaceStatus(@PathParam("idParking") String keyParking, @PathParam("idEtage") String keyEtage, @PathParam("idPlace") String keyPlace){
		Parking parking = ParkingDAO.getInstance().getParkingByKey(Datastore.stringToKey(keyParking));
		for(Etage etage : parking.getEtages()){
			if(etage.getKey().compareTo(Datastore.stringToKey(keyEtage))==0){
				for(Place place : etage.getPlaces()){
					if(place.getKey().compareTo(Datastore.stringToKey(keyPlace))==0){
						return gson.toJson(place.getStatus());
					}
				}
			}
		}
		return null;
	}
	
}
