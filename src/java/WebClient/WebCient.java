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
@ManagedBean(name = "webClient")
@SessionScoped
public class WebCient implements Serializable {
    
    DBConnectionManager dbCon;

    /** Creates a new instance of the WebClient */
    public WebCient() {
        // Skapa DB Connection
        this.dbCon = new DBConnectionManager();
        
    }
    
    public ArrayList<Issue> getAllIssues(){
        return dbCon.getIssueList();
    }
}
