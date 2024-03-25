package jdbc.repositories;

import jdbc.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    public List<Category> read(){
        List<Category> results = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with category table");
            Statement statement = connection.createStatement();
            String query="select id, category from categories";
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
            System.out.println("Connection is made with category table");
            Statement statement = connection.createStatement();
            String query="update categories set category='maes' where id=1";
            statement.execute(query);
            System.out.println("category table updated");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    public void delete(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with category table");
            Statement statement = connection.createStatement();
            String query="delete from categories where id=1";
            statement.execute(query);
            System.out.println("content deleted from category table");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
