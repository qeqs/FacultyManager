package manager.managers;

import manager.ManagersFactory;
import manager.entities.Student;
import manager.entities.Subject;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Vadim on 11.11.2016.
 */
public class SubjectManagerImpl implements SubjectManager {

    Session session;

    public SubjectManagerImpl(Session session){
        this.session = session;
    }
    @Override
    public void addSubject(Subject subject) throws SQLException {
        ManagersFactory.getInstance().beginSession();
        session.save(subject);
    }

    @Override
    public void updateSubject(Subject subject) throws SQLException {
        ManagersFactory.getInstance().beginSession();
        session.update(subject);
    }

    @Override
    public Subject getSubjectById(Long subject_id) throws SQLException {
        return (Subject) session.load(Subject.class,subject_id);
    }

    @Override
    public Collection getAllSubjects() throws SQLException {
        return session.createCriteria(Subject.class).list();
    }

    @Override
    public void deleteSubject(Subject subject) throws SQLException {
        ManagersFactory.getInstance().beginSession();
        session.delete(subject);
    }

    @Override
    public Collection getSubjectByStudent(Student student) throws SQLException {
        long student_id = student.getStudentId();
        Query query = session.createQuery(
                "select subj from subject subj inner join student_subjects ss on " +
                "subj.subj_id = ss.subj_id and ss.student_id =:student_id ; "
        )
                .setLong("student_id",student_id);
        return query.list();
    }
}
