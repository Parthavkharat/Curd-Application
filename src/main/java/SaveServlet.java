import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        
        // CSS styles
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f0f0f0; }");
        out.println("h2 { color: #007bff; }");
        out.println("</style>");

        String rno=request.getParameter("t1");
        String nm=request.getParameter("t2");
        String ct=request.getParameter("t3");
        
        Student s=new Student();
        s.setRollno(Integer.parseInt(rno));
        s.setName(nm);
        s.setCity(ct);
        int res=StudentDAO.SaveStud(s);
        if(res==1) {
            out.println("<h2>Record is saved</h2>");
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
            rd.include(request, response);
        } else {
            out.println("<h2>Unable to save</h2>");
        }
    }
}
