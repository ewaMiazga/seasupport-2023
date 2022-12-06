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
import src.logic.PortsEntity;

/**
 * Class responisble for connecting to database -
 * fetching/pulling data to/from it.
 *
 * Design pattern singleton - you can get the object only from the method getInstance()
 *
 * @author Michal
 */
public class DataBase {

    private static DataBase instance;

    private Configuration con;

    private StandardServiceRegistry reg;

    /**
     * Constructor calls the method configureConnection()
     * to set configuration for connection with a database
     */
    private DataBase()
    {
        configureConnection();
    }

    /**
     * Method that sets configuration for connection
     * to the database
     */
    private void configureConnection()
    {
        this.con = new Configuration().configure();
        con.addAnnotatedClass(CaptainsEntity.class);
        con.addAnnotatedClass(AllUsersEntity.class);
        con.addAnnotatedClass(PortsEntity.class);
        this.reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

    }


    /**
     * Method responsible on the first use for creation the DataBase object
     * and then for supplying the object to whoever needs it
     *
     * @return DataBase
     */
    public static DataBase getInstance() {
        if (instance == null)
        {
            instance = new DataBase();
        }
        return instance;
    }


    /**
     * Method responsible for fetching data from database
     *  from the PORTS
     *
     * @param portId
     * @return PortsEntity
     */
    public PortsEntity getPort(String portId)
    {
        SessionFactory sfa = con.buildSessionFactory(reg);
        Session ss = sfa.openSession();
        Transaction tx = ss.beginTransaction();
        PortsEntity portsEntity = ss.get(PortsEntity.class, portId);
        tx.commit();
        ss.close();
        sfa.close();
        return portsEntity;
    }


    /**
     *  Method responsible for pulling data to database
     *  to the PORTS table
     *
     * @param portsEntity
     */
    public void addPort(PortsEntity portsEntity)
    {
        SessionFactory sfa = con.buildSessionFactory(reg);
        Session ss = sfa.openSession();
        Transaction tx = ss.beginTransaction();
        ss.save(portsEntity);
        tx.commit();
        ss.close();
        sfa.close();
    }


    /**
     * Method responsible for fetching data from database
     *  from the ALL_USERS table
     *
     * @param login
     * @return AllUsersEntity
     */
    public AllUsersEntity getUser(String login)
    {
        SessionFactory sfa = con.buildSessionFactory(reg);
        Session ss = sfa.openSession();
        Transaction tx = ss.beginTransaction();
        AllUsersEntity allUsersEntity = ss.get(AllUsersEntity.class, login);
        tx.commit();
        ss.close();
        sfa.close();
        return allUsersEntity;
    }


    /**
     * Method responsible for pulling data to database
     * to the ALL_USERS table
     *
     * @param allUsers
     */
    public void addUser(AllUsersEntity allUsers)
    {
        SessionFactory sfa = con.buildSessionFactory(reg);
        Session ss = sfa.openSession();
        Transaction tx = ss.beginTransaction();
        ss.save(allUsers);
        tx.commit();
        ss.close();
        sfa.close();
    }


    /**
     * Method responsible for pulling data to database
     * to the CAPTAINS table
     *
     * @param cap
     */
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


}
