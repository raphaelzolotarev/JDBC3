package jdbc.repositories;

import jdbc.models.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeerRepository {

    public void create(String name, int brewerid, int categoryid, float price, int stock, int alcohol, int version, Blob image){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with beers table");
            Statement statement = connection.createStatement();
            String query="insert into beers (name, brewerid, categoryid, price, stock, alcohol, version, image)  values ('"+name+"', '"+brewerid+"', '"+categoryid+"', '"+price+"', '"+stock+"', '"+alcohol+"', '"+version+"', '"+image+"')";
            statement.execute(query);
            System.out.println("new row added to beers table");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public List<Category> read(){
        List<Category> results = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with beers table");
            Statement statement = connection.createStatement();
            String query="select * from beers";
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("ID \t|\t name \t|\t brewerid \t|\t categoryid \t|\t price \t|\t stock \t|\t alcohol \t|\t version \t|\t image");
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id")+" \t|\t "+resultSet.getString("name")+" \t|\t "+resultSet.getInt("brewerid")+" \t|\t "+resultSet.getInt("categoryid")+" \t|\t "+resultSet.getFloat("price")+" \t|\t "+resultSet.getInt("stock")+" \t|\t "+resultSet.getInt("alcohol")+" \t|\t "+resultSet.getInt("version")+" \t|\t "+resultSet.getBlob("image"));
            }

        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return results;
    }

    public void update(String name, int brewerid, int categoryid, float price, int stock, int alcohol, int version, Blob image, int id){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with beers table");
            Statement statement = connection.createStatement();
            String query="update beers set name='"+name+"', brewerid='"+brewerid+"', categoryid='"+categoryid+"', price='"+price+"', stock='"+stock+"', alcohol='"+alcohol+"', version='"+version+"', image='"+image+"' where id="+id;
            statement.execute(query);
            System.out.println("beers table updated");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public void delete(int id){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            System.out.println("Connection is made with beers table");
            Statement statement = connection.createStatement();
            String query="delete from beers where id="+id;
            statement.execute(query);
            System.out.println("content deleted from beers table");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

}
