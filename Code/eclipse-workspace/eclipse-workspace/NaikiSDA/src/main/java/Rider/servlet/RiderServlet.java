package Rider.servlet;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LoginManagement.bean.LoginManagement;
import Rider.dao.RiderDao;
import Rider.bean.RiderBean;

@WebServlet("/RiderServlet")
public class RiderServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RiderDao PDao;

    public void init() {
        PDao = new RiderDao();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
        doPost(request, response);
}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    	if (request.getParameter("Logout") != null)
    	{
    		logout(request, response);
    	}
    	else if (request.getParameter("Edit") != null)
    	{
    		try {
    			response.sendRedirect("EditRider.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else if (request.getParameter("ViewProfile") != null)
    	{
    		response.sendRedirect("RiderProfile.jsp");
    	}
	    else
	    {
	    	String username = request.getParameter("username");
	        String passcode = request.getParameter("passcode");
	        String firstname = request.getParameter("FirstName");
	        String lastname = request.getParameter("LastName");
	        String phone = request.getParameter("Phone");
	        
	        RiderBean User = new RiderBean(username, passcode);
	        User.setFName(firstname);
	        User.setLName(lastname);
	        User.setPhone(phone);
	        
	       
	        try {
	            PDao.registerRider(User);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        response.sendRedirect("HomePageAdmin.jsp");
	    }
        
    }
    
    protected void logout(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	LoginManagement.setCurrentAdmin(null);
    	response.sendRedirect("Login.jsp");
    }
}