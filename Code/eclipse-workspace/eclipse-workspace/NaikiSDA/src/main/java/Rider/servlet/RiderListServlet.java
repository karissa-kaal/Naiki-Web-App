package Rider.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Rider.dao.RiderDao;
import Rider.bean.RiderBean;

@WebServlet("/")
public class RiderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RiderDao riderDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RiderListServlet() {
       this.riderDAO = new RiderDao();
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listRider(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void listRider(HttpServletRequest request , HttpServletResponse response)
	throws SQLException , IOException, ServletException 
	{
		List<RiderBean> listRider = riderDAO.selectAllUsers();
		request.setAttribute("listRider", listRider);
		RequestDispatcher dispatcher = request.getRequestDispatcher("rider-list.jsp") ;
		dispatcher.forward(request, response);
	}
	
	

	

}
