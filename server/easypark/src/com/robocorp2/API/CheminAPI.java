package com.robocorp2.API;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.robocorp2.DAO.ParkingDAO;
import com.robocorp2.core.Dijkstra;
import com.robocorp2.core.Edge;
import com.robocorp2.core.Graphe;
import com.robocorp2.core.Vertex;
import com.robocorp2.model.parking.Etage;
import com.robocorp2.model.parking.Parking;
import com.robocorp2.model.parking.Place;
import com.robocorp2.model.parking.PointGPS;
import com.robocorp2.model.parking.Vecteur;
import com.simplapi.jersey.doc.annotation.ApiAuthor;
import com.simplapi.jersey.doc.annotation.ApiDoc;
import com.simplapi.jersey.doc.annotation.ApiUnimplemented;
import com.simplapi.jersey.doc.annotation.ApiVersion;

@Path("chemin")
@ApiDoc("Calcul et retour des chemins pour acc�der � une place")
@ApiAuthor("Mathieu Passenaud")
@ApiVersion("0.1")
public class CheminAPI {

	@GET
	@Path("getRoute/{idParking}/{idPlace}")
	@ApiDoc("Donne le chemin jusqu'� une place")
	@ApiAuthor("Mathieu Passenaud")
	@ApiVersion("0.1")
	@ApiUnimplemented(value = "not implemented")
	public PointGPS[] getCheminToPlace(@PathParam("idParking") String parkingKey, @PathParam("idPlace") int idPlace){
		Key nativeKey = Datastore.stringToKey(parkingKey);
		Parking parking = ParkingDAO.getInstance().getParkingByKey(nativeKey);

		Place placeToGo = null;
		Etage etageToGo = null;
		for(Etage etage : parking.getEtages()){
			for(Place place : etage.getPlaces()){
				if(place.getNumeroDePlace() == idPlace){
					placeToGo = place;
					etageToGo = etage;
				}
			}
		}

		ArrayList<Vecteur> chemin = new ArrayList<Vecteur>();
		PointGPS pointToGo = placeToGo.getPoint();

		// calcul d'un chemin

		// 1 on calcule le graphe de l'�tage


		List<Vertex> nodes = new ArrayList<Vertex>();
		List<Edge> edges = new ArrayList<Edge>();


		for(Vecteur vecteur : etageToGo.getChemins()){
			PointGPS debut = vecteur.getPointDebut();
			PointGPS fin = vecteur.getPointFin();

			boolean addDebut = true;
			boolean addFin = true;
			for(Vertex node : nodes){
				if(node.getPointGPS().equals(debut)){
					addDebut = false;
				}
				if(node.getPointGPS().equals(fin)){
					addFin = false;
				}
			}
			if(addDebut){
				nodes.add(new Vertex(Datastore.keyToString(vecteur.getKey()), debut));
			}
			if(addFin){
				nodes.add(new Vertex(Datastore.keyToString(vecteur.getKey()), fin));
			}
		}

		for(Vecteur vecteur : etageToGo.getChemins()){
			double norme = vecteur.getNorme();

			Vertex source = null;
			Vertex destination = null;
			for(Vertex node : nodes){
				if(node.getPointGPS().equals(vecteur.getPointDebut())){
					source = node;
				}
				if(node.getPointGPS().equals(vecteur.getPointFin())){
					destination = node;
				}
			}

			edges.add(new Edge(Datastore.keyToString(vecteur.getKey()), source, destination, norme));

		}

		Graphe graph = new Graphe(nodes, edges);
		Dijkstra dijkstra = new Dijkstra(graph);

		// find the nodes

		PointGPS debut = new PointGPS(parking.getPointGPSLat(), parking.getPointGPSLon());
		PointGPS destination = placeToGo.getPoint();

		Vertex vertexDebut = null;
		Vertex vertexFin = null;
		for(Vertex node : nodes){
			if(node.getPointGPS().equals(debut)){
				vertexDebut = node;
			}
			if(node.getPointGPS().equals(destination)){
				vertexFin = node;
			}
		}

		dijkstra.execute(vertexDebut);
		LinkedList<Vertex> path = dijkstra.getPath(vertexFin);

		PointGPS[] itineraire = new PointGPS[path.size()];
		int i = 0;
		for(Vertex vertex : path){
			itineraire[i] = vertex.getPointGPS();
			i++;
		}

		return itineraire; 

	}
}
