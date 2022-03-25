package service;
import models.Reimbursements;
import repositories.ReimbDao;
import repositories.ReimbDaoimpl;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReimbursementService {

    private ReimbDao reimbDao;

    //My constructors:
    public ReimbursementService(){
        this.reimbDao = new ReimbDaoimpl();
    }


    //For testing purposes
    public ReimbursementService(ReimbDao reimbDao){
        this.reimbDao = reimbDao; //This variable (reimbDao) is equal to the "reimbDao"  (The code above this one)
    }


    //This method allows users to create reimbursement requests // Equivalent to adding reimbursements
    public void createReimbursement(Integer amount, Integer author, Integer type){
        this.reimbDao.createReimbursements(amount, author, type);
    }


    //DML
    //This method allows users to display all of a specific user's reimbursement requests
    //This looks like the code is repeated twice, which it is, but remember that our view is not directly accessing through the service. So that's why we need this.
    public List<Reimbursements>getAllReimbursementsGivenUsersId(Integer author) {
        return this.reimbDao.getAllReimbursementsGivenUsersId(author);
    }

    //This method deletes a reimbursement request from a specific user
    public void deleteRecordFromReimbursements(Integer delete){
        this.reimbDao.deleteRecordFromReimbursements(delete);
    }

    //This method allows users to update reimbursement status
    public void updateReimbursement(Integer Status, Integer Id){
        this.reimbDao.updateReimbursement(Status , Id);

        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "update reimbursements set reimb_status_id_fk = ? where and reimb_id = ? ;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Status);
            ps.setInt(2, Id);



            ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }
}

