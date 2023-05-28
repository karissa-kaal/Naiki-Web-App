package LoginManagement.bean;

import Admin.bean.AdminBean;
import Donor.bean.DonorBean;
import Rider.bean.RiderBean;

public class LoginManagement {
	public static DonorBean currentDonor = null;
	public static RiderBean currentRider = null;
	public static AdminBean currentAdmin = null;
	
	public static DonorBean getCurrentDonor() {
		return currentDonor;
	}
	public static void setCurrentDonor(DonorBean currentDonor) {
		LoginManagement.currentDonor = currentDonor;
	}
	public static RiderBean getCurrentRider() {
		return currentRider;
	}
	public static void setCurrentRider(RiderBean currentRider) {
		LoginManagement.currentRider = currentRider;
	}
	public static AdminBean getCurrentAdmin() {
		return currentAdmin;
	}
	public static void setCurrentAdmin(AdminBean currentAdmin) {
		LoginManagement.currentAdmin = currentAdmin;
	}
	
	
}
