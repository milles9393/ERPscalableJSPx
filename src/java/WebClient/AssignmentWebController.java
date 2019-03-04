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
@ManagedBean(name = "AssignmentWeb")
@SessionScoped
public class AssignmentWebController implements Serializable {
    
    private DBConnectionManager dbCon;
    private int selectedIssue;

    /** Creates a new instance of the Assignment Web Client */
    public AssignmentWebController() {
        // Skapa DB Connection
        this.dbCon = new DBConnectionManager();
        this.selectedIssue = 1043;
        
        System.out.println("test!");
        //ArrayList<Assignment> test = getAllAssignments();
        
    }
    
    public ArrayList<Assignment> getAllAssignments(){
        System.out.println("Detta kördes!");
        return dbCon.getAssignmentList(this.selectedIssue);
    }
}
