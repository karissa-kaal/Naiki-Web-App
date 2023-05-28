package Donor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Donor.dao.DonorDao;
import LoginManagement.bean.LoginManagement;
import Donor.bean.DonorBean;

@WebServlet("/DonorEditServlet")
public class DonorEditservlet extends HttpServlet {

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

        String passcode = request.getParameter("passcode");
        String firstname = request.getParameter("FirstName");
        String lastname = request.getParameter("LastName");
        String phone = request.getParameter("Phone");
        String address = request.getParameter("Address");
        
        DonorBean User = new DonorBean(LoginManagement.getCurrentDonor().getUsername(), passcode);
        User.setFName(firstname);
        User.setLName(lastname);
        User.setPhone(phone);
        User.setAddress(address);
        
        try {
            PDao.editDonor(User);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("HomePageDonor.jsp");
    }
}