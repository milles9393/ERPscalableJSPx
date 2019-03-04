package WebClient;

import WebClient.Models.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * @author bondenn is the real god
 * @author nbuser
 */
@ManagedBean(name = "assignmentWeb")
@SessionScoped
public class AssignmentWebController implements Serializable {
    
    private DBConnectionManager dbCon;
    private int selectedIssue;

    /** Creates a new instance of the Assignment Web Client */
    public AssignmentWebController(int selectedIssue) {
        // Skapa DB Connection
        this.dbCon = new DBConnectionManager();
        this.selectedIssue = selectedIssue;
        
    }
    
    public ArrayList<Assignment> getAllAssignments(){
        return dbCon.getAssignmentList(this.selectedIssue);
    }
}
