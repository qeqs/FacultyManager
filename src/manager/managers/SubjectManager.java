package manager.managers;

import manager.entities.Student;
import manager.entities.Subject;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Lygin Vadim on 07.11.2016.
 */
public interface SubjectManager {

	public void addSubject(Subject subject) throws SQLException;
	public void updateSubject(Long subject_id, Subject subject) throws SQLException;
	public Subject getSubjectById(Long subject_id) throws SQLException;
	public Collection getAllSubjects() throws SQLException;
	public void deleteSubject(Subject subject) throws SQLException;
	public Collection getSubjectByStudent(Student student) throws SQLException;
}
