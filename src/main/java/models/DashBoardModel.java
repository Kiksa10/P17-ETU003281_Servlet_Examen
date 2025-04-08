package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DbConnexion;

public class DashBoardModel {
    String NomCredit;
    int depense;
    int credit;
    int reste;
    Date dates;

    public DashBoardModel(){

    }

    public DashBoardModel(String nom , int credit ,int depense){
        this.NomCredit = nom;
        this.credit = credit;
        this.depense = depense;
        this.reste = this.credit - this.depense;
    }

    public DashBoardModel(String nom , int credit ,int depense, Date d){
        this.NomCredit = nom;
        this.credit = credit;
        this.depense = depense;
        this.dates = d;
        this.reste = this.credit - this.depense;
    }

    public String getNomCredit() {
        return this.NomCredit;
    }

    public int getCredit() {
        return this.credit;
    }

    public int getDepense() {
        return this.depense;
    }

    public int getReste() {
        return this.reste;
    }

    public Date getDate() {
        return this.dates;
    }

    public List<DashBoardModel> getAll() throws SQLException, ClassNotFoundException {
        List<DashBoardModel> dashboards = new ArrayList<>();
         String sql = "SELECT * FROM credit_servlet LEFT JOIN depense_servlet ON credit_servlet.id = depense_servlet.idCredit";

        try (Connection conn = DbConnexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DashBoardModel dashboard = new DashBoardModel(rs.getString("credit_servlet.libeller"),rs.getInt("credit_servlet.montant"),rs.getInt("depense_servlet.montant"),rs.getDate("depense_servlet.dates"));
                dashboards.add(dashboard);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la selection des employers : " + e.getMessage());
            throw e;
        }

        return dashboards;
    }
}
