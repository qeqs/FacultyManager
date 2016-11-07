package manager.managers;

import manager.entities.Student;
import manager.entities.Subject;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Lygin Vadim on 07.11.2016.
 */
public class StudentManagerImpl implements StudentManager{

	@Override
	public void addStudent(Student student) throws SQLException {

	}

	@Override
	public void updateStudent(Long student_id, Student student) throws SQLException {

	}

	@Override
	public Student getStudentById(Long student_id) throws SQLException {
		return null;
	}

	@Override
	public Collection getAllStudents() throws SQLException {
		return null;
	}

	@Override
	public void deleteStudent(Student student) throws SQLException {

	}

	@Override
	public Collection getStudentBySubject(Subject subject) throws SQLException {
		return null;
	}
}
