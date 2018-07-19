package com.example.site;

import com.github.javafaker.Faker;

import java.sql.*;

public class Exam {
    public static void main(String[] args) {

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/HospitalDB", "postgres",
                    "postgres");

            int categ = 1;
            String spec = "";
            String time = "";
            PreparedStatement st = connection.prepareStatement("INSERT INTO doctor (doc_id, category, first_name, specialties, sure_name, working_time) VALUES (?, ?, ?, ?, ?, ?)");
            Faker faker = new Faker();
            for (int i = 1; i <= 10000; i++) {
                categ++;
                st.setLong(1, 1000 + i);
                if (categ > 5){
                    categ = 1;
                }
                st.setLong(2, categ);
                st.setString(3, faker.name().firstName());
                if (categ == 1){
                    spec = "Gynecologist";
                    time = "9-00 to 18-00";
                } else if (categ == 2){
                    spec = "Cardiologist";
                    time = "10-00 to 19-00";
                } else if (categ == 3){
                    spec = "Otolaryngologist";
                    time = "8-00 to 17-00";
                } else if (categ == 4){
                    spec = "Allergist";
                    time = "12-00 to 17-00";
                } else if (categ == 5){
                    spec = "Pharmacis";
                    time = "7-00 to 15-00";
                }
                st.setString(4, spec);
                st.setString(5, faker.name().lastName());
                st.setString(6, time);
                st.executeUpdate();
            }

            st.close();

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
}
