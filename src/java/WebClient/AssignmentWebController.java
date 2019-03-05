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
    private int selectedIssue;
    private ArrayList<Assignment> assignments;

    /** Creates a new instance of the Assignment Web Client */
    public AssignmentWebController() {
        System.out.println("AssignmentWeb Object is being created...");
        // Skapa DB Connection
        this.dbCon = new DBConnectionManager();
        this.selectedIssue = 1043;
        /*
        | Hämta assignments för issueid och stoppa i 'assignments', detta görs
        | i konstruktorn då getters kommer att köras många gånger för UI-komponenter
        | så som datatable, detta gör att vi bara behöver göra en databasanslutning.
        */
        this.assignments = dbCon.getAssignmentList(this.selectedIssue);
        
    }
    
    public void getAssignments(int issue){
        
    }
    
    public ArrayList<Assignment> getAllAssignments(){
        return assignments;
    }
    
    public void editAssignment(){
        System.out.println("this was called!");
    }
}
