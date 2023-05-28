package LoginManagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import Admin.dao.AdminDao;
import LoginManagement.bean.LoginManagement;
import Admin.bean.AdminBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    } */
    
    //private DonorDao DDao;
    private AdminDao ADao;
   // private RiderDao RDao;

    public void init() {
        //DDao = new DonorDao();
        ADao = new AdminDao();
        //RDao = new RiderDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 //String action = request.getServletPath();

		try {
				adminLogin(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void adminLogin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("passcode");
		AdminBean newAdmin = new AdminBean(username, password);
		try {
			if (ADao.validateUser(newAdmin) == true)
			{
				LoginManagement.setCurrentAdmin(newAdmin);
				response.sendRedirect("HomePageAdmin.jsp");
			}
			else
			{
				response.sendRedirect("Login.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
