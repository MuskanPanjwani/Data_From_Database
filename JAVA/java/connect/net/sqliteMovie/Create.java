package net.sqliteMovie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Create {
    public static void createNewTable() {
        String url = "jdbc:sqlite:C://sqlite/db/Movie.db";
        String sql = "CREATE TABLE IF NOT EXISTS Movies (\n"
                + "	name text PRIMARY KEY ,\n"
                + " actor text,\n"
                + " actress text,\n"
                + " director text,\n"
                + "	yor Integer NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        createNewTable();
    }

}