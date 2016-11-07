package manager.managers;

import manager.entities.Student;
import manager.entities.Subject;

import java.util.Collection;
import java.sql.SQLException;
/**
 * Created by ПК on 07.11.2016.
 */
public interface StudentManager {

	public void addStudent(Student student) throws SQLException;
	public void updateStudent(Long student_id, Student student) throws SQLException;
	public Student getStudentById(Long student_id) throws SQLException;
	public Collection getAllStudents() throws SQLException;
	public void deleteStudent(Student student) throws SQLException;
	public Collection getStudentBySubject(Subject subject) throws SQLException;

}
