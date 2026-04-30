import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetDataServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("user");

        String filePath = getServletContext().getRealPath("") 
                          + File.separator + "storage/data/" + username + "/input.txt";

        File file = new File(filePath);

        if (!file.exists()) {
            response.getWriter().println("No data file found!");
            return;
        }

        response.setContentType("text/plain");

        BufferedReader br = new BufferedReader(new FileReader(file));
        PrintWriter out = response.getWriter();

        String line;
        while ((line = br.readLine()) != null) {
            out.println(line);
        }

        br.close();
    }
}