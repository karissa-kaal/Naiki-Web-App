package Rider.bean;

import java.io.Serializable;

import Ride.Ride;

public class RiderBean implements Serializable {
    /**
     * 
     */
	private static final long serialVersionUID = 1L;
    private String username;
    private String passcode;
    private String firstName;
    private String lastName;
    private String phoneNo;
	private Ride currentride;
    
    public Ride getCurrentride() {
		return currentride;
	}
    
    public RiderBean(String username, String passcode, String firstName, String lastName, String phoneNo) {
		super();
		this.username = username;
		this.passcode = passcode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
	}

	public void setCurrentride(Ride currentride) {
		this.currentride = currentride;
	}
    
    public RiderBean(String username, String passcode) {
		super();
		this.username = username;
		this.passcode = passcode;
		currentride = null;
	}
    
	public RiderBean(String username) {
		// TODO Auto-generated constructor stub
		this.username = username;
		currentride = null;
	}

	public String getFName() {
		return firstName;
	}
	public void setFName(String FName) {
		firstName = FName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String password) {
		this.passcode = password;
	}
	public String getLName() {
		return lastName;
	}
	public void setLName(String lname) {
		lastName = lname;
	}
	public String getphone() {
		return phoneNo;
	}
	public void setPhone(String pno) {
		phoneNo = pno;
	}
    
    
   
}