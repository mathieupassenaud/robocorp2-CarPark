package com.robocorp2.API;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.robocorp2.DAO.ParkingDAO;
import com.robocorp2.model.parking.Parking;
import com.robocorp2.model.parking.PointGPS;
import com.simplapi.jersey.doc.annotation.ApiAuthor;
import com.simplapi.jersey.doc.annotation.ApiDoc;
import com.simplapi.jersey.doc.annotation.ApiVersion;

@Path("parking")
@ApiDoc("Gestion du parking lui même : création, récupération du schéma, récupération d'une place...")
@ApiAuthor("Mathieu Passenaud")
@ApiVersion("0.1")
public class ParkingAPI {

	@PUT
	@Path("create")
	@Produces("application/json")
	@Consumes("application/json")
	@ApiDoc("Créé un nouveau parking et lui attribue une clé qui est retournée")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public String createParking(Parking parking){
		Key key = ParkingDAO.getInstance().saveParking(parking);
		return Datastore.keyToString(key);
	}
	
	@POST
	@Path("edit/{key}")
	@Produces("application/json")
	@Consumes("application/json")
	@ApiDoc("Edite le modèle de parking, pour ajouter/enlever des places. Retourne le parking modifié")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public Parking editParking(@PathParam("key") String key, Parking parking){
		Key nativeKey = Datastore.stringToKey(key);
		return ParkingDAO.getInstance().editParking(nativeKey, parking);
	}
	
	@GET
	@Path("get/{key}")
	@Produces("application/json")
	@Consumes("application/json")
	@ApiDoc("Récupère un modèle de parking avec sa clé")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public Parking getParkingByKey(@PathParam("key") String key){
		return ParkingDAO.getInstance().getParkingByKey(Datastore.stringToKey(key));
	}
	
	@GET
	@Path("get/{latitude}/{longitude}")
	@Produces("application/json")
	@Consumes("application/json")
	@ApiDoc("Récupère un modèle de parking avec sa coordonnée GPS")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public Parking getPArkingByGPSPoint(@PathParam("latitude") double latitude, @PathParam("longitude") double longitude){
		return ParkingDAO.getInstance().getParkingByPointGPS(new PointGPS(latitude, longitude));
	}
	
}
