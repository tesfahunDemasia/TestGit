package org.example;
import java.sql.*;

import static org.postgresql.core.ConnectionFactory.openConnection;

public class connection {
    public  Connection getConnection(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/MyDB";
        String userName = "postgres";
        String password = "t89123467";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.printf("There is connection\n");
            return connection;

        } catch (SQLException e) {
            System.out.printf("Error!!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    public void select(){
        try {
            Connection connection =getConnection();
            System.out.println("good connection");
            Statement statement=connection.createStatement();
            String query= "SELECT* FROM con ";
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                String name= resultSet.getString("qwerty");
                int id= resultSet.getInt("id");
                System.out.println("ID:  "+id+"name: "+name+"\n");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error");
            throw new RuntimeException(e);
        }

    }
    public void insert(String NAME){
        try {
            Connection connection =getConnection();
            System.out.println("good connection");
            Statement statement= null;
            String query= "INSERT INTO con(qwerty) VALUES('"+NAME+"')";
            statement = connection.createStatement();
            int resultSet= statement.executeUpdate(query);
            System.out.println("insert success!!");
            connection.close();
        } catch (SQLException e) {
            System.out.printf("Error!!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    public void Update(String name,int id){
        try {
            String query=String.format("UPDATE \"con\""+
                    "SET qwerty=' %s'"+"WHERE id= '%s'",name,Integer.toString(id));
            Connection connection =getConnection();
            Statement statement= connection.createStatement();
            int resultSet=statement.executeUpdate(query);
            connection.close();
        } catch (SQLException e) {
            System.out.printf("Error!!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}