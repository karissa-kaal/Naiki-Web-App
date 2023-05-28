package Admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Admin.dao.AdminDao;
import LoginManagement.bean.LoginManagement;
import Admin.bean.AdminBean;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdminDao PDao;

    public void init() {
        PDao = new AdminDao();
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
    	else if (request.getParameter("AddRider") != null)
    	{
    		response.sendRedirect("AddRider.jsp");
    	}
    	else if (request.getParameter("ListofDonors") != null)
    	{
    		response.sendRedirect("DonorsListServlet");
    	}
    	else if (request.getParameter("ListofRiders") != null)
    	{
    		response.sendRedirect("rider-list.jsp");
    	}
    	else
    	{
    		 String username = request.getParameter("username");
    	        String passcode = request.getParameter("passcode");
    	        String firstname = request.getParameter("FirstName");
    	        String lastname = request.getParameter("LastName");
    	        
    	        AdminBean User = new AdminBean(username, passcode);
    	        User.setFName(firstname);
    	        User.setLName(lastname);
    	       
    	        try {
    	            PDao.registerAdmin(User);
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