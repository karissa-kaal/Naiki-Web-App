package Rider.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Rider.dao.RiderDao;
import Rider.bean.RiderBean;

@WebServlet("/RiderDeleteServlet")
public class RiderDeleteServlet extends HttpServlet {

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

        String username = request.getParameter("username");
        
        
        RiderBean User = new RiderBean(username);
        
        
       
        try {
            PDao.deleteRider(User);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("DeleteRider.jsp");
    }
}