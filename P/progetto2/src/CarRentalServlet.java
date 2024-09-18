import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CarRentalServlet")
public class CarRentalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ottieni i dati dal form
        String car = request.getParameter("car");
        String startDate = request.getParameter("start_date");
        String endDate = request.getParameter("end_date");
        String totalCostStr = request.getParameter("total_cost");
        double totalCost = Double.parseDouble(totalCostStr.replace("€", ""));

        // Crea un'istanza di CarRental
        CarRental carRental = new CarRental(car, startDate, endDate, totalCost);

        // Inserimento nel database SQL
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/noleggio_auto", "root", "Sara2022");

            String query = "INSERT INTO prenotazioni (auto, data_inizio, data_fine, costo_totale) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, carRental.getCar());
            pstmt.setString(2, carRental.getStartDate());
            pstmt.setString(3, carRental.getEndDate());
            pstmt.setDouble(4, carRental.getTotalCost());

            pstmt.executeUpdate();
            conn.close();

            response.getWriter().println("Prenotazione confermata!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
