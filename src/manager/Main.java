package manager;

import manager.gui.MainFrame;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
public class Main {

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }



    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
