package Admin.bean;
import java.io.Serializable;

public class AdminBean implements Serializable{
	private static final long serialVersionUID = 1L;
    private String username;
    private String passcode;
    private String firstName;
    private String lastName;
    
    public AdminBean(String username, String passcode) {
		super();
		this.username = username;
		this.passcode = passcode;
	}
    
	public AdminBean(String username2) {
		// TODO Auto-generated constructor stub
		username = username2;
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
}
