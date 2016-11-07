package manager.entities;

/**
 * Created by Milonyash on 07.11.2016.
 */
public class Subject {
    private Long subj_id;
    private String name;
    public Subject(){

    }
    public void setSubj_id(Long subj_id){
        this.subj_id=subj_id;
    }
    public void setName(String name){
        this.name=name;
    }
    public  Long getSubj_id(){
        return subj_id;
    }
    public String getName(){
        return name;
    }
}
