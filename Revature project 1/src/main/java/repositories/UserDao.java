package repositories;

import models.User;

/*
Who can remind me what the interface is and what it is used for?
Answer 1: To create a contract between the interface, and the classes that implement.
Why do we create an interface?
Answer: We create an interface to essentially define the contract that we need for the entire system to function properly.
*/

//Below is my contract:
//For our user object, we need to be able to get users given username, and we need to be able to create a user now.

public interface UserDao {
    User getUserGivenUsername(String username); //Get user's given username
    void createUser(User user); //Creates new user
}
//How is this implemented? We create a new class called "UserDaoimpl" and carry on from there.
