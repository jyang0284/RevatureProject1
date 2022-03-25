package repositories;

import models.User;
import util.ConnectionUtil;

import java.sql.*;

/*
* What is JDBC?
 *     Java DataBase Connectivity
 *       - allows us to connect to a database and run sql commands
 *
 *--------------------IMPORTANT!!! NEED TO KNOW HOW TO CONNECT TO DATABASE!!!--------------------
 * What is needed to connect to our postgresql database on AWS using JDBC?
 *   - url (location of our database)
 *       - syntax: jdbc:postgresql://[AWS_RDS_ENDPOINT]/[DATABASE_NAME]
 *   - username for our aws database
 *   - password for our aws database
 *   - driver (need to be added to the pom.xml)
 *
 *   Interfaces and classes of JDBC:
 *   - Connection (interface) : active connection with the database
 *   - DriverManager : retrieves the connection from our database
 *   - Statement : object representation of the sql statement (does NOT prevent SQL injection)
 *      SQL Injection: It's more of like an accident/breech. For example:
 *
 * Let's say that you, instead of passing a username maybe you typed in drop table users.
 * and that's how the statement executes to the database and our table gets dropped. This could lead to major problems such as data loss for a project/company.
 * To prevent SQL injection, we use PreparedStatements which already have it's own predefined actions to make sure it doesn't act out of the ordinary.
 *
 *       - PreparedStatement : object representation of the sql statement (prevents SQL injection)
 *   - ResultSet : object representation of the result set
 *
 *
 * The most common error I see connecting to JDBC is
 *   no suitable driver found
 *       - you don't have the driver (Sometimes you have to refresh your driver)
 *       - url string is incorrect
* */

//This is our first JDBC statement: What does this accomplish?
//This gets the username input from the user into our database


public class UserDaoimpl implements UserDao{

    String url = "jdbc:postgresql://revature-fullstack-java-database.cnxdgkl9hdlv.us-east-1.rds.amazonaws.com/Project1";
    String username = "postgres";
    String password = "p4ssw0rd";


    @Override
    public User getUserGivenUsername(String username) {

        User user = null;

        try(Connection conn = ConnectionUtil.getConnection()) {
            //Code above is getting active connection from our database
            //The connection code is in the parenthesis so when the connection is done executing it will close by itself, versus having to close the connection (coon.close();" before the try-catch statement ends.

            String sql = "select * from users where users_username = ?;";

            //Preparing our sql statement
            PreparedStatement ps = conn.prepareStatement(sql);

            //Adding the username into the question mark in the sql statement
            ps.setString(1, username); //This line won't be needed if we are just trying to view users and not adding

            //Executing the statement to get the result and result set
            ResultSet rs = ps.executeQuery();

            //This is how we get our user from our database:
            while(rs.next()){
                user = new User(

                        rs.getInt(1), //These column index number are referencing the column from your SQL database
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getTimestamp(8)
                );
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
            return user;
        }

    @Override
    public void createUser(User user) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "insert into users (users_username, users_password, users_firstname, users_lastname) values (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getFirstname());
            ps.setString(4,user.getLastname());

            ps.executeUpdate(); //DML Statements use "ps.executeUpdate()" to manipulate data. We are not getting any results back, thus us why we don't
            // have an explicit return. But it does return how much rows got affected

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

    }

}
