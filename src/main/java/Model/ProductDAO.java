package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    // CRUD support med 5 metoder.

    //public void add(Product p) throws Exception;// Tilføje eller skrive et produkt eller Create i CRUD

    //public Product read(int no) throws Exception; // Læse et enkelt produkt eller Read i CRUD

    public List<Product> readAll() throws Exception; // Læse alle produkter eller Read i CRUD

    //public Product update(int updatedNo, String updatedName, int updatedPrice); // Opdaterer et produkt eller Update i CRUD

    //public boolean delete(int no); // Sletter et produkt eller Delete i CRUD


}
