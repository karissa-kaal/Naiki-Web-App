package DisplayDonorsList.web;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DisplayDonorsList.dao.DonorsListDao;
import Donor.bean.DonorBean;

@WebServlet("/DonorsListServlet")
public class DonorsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DonorsListDao donorDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorsListServlet() {
       this.donorDAO = new DonorsListDao();
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listDonor(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void listDonor(HttpServletRequest request , HttpServletResponse response)
	throws SQLException , IOException, ServletException 
	{
		List<DonorBean> listDonor = donorDAO.selectAllDonors();
		request.setAttribute("listDonor", listDonor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("donor-list.jsp") ;
		dispatcher.forward(request, response);
	}

}
