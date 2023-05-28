package Donor.servlet;

import java.io.IOException;
//import java.text.DateFormat;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Donor.dao.DonorDao;
import LoginManagement.bean.LoginManagement;
import Ride.Ride;
import Ride.RideStatus;
import Ride.dao.RideDao;
import Rider.dao.RiderDao;
import Donor.bean.DonorBean;

@WebServlet("/DonorServlet")
public class DonorServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DonorDao PDao;

    public void init() {
        PDao = new DonorDao();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
        doPost(request, response);
}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	if (request.getParameter("Logout") != null)
    	{
    		try {
				logout(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else if (request.getParameter("RequestRide") != null)
    	{
    		try {
				requestRide(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else if (request.getParameter("Edit") != null)
    	{
    		try {
    			response.sendRedirect("EditDonor.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else if (request.getParameter("ViewProfile") != null)
    	{
    		response.sendRedirect("DonorProfile.jsp");
    	}
    	else if (request.getParameter("DonateMoney") != null)
    	{
    		try {
    			response.sendRedirect("DonateMoney.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else {
	        String username = request.getParameter("username");
	        String passcode = request.getParameter("passcode");
	        String firstname = request.getParameter("FirstName");
	        String lastname = request.getParameter("LastName");
	        String phone = request.getParameter("Phone");
	        String address = request.getParameter("Address");
	        
	        DonorBean User = new DonorBean(username, passcode);
	        User.setFName(firstname);
	        User.setLName(lastname);
	        User.setPhone(phone);
	        User.setAddress(address);
	        
	       
	        try {
	            PDao.registerDonor(User);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	
	        response.sendRedirect("SignUp.jsp");
    	}
    }
    
    protected void logout(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	LoginManagement.setCurrentDonor(null);
    	response.sendRedirect("Login.jsp");
    }
    
    protected void requestRide(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	
    	RideDao RDao = new RideDao();
    	Ride ride = new Ride();
    	LocalDateTime dtm = LocalDateTime.now();  
    	
    	DonorBean currdonor = LoginManagement.getCurrentDonor();
    	ride.setStatus(RideStatus.pending);
    	ride.setRiderAlloted(null);
    	ride.setPickupLocation(currdonor.getAddress());
    	ride.set_donor(currdonor);
    	ride.setDate(dtm.toLocalDate());

    	RiderDao riderdao = new RiderDao();
    	try {
			ride.setRiderAlloted(riderdao.findRider(ride));
			//riderdao.findRider(ride);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	try {
            RDao.generateRide(ride);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	
    	response.sendRedirect("DonorRideList.jsp");
    }
}