import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExecuteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        String urlStr = "http://192.168.1.4:8080/ExecutionServer/execute?user=" + username;

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));

        String line;
        StringBuilder result = new StringBuilder();

        while ((line = br.readLine()) != null) {
            result.append(line);
        }

        request.setAttribute("result", result.toString());

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}