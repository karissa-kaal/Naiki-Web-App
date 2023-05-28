package Rider.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LoginManagement.bean.LoginManagement;
import Rider.dao.RiderDao;
import Rider.bean.RiderBean;

@WebServlet("/RiderEditServlet")
public class RiderEditServlet extends HttpServlet {

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

        String passcode = request.getParameter("passcode");
        String firstname = request.getParameter("FirstName");
        String lastname = request.getParameter("LastName");
        String phone = request.getParameter("Phone");
        
        RiderBean User = new RiderBean(LoginManagement.getCurrentRider().getUsername(), passcode);
        User.setFName(firstname);
        User.setLName(lastname);
        User.setPhone(phone);
        
       
        try {
            PDao.editRider(User);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("HomePageRider.jsp");
    }
}