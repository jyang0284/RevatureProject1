package service;

import models.User;
import repositories.UserDao;
import repositories.UserDaoimpl;

/*
 * The service package is where the business logic is done. All of the complex algorithms will be
 * done in the service layer
 * */

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public UserService(){
        this.userDao = new UserDaoimpl();
    }

//Validates Credentials to login:
    public User validateCredentials(String username, String password){
        User user = this.userDao.getUserGivenUsername(username);

        //user wasn't found so return null
        if(user == null)
            return null;

        if(!password.equals(user.getPassword()))
            return null;

        return user;
    }
//Creates/Registers new user

    public Boolean createUser(User user){
        //get user from db
        User userFromDb = userDao.getUserGivenUsername(user.getUsername());

        if(userFromDb != null){
            return Boolean.FALSE;
        }

        this.userDao.createUser(user);
        return Boolean.TRUE;
    }



}



