package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DbConnexion;

public class CreditModel {
    int id;
    String libeller;
    String montant;

    public CreditModel() {

    }
    public CreditModel(String lib , String montant) {
        this.libeller = lib;
        this.montant = montant;
    }

    public CreditModel(int id ,String lib , String montant) {
        this.id = id;
        this.libeller = lib;
        this.montant = montant;
    }

    public int getId() {
        return this.id;
    }

    public String getLibller() {
        return this.libeller;
    }

    public String getMontant() {
        return this.montant;
    }
    
    
    public void save() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO credit_servlet (libeller,montant) VALUES (?,?)";

        try (Connection conn = DbConnexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.getLibller());
            stmt.setString(2, this.getMontant());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion d'employer : " + e.getMessage());
            throw e;
        }
    }

    public List<CreditModel> getAll() throws SQLException, ClassNotFoundException {
        List<CreditModel> credits = new ArrayList<>();
         String sql = "SELECT * FROM credit_servlet";

        try (Connection conn = DbConnexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CreditModel cred = new CreditModel(rs.getInt("id"),rs.getString("libeller"),rs.getString("montant"));
                credits.add(cred);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la selection des employers : " + e.getMessage());
            throw e;
        }

        return credits;
    }
}
