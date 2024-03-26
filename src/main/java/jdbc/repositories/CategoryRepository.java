package jdbc.repositories;

import jdbc.models.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    public void create(String category){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with category table");
            Statement statement = connection.createStatement();
            String query="insert into categories(category) value ('"+category+"')";
            statement.execute(query);
            System.out.println("new row added to category table");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public List<Category> read(){
        List<Category> results = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with category table");
            Statement statement = connection.createStatement();
            String query="select * from categories order by id";
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("ID\t|\tCategory");
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id")+"\t|\t"+resultSet.getString("category"));
            }
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return results;
    }

    public void update(String category, int id){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with category table");
            Statement statement = connection.createStatement();
            String query="update categories set category='"+category+"' where id="+id;
            statement.execute(query);
            System.out.println("category table updated");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public void delete(int id){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with category table");
            Statement statement = connection.createStatement();
            String query="delete from categories where id="+id;
            statement.execute(query);
            System.out.println("content deleted from category table");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

}
