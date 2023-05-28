package Donor.bean;

import java.io.Serializable;

public class DonorBean implements Serializable {
    /**
     * 
     */
	private static final long serialVersionUID = 1L;
    private String username;
    private String passcode;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String address;
    
    public DonorBean(String username, String passcode) {
		super();
		this.username = username;
		this.passcode = passcode;
	}
    
	public DonorBean(String name, String pass, String firstN, String lastN, String phone, String address2) {
		// TODO Auto-generated constructor stub
		username = name;
		passcode = pass;
		firstName = firstN;
		lastName = lastN;
		phoneNo = phone;
		address = address2;
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
    
	public String getAddress() {
		return address;
	}
	public void setAddress(String add) {
		address = add;
	}
   
}