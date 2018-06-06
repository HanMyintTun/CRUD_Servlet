

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemDao;
import model.Member;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out  = response.getWriter();
		out.println("<a href='member.html'>Add New member</a>");
		out.println("<h1>Member List</h1>");
		
		List<Member> list = MemDao.getAllMember();
		
		out.print("<table border='1' width='100%'>");
		out.print("<tr>"
				+ "<th>ID</th>"
				+ "<th>Name</th>"
				+ "<th>Phone</th>"
				+ "<th>Email</th>"
				+ "<th>Edit</th>"
				+ "<th>Delete</th>"
				+ "</tr>");
		
		for(Member m: list) {
			out.print(
					"<tr>"
							+ "<td>"+m.getMemberID()+"</td>"
							+ "<td>"+m.getName()+"</td>"
							+ "<td>"+m.getPhone()+"</td>"
							+ "<td>"+m.getEmail()+"</td>"
							+ "<td>"+"<a href='UpdateServlet?memberID="+m.getMemberID()+"'>Edit</a>"+"</td>"
							+ "<td>"+"<a href='DeleteServlet?memberID="+m.getMemberID()+"'>Delete</a>"+"</td>"
							+ "</tr>"
					
					);
		}
		
	}

	

}
