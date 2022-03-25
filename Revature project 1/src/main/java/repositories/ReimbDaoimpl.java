package repositories;

import models.Reimbursements;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbDaoimpl implements ReimbDao {

    String url = "jdbc:postgresql://revature-fullstack-java-database.cnxdgkl9hdlv.us-east-1.rds.amazonaws.com/Project1";
    String username = "postgres";
    String password = "p4ssw0rd";

    //This method allows users to display all of a specific user's reimbursement requests
    @Override
    public List<Reimbursements> getAllReimbursementsGivenUsersId(Integer author) {
        List<Reimbursements> lists = new ArrayList<>();

        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from reimbursements where reimb_author_fk = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, author);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lists.add(new Reimbursements(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getTimestamp(9)));
            }


        } catch (SQLException sqle) {
            sqle.printStackTrace();

        }

        return lists;
    }

    @Override
    public void updateReimbursement(Reimbursements update) {

    }

    @Override
    public void updateReimbursements(Reimbursements Status) {

    }

    //This method allows users to create reimbursement requests
    @Override
    public void createReimbursements(Integer amount, Integer author, Integer type) {
        //This is a DML Statement, so we won't be expecting a return/resultset

        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "insert into reimbursements(reimb_amount, reimb_author_fk, reimb_type_id_fk) values (?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, amount);
            ps.setInt(2, author);
            ps.setInt(3, type);

            ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    //This gets one specific list
    @Override
    public Reimbursements getOneList(int reimb_id) {
        String sql = "select * from reimbursements where reimb_Id = ?;";
        Reimbursements reimbursements = null;

    try(Connection conn = ConnectionUtil.getConnection()){

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, reimb_id);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            reimbursements = new Reimbursements(

                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getTimestamp(6));}

    }catch(SQLException sqle){
        sqle.printStackTrace();
    }

        return reimbursements;
    }


    //This method allows users to update reimbursement status
    @Override
    public void updateReimbursement(Integer status, Integer id) {

        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "update reimbursements set reimb_status_id_fk = ? where and reimb_id = ? ;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, id);



            ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }



    //This method allows users to change/update employees reimbursement status
    @Override
    public void deleteRecordFromReimbursements(Integer delete) {

        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "delete from reimbursements where reimb_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, delete);

            ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }




}
