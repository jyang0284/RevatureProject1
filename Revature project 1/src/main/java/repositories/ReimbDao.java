package repositories;

import models.Reimbursements;
import models.ReimbursementStatus;
import service.ReimbursementService;

import java.util.List;

public interface ReimbDao {

    //This retrieves a reimbursement from a specific user from the reimbursement table
    //This allows employees to view their past tickets and pending requests
    List<Reimbursements> getAllReimbursementsGivenUsersId(Integer author);

    //This method allows users to update reimbursement status
    //This lets a user update the status of a reimbursement in the reimbursement table
    //This lets finance managers are authorized to approve and deny requests for expense reimbursement
    void updateReimbursement(Reimbursements update);

    //This method allows users to update reimbursement status
    void updateReimbursements(Reimbursements Status); //edited

    //This gets one specific list
    Reimbursements getOneList(int reimb_id);

    //This method allows users to update reimbursement status
    void updateReimbursement(Integer status, Integer id);

    //This lets a user delete a row from the reimbursement table
    //This is an extra function in case users mess up on their reimbursement request
    void deleteRecordFromReimbursements(Integer delete);


    //This is a function employees should be able to perform
    //This lets users submit/create requests for reimbursement
    void createReimbursements(Integer amount, Integer author, Integer type);


}
