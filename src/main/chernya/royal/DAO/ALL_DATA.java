package royal.DAO;

import royal.Models.all_choc;
import org.springframework.stereotype.Component;
import royal.Models.employees;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ALL_DATA {
    private static final String URL= "jdbc:mysql://localhost:3306/mydb";
    static final String USER = "root";
    static final String PASSWORD = "12345";
    static final String JDBC_DRIVER  = "com.mysql.cj.jdbc.Driver";
    List<all_choc> chocolateList;
    List<employees> employeesList;

    private static Connection connection;

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //Внедрение зависимости от интерфейса Connection
    public List<all_choc> display() throws SQLException, InterruptedException {
        //Получение ассортимента шоколада
        chocolateList = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM all_choc");
            while (rs.next()) {
                all_choc chocolate = new all_choc();
                chocolate.setId(rs.getInt("id_choc"));
                chocolate.setChoc_name(rs.getString("choc_name"));
                chocolate.setQuantity(rs.getInt("quantity_choc"));
                chocolate.setPrice(rs.getInt("price_choc"));

                chocolateList.add(chocolate);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return chocolateList;
    }
    public all_choc show(int id){
        all_choc all_choc = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT* FROM all_choc WHERE id_choc=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            all_choc = new all_choc();
            all_choc.setId(resultSet.getInt("id_choc"));
            all_choc.setChoc_name(resultSet.getString("choc_name"));
            all_choc.setQuantity(resultSet.getInt("quantity_choc"));
            all_choc.setPrice(resultSet.getInt("price_choc"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all_choc;
    }
    public void save(all_choc all_choc){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO all_choc(choc_name, quantity_choc, price_choc) VALUES (?,?,?)");
            preparedStatement.setString(1, all_choc.getChoc_name());
            preparedStatement.setInt(2, all_choc.getQuantity());
            preparedStatement.setInt(3,all_choc.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void update(int id, all_choc updatedChocolate){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE all_choc SET choc_name=?, quantity_choc=?, price_choc=? WHERE id_choc=? ");
            preparedStatement.setString(1, updatedChocolate.getChoc_name());
            preparedStatement.setInt(2, updatedChocolate.getQuantity());
            preparedStatement.setInt(3,updatedChocolate.getPrice());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM all_choc WHERE id_choc=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void sale(int id, all_choc soldChocolate){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE all_choc SET quantity_choc=quantity_choc-? WHERE id_choc=?");
            preparedStatement.setInt(1, soldChocolate.getQuantity());
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public List<employees> empl_display(){
        employeesList = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employees");
            while (rs.next()) {
                employees employee = new employees();
                employee.setEmpl_id(rs.getInt("id"));
                employee.setEmpl_name(rs.getString("name"));
                employee.setEmpl_age(rs.getInt("age"));
                employee.setEmpl_position(rs.getString("position"));

                employeesList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeesList;
    }

}
