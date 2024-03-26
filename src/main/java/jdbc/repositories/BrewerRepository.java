package jdbc.repositories;

import jdbc.models.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrewerRepository {

    public void create(String name, String address, int zipcode, String city, int turnover){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with brewers table");
            Statement statement = connection.createStatement();
            String query="insert into brewers (name, address, zipcode, city, turnover) values ('"+name+"', '"+address+"', '"+zipcode+"', '"+city+"', '"+turnover+"')";
            statement.execute(query);
            System.out.println("new row added to brewers table");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public List<Category> read(){
        List<Category> results = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with brewers table");
            Statement statement = connection.createStatement();
            String query="select * from brewers";
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("ID \t|\t name \t|\t address \t|\t zipcode \t|\t city \t|\t turnover");
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id")+" \t|\t "+resultSet.getString("name")+" \t|\t "+resultSet.getString("address")+" \t|\t "+resultSet.getInt("zipcode")+" \t|\t "+resultSet.getString("city")+" \t|\t "+resultSet.getInt("turnover")+" \t|\t ");
            }

        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return results;
    }

    public void update(String name, String address, int zipcode, String city, int turnover, int id){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with brewers table");
            Statement statement = connection.createStatement();
            String query="update brewers set name='"+name+"', address='"+address+"', zipcode='"+zipcode+"', city='"+city+"', turnover='"+turnover+"' where id="+id;
            statement.execute(query);
            System.out.println("brewers table updated");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public void delete(int id){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with brewers table");
            Statement statement = connection.createStatement();
            String query="delete from brewers where id="+id;
            statement.execute(query);
            System.out.println("content deleted from brewers table");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

}
