package Admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Admin.dao.AdminDao;
import Admin.bean.AdminBean;

@WebServlet("/AdminDeleteServlet")
public class AdminDeleteServlet extends HttpServlet {

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

        String username = request.getParameter("username");
        
        
       AdminBean User = new AdminBean(username);
        
        
       
        try {
            PDao.deleteAdmin(User);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("DeleteAdmin.jsp");
    }
}