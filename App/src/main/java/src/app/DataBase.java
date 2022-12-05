package src.app;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import src.logic.AllUsersEntity;
import src.logic.CaptainsEntity;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class DataBase {
    private static DataBase instance;

//    private SessionFactory sessionFactory;
//
//    private Session session;

    private Configuration con;

    private StandardServiceRegistry reg;
    private void connect()
    {
        this.con = new Configuration().configure().addAnnotatedClass(CaptainsEntity.class);
//        con.addAnnotatedClass()
        this.reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
//        this.sessionFactory = con.buildSessionFactory(reg);
//        this.session = sessionFactory.openSession();
//        session.close();
//        this.reg = new StandardServiceRegistryBuilder().configure().build()

    }

//    public void addUser(AllUsersEntity allUsers)
//    {
//
//    }

    public void addCaptain(CaptainsEntity cap)
    {
        SessionFactory sfa = con.buildSessionFactory(reg);
        Session ss = sfa.openSession();
        Transaction tx = ss.beginTransaction();
        ss.save(cap);
        tx.commit();
        ss.close();
        sfa.close();
    }

    private DataBase()
    {
        connect();

    }


    public static DataBase getInstance() {
        if (instance == null)
        {
            instance = new DataBase();
        }
        return instance;
    }
}
