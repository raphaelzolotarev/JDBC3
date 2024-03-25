package jdbc.repositories;

import jdbc.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeerRepository {
    public List<Category> read(){
        List<Category> results = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with beers table");
            Statement statement = connection.createStatement();
            String query="select name from beers";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("name "+ resultSet.getString("name"));
            }

        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return results;
    }

    public void update(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with beers table");
            Statement statement = connection.createStatement();
            String query="update beers set name='maes' where id=1";
            statement.execute(query);
            System.out.println("beers table updated");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    public void delete(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with beers table");
            Statement statement = connection.createStatement();
            String query="delete from beers where id=1";
            statement.execute(query);
            System.out.println("content deleted from beers table");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
