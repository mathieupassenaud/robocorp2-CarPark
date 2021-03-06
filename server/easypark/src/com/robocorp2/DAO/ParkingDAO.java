package com.robocorp2.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.robocorp2.meta.parking.ParkingMeta;
import com.robocorp2.model.parking.Parking;
import com.robocorp2.model.parking.PointGPS;
import com.robocorp2.model.parking.stats.ParkingForStats;

/**
 * Singleton access to Parking storage
 * @author Mathieu
 *
 */
public class ParkingDAO {

	private static ParkingDAO _instance =  new ParkingDAO();
	
	private ParkingDAO(){
		
	}
	
	/**
	 * Singleton implementation
	 * @return
	 */
	public static ParkingDAO getInstance(){
		return _instance;
	}
	
	/**
	 * Return a parking with his key
	 * @param key
	 * @return
	 */
	public Parking getParkingByKey(Key key){
		return Datastore.get(ParkingMeta.get(), key);
	}
	
	/**
	 * Search a parking with his name. Returns a list of parkings
	 * @param name
	 * @return
	 */
	public List<Parking> getParkingByName(String name){
		List<Parking> parkings = Datastore.query(ParkingMeta.get()).filter(ParkingMeta.get().nom.equal(name)).asList();
		return parkings;
	}
	
	/**
	 * Search a parking with his GPS point. Return a single parking or null.
	 * 
	 * @param gps
	 * @return
	 */
	public Parking getParkingByPointGPS(PointGPS gps){
		List<Parking> parkings = Datastore.query(ParkingMeta.get()).filter(ParkingMeta.get().pointGPSLat.equal(gps.getX()))
				.filter(ParkingMeta.get().pointGPSLon.equal(gps.getY())).asList();
		if(parkings.size() == 0){
			return null;
		}else{
			return parkings.get(0);
		}
	}
	
	/**
	 * Search a parking around a GPS point. Return a single parking.
	 * 
	 * @param gps
	 * @return
	 */
	public List<Parking> searchParkingsByPointGPS(PointGPS gps){
		List<Parking> parkings = Datastore.query(ParkingMeta.get()).sort(ParkingMeta.get().pointGPSLat.asc).sort(ParkingMeta.get().pointGPSLon.asc).asList();
		
		List<Parking> nearestParkings = new ArrayList<Parking>();
		int parkingsToFind = 5;
		if(parkings.size() < parkingsToFind){
			parkingsToFind = parkings.size();
		}
		for(int i = 0 ; i < parkingsToFind ; i ++){
			
		Parking nearestParking = new Parking(null, "test", "test", new PointGPS(Double.MAX_VALUE, Double.MAX_VALUE));
		for(Parking parking : parkings){
			if( Math.abs(parking.getPointGPSLat()-gps.getX()) < Math.abs(nearestParking.getPointGPSLat()-gps.getX()) &&
					Math.abs(parking.getPointGPSLon()-gps.getY()) < Math.abs(nearestParking.getPointGPSLon()-gps.getY())){
				nearestParking = parking;
				nearestParkings.add(parking);
				//parkings.remove(parking);
			}
		}
		}
		
		return nearestParkings;
	}
	
	/**
	 * Put a parking to datastore. Generate key before
	 * @param parking
	 * @return key
	 */
	public Key saveParking(Parking parking){
		Datastore.put(parking);
		return parking.getKey();
	}
	
	/**
	 * Save a modified parking
	 * @param key, parking
	 * @return parking
	 */
	public Parking editParking(Key key, Parking parking){
		parking.setKey(key);
		Datastore.delete(key);
		Datastore.put(parking);
		return parking;
	}
	
	/**
	 * Save a parking and keep a history of the previous state
	 * @param key
	 * @param parking
	 * @return
	 */
	public Parking updateParkingWithStats(Key key, Parking parking){
		parking.setKey(key);
		Datastore.delete(key);
		Datastore.put(parking);
		ParkingForStats parkingForStats = new ParkingForStats(parking, new Date(System.currentTimeMillis()));
		Datastore.put(parkingForStats);
		return parking;
	}
}
