package com.robocorp2.API;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.robocorp2.model.parking.Vecteur;
import com.simplapi.jersey.doc.annotation.ApiAuthor;
import com.simplapi.jersey.doc.annotation.ApiDoc;
import com.simplapi.jersey.doc.annotation.ApiUnimplemented;
import com.simplapi.jersey.doc.annotation.ApiVersion;

@Path("chemin")
@ApiDoc("Calcul et retour des chemins pour accéder à une place")
@ApiAuthor("Mathieu Passenaud")
@ApiVersion("0.1")
public class CheminAPI {

	@GET
	@Path("getRoute/{idPlace}")
	@ApiDoc("Donne le chemin jusqu'à une place")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	@ApiUnimplemented(value = "not implemented")
	public Vecteur[] getCheminToPlace(@PathParam("idPlace") int place){
		
		return null;
	}
}
