package com.robocorp2.model.parking.stats;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

import com.robocorp2.model.parking.Parking;

@Model
@XmlRootElement
public class ParkingForStats extends Parking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;

	public ParkingForStats() {
		super();
	}

	public ParkingForStats(Parking parking, Date date) {
		super(parking.getKey(), parking.getEtages(), parking.getNom(), parking.getAdresse());
		super.setKey(Datastore.createKey(this.getClass(), parking.getNom()+date.toString()));
		
		this.date = date;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
