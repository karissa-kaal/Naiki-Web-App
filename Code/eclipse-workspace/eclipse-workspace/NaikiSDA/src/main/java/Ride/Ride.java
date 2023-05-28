package Ride;
import java.io.Serializable;
//import java.sql.Date;
import java.time.LocalDate;

import Donor.bean.DonorBean;
import Rider.bean.RiderBean;


public class Ride implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String pickupLocation;
	private String dropLocation;
	private LocalDate date;
	private RiderBean riderAlloted;
	private DonorBean _donor; 
	private RideStatus status;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Ride() {
		riderAlloted = null;
		_donor = null;
	}
	
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}
	public RiderBean getRiderAlloted() {
		return riderAlloted;
	}
	public void setRiderAlloted(RiderBean riderAlloted) {
		this.riderAlloted = riderAlloted;
	}
	public DonorBean get_donor() {
		return _donor;
	}
	public void set_donor(DonorBean _donor) {
		this._donor = _donor;
	}
	public RideStatus getStatus() {
		return status;
	}
	public void setStatus(RideStatus status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
