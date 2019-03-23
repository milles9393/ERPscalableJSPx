package WebClient.Models;

public class Issue {
    private int issueId;
    private int skillId;
    private String status;
    private String comment;
    private String failComment;

    public Issue() {

    }

    public Issue(int id, int skill, String status, String comment, String failComment){
        this.issueId = id;
        this.skillId = skill;
        this.status = status;
        this.comment = comment;
        this.failComment = failComment;
    }

    public int getIssueId(){

        return this.issueId;
    }

    public void setIssueId(int id){

        this.issueId = id;
    }

    public int getSkillId(){

        return this.skillId;
    }

    public void setSkillId(int id){

        this.skillId = id;
    }

    public String getStatus(){

        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getComment(){

        return this.comment;
    }

    public void setComment(String comment){

        this.comment = comment;
    }

    public String getFailComment(){

        return this.failComment;
    }

    public void setFailComment(String failComment){

        this.failComment = failComment;
    }

    public void setEditable(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
