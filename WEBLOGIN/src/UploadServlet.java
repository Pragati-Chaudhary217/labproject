import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.MultipartConfig;
import java.net.HttpURLConnection;
import java.net.URL;

@MultipartConfig
public class UploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        Part filePart = request.getPart("codefile");
        String targetURL = "http://192.168.1.2:8080/CodeServer/upload";

        if (filePart == null) {
            filePart = request.getPart("datafile");
            targetURL = "http://192.168.1.3:8080/DataServer/upload";
        }

        InputStream input = filePart.getInputStream();

        URL url = new URL(targetURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setDoOutput(true);
        conn.setRequestMethod("POST");

        OutputStream os = conn.getOutputStream();

        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = input.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }

        os.close();

        response.getWriter().println("Upload Successful");
    }
}