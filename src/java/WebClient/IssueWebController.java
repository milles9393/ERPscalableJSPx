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
@ManagedBean(name = "IssueWeb")
@SessionScoped
public class IssueWebController implements Serializable {
    
    DBConnectionManager dbCon;
    private ArrayList<Issue> issues;


    /** Creates a new instance of the WebClient */
    public IssueWebController() {
        // Skapa DB Connection
        this.dbCon = new DBConnectionManager();
        
    }
    
     public String editAction(Issue issues) {
	    
	issues.setEditable(true);
	return null;
     }
     
      public void editAssignment(){
        System.out.println("this was called!");
    }
    
    public ArrayList<Issue> getAllIssues(){
        System.out.println("JHASDJJASDJAJDJAJSJDAJDJSAJ");
        return dbCon.getIssueList();
        
    }
    
       public void saveStatus(Issue item, String statusValue){
        //Get updated value from textbox, try to parse as int, then update the database.
        
        this.dbCon.updateIssueStatus(item.getIssueId(), statusValue );
        System.out.println(item.getIssueId()+ " : " + statusValue);
        System.out.println("this was called!");
    }
    
}
