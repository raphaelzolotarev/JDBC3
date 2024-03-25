package jdbc.repositories;

import jdbc.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrewerRepository {
    public List<Category> read(){
        List<Category> results = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with brewers table");
            Statement statement = connection.createStatement();
            String query="select id from brewers";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("id "+ resultSet.getInt("id"));
            }

        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return results;
    }

    public void update(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with brewers table");
            Statement statement = connection.createStatement();
            String query="update brewers set name='irish pub' where id=1";
            statement.execute(query);
            System.out.println("brewers table updated");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    public void delete(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with brewers table");
            Statement statement = connection.createStatement();
            String query="delete from brewers where id=1";
            statement.execute(query);
            System.out.println("content deleted from brewers table");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
