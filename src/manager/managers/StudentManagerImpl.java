package manager.managers;

import manager.ManagersFactory;
import manager.entities.Student;
import manager.entities.Subject;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Lygin Vadim on 07.11.2016.
 */
public class StudentManagerImpl implements StudentManager{

	Session session;

	public StudentManagerImpl(Session session){
		this.session = session;
	}

	@Override
	public void addStudent(Student student) throws SQLException {
		ManagersFactory.getInstance().beginSession();
		session.save(student);
	}

	@Override
	public void updateStudent(Long student_id, Student student) throws SQLException {
        ManagersFactory.getInstance().beginSession();
        session.update(student);
	}

	@Override
	public Student getStudentById(Long student_id) throws SQLException {
		return (Student)session.load(Student.class,student_id);
	}

	@Override
	public Collection getAllStudents() throws SQLException {
		return session.createCriteria(Student.class).list();
	}

	@Override
	public void deleteStudent(Student student) throws SQLException {
        ManagersFactory.getInstance().beginSession();
        session.delete(student);
	}

	@Override
	public Collection getStudentBySubject(Subject subject) throws SQLException {
        long subject_id = subject.getSubj_id();
        Query query = session.createQuery( "from student where subject_id = :subj_id"
               /* " select s "
                        + " from student s INNER JOIN s.subjects subject"
                        + " where subject.id = :subj_id "*/
        )
                .setLong("subj_id",subject_id);
		return query.list();
	}
}
