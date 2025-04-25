package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementation af DAO-pattern fra DAO-interface
 */
public class EmployeeDAOImplementation implements EmployeeDAO {

    /**
     * Returnerer en Employee ud fra et givet medarbejderID
     */
    public Employee read(int id) throws Exception {
        String sql = "EXECUTE read_employeeID @employeeID = ?";

        Connection conn = SqlConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        //try-with-resources lukker automatisk ResultSet
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return new Employee(
                        rs.getInt("fldEmployeeID"),
                        rs.getString("fldFirstName"),
                        rs.getString("fldLastName"),
                        rs.getFloat("fldBalance")
                );
            } else {
                System.out.println("Ingen medarbejder fundet med ID: " + id);
                return null;
            }
        }

    }
}

