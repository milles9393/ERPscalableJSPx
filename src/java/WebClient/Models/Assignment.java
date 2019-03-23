package WebClient.Models;

public class Assignment {
    private int assignmentId;
    private int issueId;
    private int employeeId;
    private String assignmentName;
    private int allottedTime;
    private int passedTime;
    private String comment;

    public Assignment() {
        //constructor
    }
    
        boolean editable;
		
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
    
        
        //end of updates
        

    public int getAssignmentId() {

        return assignmentId;
    }

    public void setAssignmentId(int id){

        this.assignmentId = id;
    }

    public int getIssueId(){

        return this.issueId;
    }

    public void setIssueId(int id){

        this.issueId = id;
    }

    public int getEmployeeId(){

        return this.employeeId;
    }

    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }

    public String getAssignmentName(){

        return this.assignmentName;
    }

    public void setAssignmentName(String assignmentName){

        this.assignmentName = assignmentName;
    }

    public int getAllottedTime(){

        return this.allottedTime;
    }

    public void setAllottedTime(int allottedTime){
        this.allottedTime = allottedTime;
    }

    public int getPassedTime(){
        return this.passedTime;
    }

    public void setPassedTime(int passedTime){

        this.passedTime = passedTime;
    }

    public String getComment(){

        return this.comment;
    }

    public void setComment(String comment){

        this.comment = comment;
    }
}
