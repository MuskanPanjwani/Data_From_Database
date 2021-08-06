package net.sqliteMovie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectApp_WithParameter {
	
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/Movie.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void ReleaseBefore(int yor){
               String sql = "SELECT name,yor "
                          + "FROM Movies WHERE yor < ?";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // set the value
            pstmt.setInt(1,yor);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(
                                   rs.getString("name") + "\t" +
                                   rs.getInt("yor"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SelectApp_WithParameter app = new SelectApp_WithParameter();
        app.ReleaseBefore(2000);
    }
}