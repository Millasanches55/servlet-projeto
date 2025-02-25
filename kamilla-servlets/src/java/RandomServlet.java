import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/random.html"})
public class RandomServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Gerar 6 números aleatórios entre 1 e 60
        Set<Integer> randomNumbers = new HashSet<>();
        Random rand = new Random();
        
        while (randomNumbers.size() < 6) {
            randomNumbers.add(rand.nextInt(60) + 1);
        }

        // Converter para array e ordenar
        Integer[] numbersArray = randomNumbers.toArray(new Integer[0]);
        java.util.Arrays.sort(numbersArray);

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Random Numbers</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>6 Números Aleatórios entre 1 e 60:</h1>");
            out.println("<table border='1'>");
            out.println("<tr><th>Posição</th><th>Número</th></tr>");
            
            for (int i = 0; i < numbersArray.length; i++) {
                out.println("<tr><td>" + (i + 1) + "</td><td>" + numbersArray[i] + "</td></tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Random Number Generator Servlet";
    }
}
