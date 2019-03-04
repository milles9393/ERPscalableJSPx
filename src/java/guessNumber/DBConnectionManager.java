/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessNumber;

import java.sql.*;
import java.util.ArrayList;

//This class will contain the connection and interaction with the mariadb database.
public class DBConnectionManager {

    //Connection to the database
    Connection con;
    String dbDriver = "com.mysql.jdbc.Driver";
    String dbUrl = "jdbc:mysql://gitgud.eu:3306/cms";

    //Constructor, is called when a DBConnectionModel object is created.
    public DBConnectionManager(){
        //Establish connection do the database
        try{
            Class.forName(dbDriver);
            this.con = DriverManager.getConnection(dbUrl, "imsuser","imspassword");

        } catch (Exception e){
            System.out.println("A connection could not be made:" + e);
        }
    }

    public void CreateIssue(){
    }

    public ArrayList<Issue> getIssueList(){ //
        ResultSet rs = null;
        String sql = "SELECT issueId, skillId, status, comment FROM Issue";
        ArrayList<Issue> test = new ArrayList<>();

        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column names
                Issue i = new Issue();
                i.setIssueId(rs.getInt("issueId"));
                i.setSkillId(rs.getInt("skillId"));
                i.setStatus(rs.getString("status"));
                i.setComment(rs.getString("comment"));
                test.add(i);
            }

        } catch (Exception e){
            System.out.println("Something went wrong: " + e);
        }

        return test;
    }

    public ArrayList<Assignment> getAssignmentList(int issueId){
        ResultSet rs = null;
        String sql = "SELECT assignmentId, issueId, employeeId, name, allottedTime, passedTime, comment FROM Assignment WHERE issueId = " + issueId;
        ArrayList<Assignment> test = new ArrayList<>();

        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {

                //Retrieve by column names
                Assignment a = new Assignment();

                a.setAssignmentId(rs.getInt("assignmentId"));
                a.setIssueId(rs.getInt("issueId"));
                a.setEmployeeId(rs.getInt("employeeId"));
                a.setAssignmentName(rs.getString("name"));
                a.setAllottedTime(rs.getInt("allottedTime"));
                a.setPassedTime(rs.getInt("passedTime"));
                a.setComment(rs.getString("comment"));

                test.add(a);
            }

        } catch (Exception e){
            System.out.println("Something went wrong: " + e);
        }

        return test;
    }

    public ArrayList<Skill> getSkills(){
        ResultSet rs;
        String sql = "SELECT skillId, name FROM Skill";
        ArrayList<Skill> test = new ArrayList<>();

        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column names
                Skill i = new Skill();
                i.setSkillId(rs.getInt("skillId"));
                i.setSkillName(rs.getString("name"));
                test.add(i);
            }

        } catch (Exception e){
            System.out.println("Something went wrong: " + e);
        }
        return test;
    }

    public void createNewIssue(int skill, String comment){

        try{
            PreparedStatement newIssueStmt = con.prepareStatement("insert into Issue (skillId, comment) values (?, ?)");

            newIssueStmt.setInt(1, skill);
            newIssueStmt.setString(2, comment);
            newIssueStmt.executeUpdate();
        }
            catch(Exception e) {
            System.out.println(e);
            }
    }

    public void deleteIssue(int skillId){

        try{
            String deleteSqlQuery = "DELETE FROM Issue where (issueId) = (?)";
            PreparedStatement deleteIssueStmt = con.prepareStatement(deleteSqlQuery);
            deleteIssueStmt.setInt(1, skillId);
            int k = deleteIssueStmt.executeUpdate();
            System.out.println(k +" records deleted");
        }

        catch (Exception e){
            System.out.println("error deleting!!!! --->: " + e);
        }
    }

    public void updateIssue(int issueId, int skillId, String status, String comment) {

        try {
            String updateSqlQuery = "UPDATE Issue set status = ?, comment = ?, skillId = ? WHERE issueId = ?";
            PreparedStatement updateIssueStmt = con.prepareStatement(updateSqlQuery);
            updateIssueStmt.setString(1, status);
            updateIssueStmt.setString(2, comment);
            updateIssueStmt.setInt(3, skillId);
            updateIssueStmt.setInt(4, issueId);

            updateIssueStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error updating!!!! --->: " + e);

        }
    }

    public void updateAssignment(int assignmentId, int employeeId, String name, int allottedTime, int passedTime, String comment){

        try {

            String updateSqlQuery = "UPDATE Assignment SET employeeId = ?, name = ?, allottedTime = ?, passedTime = ?, comment = ? WHERE assignmentId = ?";
            PreparedStatement updateIssueStmt = con.prepareStatement(updateSqlQuery);
            updateIssueStmt.setInt(1, employeeId);
            updateIssueStmt.setString(2, name);
            updateIssueStmt.setInt(3, allottedTime);
            updateIssueStmt.setInt(4, passedTime);
            updateIssueStmt.setString(5, comment);
            updateIssueStmt.setInt(6, assignmentId);

            updateIssueStmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("error updating!!!! --->: " + e);
        }
    }

    public void createNewAssignment(int issueId, String name, int allottedTime, int passedTime, String comment){

        try {

            String createSqlQuery = "INSERT INTO Assignment (issueId, name, allottedTime, passedTime, comment) VALUES (?, ?, ? , ?, ?)";

            PreparedStatement updateIssueStmt = con.prepareStatement(createSqlQuery);
            updateIssueStmt.setInt(1, issueId);
            updateIssueStmt.setString(2, name);
            updateIssueStmt.setInt(3, allottedTime);
            updateIssueStmt.setInt(4, passedTime);
            updateIssueStmt.setString(5, comment);
            updateIssueStmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("error updating!!!! --->: " + e);
        }
    }


    public ArrayList<Employee> getEmployees() {

        ResultSet rs;
        String sql = "SELECT employeeId, firstName, lastName, email FROM Employee";
        ArrayList<Employee> e = new ArrayList<>();

        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column names
                Employee temployee = new Employee();
                temployee.setEmployeeId(rs.getInt("employeeId"));
                temployee.setFirstName(rs.getString("firstName"));
                temployee.setLastName(rs.getString("lastName"));
                temployee.setEmail(rs.getString("email"));
                e.add(temployee);
            }

        } catch (Exception exc){
            System.out.println("Something went wrong: " + e);
        }
        return e;

    }
}
