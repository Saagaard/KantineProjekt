package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface EmployeeDAO {
    // CRUD support med 5 metoder.

    //public void add(Employee p) throws Exception;// Tilføje eller skrive et produkt eller Create i CRUD

    public Employee read(int no) throws Exception; // Læse et enkelt produkt eller Read i CRUD

    //public List<Employee> readAll(); // Læse alle produkter eller Read i CRUD

    //public Employee update(int updatedNo, String updatedName, int updatedPrice); // Opdaterer et produkt eller Update i CRUD

    //public boolean delete(int no); // Sletter et produkt eller Delete i CRUD


}
