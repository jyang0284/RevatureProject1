package models;

public class ReimbursementStatus {

    private Integer StatusID;
    private String reimbursementStatus;

    //These are my three constructors:
//1.

    public ReimbursementStatus() {
    }

//2.
    public ReimbursementStatus(Integer statusID, Integer reimbursementStatus) {
        StatusID = statusID;
        this.reimbursementStatus = String.valueOf(reimbursementStatus);
    }

//3.
public ReimbursementStatus(Integer reimbursementStatus) {
    this.reimbursementStatus = String.valueOf(reimbursementStatus);
}

// These are my getters/Setters below:
    public Integer getStatusID() {
        return StatusID;
    }

    public void setStatusID(Integer statusID) {
        StatusID = statusID;
    }

    public String getReimbursementStatus() {
        return reimbursementStatus;
    }

    public void setReimbursementStatus(String reimbursementStatus) {
        this.reimbursementStatus = reimbursementStatus;
    }

    // This is my toString method
    @Override
    public String toString() {
        return "reimbursementStatus{" +
                "StatusID=" + StatusID +
                ", reimbursementStatus='" + reimbursementStatus + '\'' +
                '}';
    }

}
