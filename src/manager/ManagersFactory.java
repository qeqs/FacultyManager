package manager;

import manager.managers.StudentManager;
import manager.managers.StudentManagerImpl;
import manager.managers.SubjectManager;
import org.hibernate.Session;

/**
 * Created by Vadim on 09.11.2016.
 */
public class ManagersFactory {
    private static StudentManager studentManager;
    private static SubjectManager subjectManager;
    private static ManagersFactory instance;
    private static Session session;

    private ManagersFactory(){
        session = Main.getSessionFactory().openSession();

    }
    public static ManagersFactory getInstance(){
        if(instance==null) instance = new ManagersFactory();
        return instance;
    }

    public static StudentManager getStudentManager() {
        if(studentManager==null)studentManager=new StudentManagerImpl(session);
        return studentManager;
    }
    public void save(){
        session.getTransaction().commit();
    }
    public void rollback(){
        session.getTransaction().rollback();
    }
    public void beginSession(){
        if(session.getTransaction().wasCommitted()||session.getTransaction().wasRolledBack()){
            session.beginTransaction();
        }
    }

}
