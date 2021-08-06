package net.sqliteMovie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertApp {
    
    private Connection connect() {
        String url = "jdbc:sqlite:C://sqlite/db/Movie.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String name, String actor, String actress, String director, Integer yor) {
        String sql = "INSERT INTO Movies(name, actor, actress, director, yor) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, actor);
            pstmt.setString(3, actress);
            pstmt.setString(4, director);
            pstmt.setInt(5, yor);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        // insert three new rows
        app.insert("Yeh Jawanni Hai Deewani","Ranbir Kapoor","Deepika Padukone","Ayan Mukerji",2013);
        app.insert("Kissing Booth","Jacob Elordi","Joey King","Vince Marcello",2018);
        app.insert("ABCD 2","Varun Dhawan","Shraddha Kapoor","Remo DSouza",2015);
        app.insert("Chennai Express","ShahRukh Khan","Deepika Padukone","Rohit Shetty",2013);
        app.insert("DDLJ","ShahRukh Khan","Kajol","Aditya Chopra",1995);
        app.insert("Om Shanti Om","ShahRukh Khan","Deepika Padukone","Farah Khan",2007);
        app.insert("Jagga Jasoos","Ranbir Kapoor","Katrina Kaif","Anurag basu",2017);
        app.insert("Ajab Prem Ki Gajab Kahani","Ranbir Kapoor","Katrina Kaif","RajKumar S",2009);
        app.insert("Titanic","Leonardo","Kate Winslet","James F C",1997);
        app.insert("'Twilight","Kristen Stewart","Robert Pattison","Catherine",2008);
    }

}