import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update1")
public class Update1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        
        // CSS styles
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f0f0f0; }");
        out.println("h2 { color: #007bff; }");
        out.println("</style>");

        int rno=Integer.parseInt(request.getParameter("t1"));
        String nm=request.getParameter("t2");
        String ct=request.getParameter("t3");
        
        Student s=new Student();
        s.setRollno(rno);
        s.setName(nm);
        s.setCity(ct);
        int res=StudentDAO.UpdateStud(s);
        if(res==1) {
            out.println("<h2>Record is Updated</h2>");
            response.sendRedirect("ViewServlet");
        } else {
            out.print("<h2>Unable to update.</h2>");
        }
        out.close();
    }
}
