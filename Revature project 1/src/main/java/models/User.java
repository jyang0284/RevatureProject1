package models;

/*
* The models package is the data structure that we will be passing around our application
* */

import java.util.Date;

public class User{

    private Integer id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private Integer roleID;
    private Date dateCreated;

//These are my three constructors:

//1.
    public User() {
    }
//2.
    public User(Integer id, String username, String password, String firstname, String lastname, String email, Integer roleID, Date dateCreated) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.roleID = roleID;
        this.dateCreated = dateCreated;
    }
//3. This works for creating new users when called

    public User(String username, String password, String firstname, String lastname) {
        this.id = null;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = null;
        this.roleID = null;
        this.dateCreated = null;
    }

    //Could work for when verifying someone's credentials
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username) {
        this.username = username;
    }

    // These are my getters/Setters below:
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


// This is my toString method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", roleID=" + roleID +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
