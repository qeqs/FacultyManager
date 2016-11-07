package manager.entities;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by ПК on 07.11.2016.
 */
public class Student {
    private Long student_id;
    private Long elective_id;
    private Long group_id;
    private Long course_id;

    private Set subjects = new HashSet();

    private String surname;
    private String name;
    private String middle_name;
    private Date bithday;
    private String address;
    private Boolean is_leader;


    public Student(){
    }

    public void setStudentId(Long student_id) {
        this.student_id = student_id;
    }
    public void setElectiveId(Long elective_id) {
        this.elective_id= elective_id;
    }
    public void setGroup_id(Long group_id) {
        this.group_id= group_id;
    }
    public void setCourse_id(Long course_id) {
        this.course_id= course_id;
    }
    public void setSubjects(Set subjects) {
        this.subjects = subjects;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }
    public void setBithday(Date bithday) {
        this.bithday = bithday;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setIs_leader(Boolean is_leader) {
        this.is_leader = is_leader;
    }
    public Long getStudentId() {
     return student_id;
    }
    public Long getElectiveId() {
       return elective_id;
    }
    public Long getGroup_id() {
        return group_id;
    }
    public Long getCourse_id() {
        return course_id;
    }
    public Set getSubjects() {
        return subjects;
    }
    public String getSurname() {
        return surname;
    }
    public String  getName() {
        return name;
    }
    public String getMiddle_name() {
        return middle_name;
    }
    public Date getBithday() {
       return bithday;
    }
    public String getAddress() {
       return address;
    }
    public Boolean setIs_leader() {
      return is_leader;
    }
}
