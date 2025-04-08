package models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DbConnexion;

public class LoginModel {
    String email;
    String pwd;

    public LoginModel(String mail , String pwd) {
        this.email = mail;
        this.pwd = pwd;

    }

    public String getMail() {
        return this.email;
    }

   public boolean verifie() throws SQLException , ClassNotFoundException{
    String sql = "SELECT pwd FROM users_servlet WHERE email = ?";

    try (Connection conn = DbConnexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, this.getMail());
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String pass = rs.getString("pwd");
                if(pass != null && pass.equals(this.pwd)) {
                    return true;
                }
            }
        }
        return false;
    } catch (SQLException e) {
        System.err.println("Erreur lors de la vérification de l'utilisateur : " + e.getMessage());
        throw e;
    }
}
}
