package guessNumber;

import java.io.Serializable;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * @author bondenn is the real god
 * @author nbuser
 */
@ManagedBean(name = "UserNumberBean")
@SessionScoped
public class UserNumberBean implements Serializable {

    Integer randomInt;
    Integer userNumber;
    String response = "yey u BAJS it";

    /** Creates a new instance of UserNumberBean */
    public UserNumberBean() {
        Random randomGR = new Random();
        randomInt = new Integer(randomGR.nextInt(3));
        System.out.println("Mattias's number: " + randomInt);
    }

    public Integer getUserNumber() {
        return userNumber;
    }
    
     public String getUserHej() {
        
         return "hej";
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

     public String getResponse() {
      /* if ((userNumber != null) && (userNumber.compareTo(randomInt) == 0)) {
            //invalidate user session
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();

            return "Yay you got it! " + userNumber;
        } else {

            // including HTML requires that you set escape="false" in view
            return "<p>Sorry, " + userNumber + " isn't it.</p>"
                    + "<p>Guess again...</p>";
       } */
      return this.response;
    }
}
