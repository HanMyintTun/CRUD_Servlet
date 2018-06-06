

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemDao;
import model.Member;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update member</h1>");
		String mid = request.getParameter("memberID");
		int id = Integer.parseInt(mid);
		
		Member m = MemDao.getMemberById(id);
		
		out.print("<form action='UpdateServlet2' method='post'");
		out.print("<table>");
		out.print("<tr><td><input type='hidden' name='memberID' value='\"+m.getMemberID()+\"'/></td></tr>");
		out.print("<tr><td><input type='text' name='name' value='\"+m.getName()+\"'/></td></tr>");
		out.print("<tr><td><input type='text' name='phone' value='\"+m.getPhone()+\"'/></td></tr>");
		out.print("<tr><input type='text' name='email' value='"+m.getEmail()+"'/></td><td></td></tr>");
		out.print("<tr><input type='text' name='password' value='"+m.getPassword()+"'/></td><td></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td>");
		out.print("</table>");
		
	}

	

}
