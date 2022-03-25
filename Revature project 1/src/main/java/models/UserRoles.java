package models;

public class UserRoles {

    private Integer id;
    private String reimbursementType;

    //These are my three constructors:
//1.
    public UserRoles() {
    }
//2.
    public UserRoles(Integer id, String reimbursementType) {
        this.id = id;
        this.reimbursementType = reimbursementType;
    }
//3.
    public UserRoles(String reimbursementType) {
        this.reimbursementType = reimbursementType;
    }

    // These are my getters/Setters below:

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReimbursementType() {
        return reimbursementType;
    }

    public void setReimbursementType(String reimbursementType) {
        this.reimbursementType = reimbursementType;
    }

    // This is my toString method
    @Override
    public String toString() {
        return "userRoles{" +
                "id=" + id +
                ", reimbursementType='" + reimbursementType + '\'' +
                '}';
    }
}
