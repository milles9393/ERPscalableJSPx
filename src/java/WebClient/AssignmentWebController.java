package WebClient;

import WebClient.Models.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author bondenn is the real god
 * @author nbuser
 */
@ManagedBean(name = "AssignmentWeb")
@SessionScoped
public class AssignmentWebController implements Serializable {
    
    private DBConnectionManager dbCon;
    private int selectedIssueId = 0;
    private int selectedAssignmentId = 0;
    private ArrayList<Assignment> assignments;

    /** Creates a new instance of the Assignment Web Client */
    public AssignmentWebController() {
        System.out.println("AssignmentWeb Object is being created...");
        // Skapa DB Connection
        this.dbCon = new DBConnectionManager();
        /*
        | Hämta assignments för issueid och stoppa i 'assignments', detta görs
        | i konstruktorn då getters kommer att köras många gånger för UI-komponenter
        | så som datatable, detta gör att vi bara behöver göra en databasanslutning.
        */
        this.assignments = dbCon.getAssignmentList(this.selectedIssueId);
        
    }
    
    public void setSelectedAssignmentId(int i){
        this.selectedAssignmentId = i;
    }
    public int getSelectedAssignmentId(){
        return this.selectedAssignmentId;
    }
    
    public String setSelectedIssueId(Issue selectedIssue){
        this.selectedIssueId = selectedIssue.getIssueId();
        this.assignments = dbCon.getAssignmentList(this.selectedIssueId);
        System.out.println(selectedIssue.getIssueId() + " valdes!");
        return "assignments.xhtml";
    }
    
    public void getAssignments(int issue){
    }
    
    public ArrayList<Assignment> getAllAssignments(){
        return assignments;
    }
    
    public void saveAssignment(Assignment item, int test){
        //Get updated value from textbox, try to parse as int, then update the database.
        
        this.dbCon.updateAssignmentTime(item.getAssignmentId(), test);
        System.out.println(item.getAssignmentId() + " : " + test);
        System.out.println("this was called!");
    }
}
