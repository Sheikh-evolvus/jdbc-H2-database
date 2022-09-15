package com.ecolvus.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args ) throws Exception
    {

        System.out.println("Hello World!");

        String JDBC_H2_URL = "jdbc:h2:mem:evolvus";

        String userName = "shabaz";
        
        String password = "Shabaz@123";

        try {
            Connection connection = DriverManager.getConnection(JDBC_H2_URL, userName, password);

            String createSql = "CREATE TABLE  student(stname varchar(100),strollnum varchar(200))";

            Statement statement = connection.createStatement();

            boolean isCreated = statement.execute(createSql);

            System.out.println("status of the table is " + isCreated);

            String insertSql = "INSERT INTO student(stname,strollnum) values('shabaz','18CQSAC014');";

            boolean isInserted = statement.execute(insertSql);

            System.out.println("the inserted records " + isInserted);

            String selectSql = "SELECT *  FROM student WHERE stname='shabaz';";

            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
            	 System.out.println(" the student name is=" + resultSet.getString("stname"));
                System.out.println(" register no of student is=" + resultSet.getString("strollnum"));

            }

            String updatedroll = "sheik@123";
            String updateSql = "UPDATE student SET strollnum='" + updatedroll + "';";

            int result = statement.executeUpdate(updateSql);

            System.out.println("records updated is " + result);
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
}