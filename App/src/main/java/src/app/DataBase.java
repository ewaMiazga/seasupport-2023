package src.app;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import src.logic.AdminPortIntermediaryEntity;
import src.logic.AllUsersEntity;
import src.logic.CaptainsEntity;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.criteria.*;
import org.hibernate.cfg.Configuration;
import src.logic.PortsEntity;

import java.util.List;

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

    private static Configuration configuration;

    private static StandardServiceRegistry serviceRegistry;

    private static SessionFactory sessionFactory;

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
        configuration = new Configuration().configure();
        configuration.addAnnotatedClass(CaptainsEntity.class);
        configuration.addAnnotatedClass(AllUsersEntity.class);
        configuration.addAnnotatedClass(PortsEntity.class);
//        configuration.addAnnotatedClass(AdminPortIntermediaryEntity.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    }

    public static void disableConnection()
    {
        sessionFactory.close();
//        StandardServiceRegistryBuilder.destroy(sessionFactory.getSessionFactoryOptions().getServiceRegistry());
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
        Session ss = sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
        PortsEntity portsEntity = ss.get(PortsEntity.class, portId);
        tx.commit();
        ss.close();
        return portsEntity;
    }

    public List<PortsEntity> getPorts(){
        Session ss = sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
        List<PortsEntity> ports = ss.createNativeQuery("Select * from PORTS", PortsEntity.class).getResultList();
        //List<PortsEntity> ports = ss.createQuery("FROM PORTS").getResultList();
        tx.commit();
        ss.close();
        return ports;
    }
    /**
     *  Method responsible for pulling data to database
     *  to the PORTS table
     *
     * @param portsEntity
     */
    public void addPort(PortsEntity portsEntity)
    {
        Session ss = sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
        ss.save(portsEntity);
        tx.commit();
        ss.close();
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
        Session ss = sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
        AllUsersEntity allUsersEntity = ss.get(AllUsersEntity.class, login);
        tx.commit();
        ss.close();
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
        Session ss = sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
        ss.persist(allUsers);
        tx.commit();
        ss.close();
    }


    /**
     * Method responsible for pulling data to database
     * to the CAPTAINS table
     *
     * @param cap
     */

    public void addCaptain(CaptainsEntity cap)
    {
        Session ss = sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
        ss.save(cap);
        tx.commit();
        ss.close();
    }
}
