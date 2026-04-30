import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.MultipartConfig;

@MultipartConfig
public class CodeUploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        Part filePart = request.getPart("codefile");

        String fileName = filePart.getSubmittedFileName();

        String uploadPath = getServletContext().getRealPath("") 
                            + File.separator + "storage/codes/" + username;

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        File file = new File(uploadDir, fileName);

        try (InputStream input = filePart.getInputStream();
             FileOutputStream output = new FileOutputStream(file)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        }

        response.getWriter().println("Code uploaded successfully!");
    }
}