package com.robocorp2.API;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.robocorp2.DAO.ParkingDAO;
import com.robocorp2.core.KeyAdapterSerializer;
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
	public static Gson gson = (new GsonBuilder()).serializeNulls()
			.setPrettyPrinting().registerTypeAdapter(Key.class, new KeyAdapterSerializer()).create();
	@PUT
	@Path("create")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@ApiDoc("Créé un nouveau parking et lui attribue une clé qui est retournée")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public String createParking(Parking parking){
		Key key = ParkingDAO.getInstance().saveParking(parking);
		return Datastore.keyToString(key);
	}
	
	@POST
	@Path("edit/{key}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@ApiDoc("Edite le modèle de parking, pour ajouter/enlever des places. Retourne le parking modifié")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public String editParking(@PathParam("key") String key, Parking parking){
		Key nativeKey = Datastore.stringToKey(key);
		return gson.toJson(ParkingDAO.getInstance().editParking(nativeKey, parking));
	}
	
	@GET
	@Path("get/{key}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@ApiDoc("Récupère un modèle de parking avec sa clé")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public String getParkingByKey(@PathParam("key") String key){
		Parking parking = ParkingDAO.getInstance().getParkingByKey(Datastore.stringToKey(key));
		return gson.toJson(parking);
	}
	
	@GET
	@Path("get/{latitude}/{longitude}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@ApiDoc("Récupère un modèle de parking avec sa coordonnée GPS")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public String getParkingByGPSPoint(@PathParam("latitude") double latitude, @PathParam("longitude") double longitude){
		return gson.toJson(ParkingDAO.getInstance().getParkingByPointGPS(new PointGPS(latitude, longitude)));
	}
	
	@GET
	@Path("search/{latitude}/{longitude}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@ApiDoc("Recherche une liste de parkings les plus proches (max 5) avec une coordonnée GPS")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	public String searchParkingByGPSPoint(@PathParam("latitude") double latitude, @PathParam("longitude") double longitude){
		return gson.toJson(ParkingDAO.getInstance().searchParkingsByPointGPS(new PointGPS(latitude, longitude)));
	}
}
