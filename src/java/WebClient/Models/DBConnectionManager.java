/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebClient.Models;

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
        System.out.println("DBConnectionManager Object is being created...");
        //Establish connection do the database
        try{
            Class.forName(dbDriver);
            this.con = DriverManager.getConnection(dbUrl, "imsuser","imspassword");

        } catch (Exception e){
            System.out.println("A connection could not be made:" + e);
        }
    }

    public ArrayList<Issue> getIssueList(){
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


    public void updateIssueStatus(int issueId, String status) {

        try {
            String updateSqlQuery = "UPDATE Issue set status = ? WHERE issueId = ?";
            PreparedStatement updateIssueStmt = con.prepareStatement(updateSqlQuery);
            updateIssueStmt.setString(1, status);
            updateIssueStmt.setInt(2, issueId);

            updateIssueStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error updating!!!! --->: " + e);

        }
    }

    public void updateAssignmentTime(int assignmentId, int passedTime){

        try {

            String updateSqlQuery = "UPDATE Assignment SET passedTime = ? WHERE assignmentId = ?";
            PreparedStatement updateIssueStmt = con.prepareStatement(updateSqlQuery);
            updateIssueStmt.setInt(1, passedTime);
            updateIssueStmt.setInt(2, assignmentId);

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
