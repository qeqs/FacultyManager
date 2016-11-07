package manager.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Milonyash on 07.11.2016.
 */
public class Subject {
    private Long subj_id;
    private String name;
    private Set students = new HashSet();
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
    public void setSubjects(Set students) {
        this.students = students;
    }
    public Set getStudents(){
        return students;
    }

}
