package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.DbConnexion;

public class DepenseModel {
    int id;
    String idCredit;
    String montant;
    String dates;

    public DepenseModel(String idCredit, String montant ,String d) {
        this.idCredit = idCredit;
        this.montant = montant;
        this.dates = d;
    }

    public DepenseModel(String idCredit, String montant) {
        this.idCredit = idCredit;
        this.montant = montant;
    }

    public String getIdCredit(){
        return this.idCredit;
    }

    public String getMontant(){
        return this.montant;
    }

    public String getDate(){
        return this.dates;
    }

     public void save() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO depense_servlet (idCredit,montant,dates) VALUES (?,?,?)";

        try (Connection conn = DbConnexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.getIdCredit());
            stmt.setString(2, this.getMontant());
            stmt.setString(3, this.getDate());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de depense : " + e.getMessage());
            throw e;
        }
    }
}
