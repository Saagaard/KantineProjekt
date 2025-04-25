package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation af DAO-pattern fra DAO-interface
 */
public class ProductDAOImplementation implements ProductDAO {

    private List<Product> products;

    public ProductDAOImplementation() {
        this.products = new ArrayList<>();
    }

    /**
     * @return Liste af alle Products
     */
    public List<Product> readAll() throws Exception {
        String sql = "EXECUTE read_all_products";

        Connection conn = SqlConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //try-with-resources lukker automatisk ResultSet
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("fldProductId");
                String name = rs.getString("fldProductName");
                float price = rs.getFloat("fldProductPrice");
                int storageBalance = rs.getInt("fldStorageBalance");
                int minimum = rs.getInt("fldMinimum");
                boolean ordered = rs.getBoolean("fldProductOrdered");

                this.products.add(new Product(id, name, price, storageBalance, minimum, ordered));
            }

            if (this.products.isEmpty()) {
                System.out.println("Der blev ikke fundet nogle produkter");
            }

            return this.products;
        }
    }

}