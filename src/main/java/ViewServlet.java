import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        // CSS styles
        out.println("<style>");
        out.println("table { border-collapse: collapse; width: 100%; }");
        out.println("th, td { border: 1px solid #dddddd; text-align: left; padding: 8px; }");
        out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
        out.println(".add-link { display: block; margin-bottom: 20px; font-weight: bold; color: #007bff; }");
        out.println("</style>");

        out.println("<a class='add-link' href='index.html'>Add New Student</a>");
        out.print("<h2>Student List</h2>");
        List<Student> list=StudentDAO.showStud();

        out.print("<table>");
        out.print("<tr><th>Rollno</th><th>Name</th><th>City</th><th>Delete</th><th>Edit</th></tr>");
        for(Student s:list) {
            out.print("<tr>");
            out.print("<td>"+s.getRollno()+"</td>");
            out.print("<td>"+s.getName()+"</td>");
            out.print("<td>"+s.getCity()+"</td>");
            out.print("<td><a href='DeleteServlet?id="+s.getRollno()+"'>Delete</a></td>");
            out.print("<td><a href='UpdateServlet?id="+s.getRollno()+"&nm="+s.getName()+"&ct="+s.getCity()+"'>Edit</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");
        out.close();
    }
}
