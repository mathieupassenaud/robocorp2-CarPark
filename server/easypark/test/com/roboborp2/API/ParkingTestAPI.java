package com.roboborp2.API;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.slim3.datastore.Datastore;

import com.robocorp2.API.ParkingAPI;
import com.robocorp2.DAO.ParkingDAO;
import com.robocorp2.model.parking.Camera;
import com.robocorp2.model.parking.Etage;
import com.robocorp2.model.parking.Parking;
import com.robocorp2.model.parking.Place;
import com.robocorp2.model.parking.PointGPS;
import com.robocorp2.model.parking.Vecteur;

public class ParkingTestAPI {

	@Test
	public void testCreate(){
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
		
		
		Parking parking = new Parking(null, etages, nom, adresse);
		
		String parkingKey = new ParkingAPI().createParking(parking);
		
		Parking parkingFromStore = ParkingDAO.getInstance().getParkingByKey(Datastore.stringToKey(parkingKey));
		
		assertEquals(parkingFromStore, parking);
		
		Datastore.delete(Datastore.stringToKey(parkingKey));
	}
	
	@Test
	public void testEdit(){
		
	}
}
