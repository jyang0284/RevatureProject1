import models.Reimbursements;
import models.User;
import repositories.ReimbDao;
import repositories.ReimbDaoimpl;
import repositories.UserDao;
import repositories.UserDaoimpl;
import service.UserService;
import views.Landing;

import java.io.File;
import java.sql.SQLOutput;


public class MainDriver {

    public static void main(String[] args) {

        Landing.view();

    }
}


