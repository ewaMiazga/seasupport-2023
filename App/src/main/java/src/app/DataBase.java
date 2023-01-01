package src.app;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.sql.internal.SQLQueryParser;
import src.logic.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.sql.Date;
import java.util.List;


/**
 * Class responsible for connecting to database -
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
        configuration.addAnnotatedClass(PriceListEntity.class);
        configuration.addAnnotatedClass(ShipOwnersEntity.class);
        configuration.addAnnotatedClass(ShipsEntity.class);
        configuration.addAnnotatedClass(VisitsEntity.class);
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
        ss.persist(portsEntity);
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
     * Fetch visit with given user and data_begin
     *
     * @param user
     * @param dateBegin
     * @return VisitsEntity
     */
    public VisitsEntity getVisit(AllUsersEntity user, Date dateBegin)
    {
        Session ss = sessionFactory.openSession();
        ss.beginTransaction();

        Query query = ss.createQuery("FROM VisitsEntity VE WHERE " +
                                     "VE.dateBegin = :dateBegin and allUsersEntity = :user");
        query.setParameter("dataBegin", dateBegin);
        query.setParameter("user", user);
        VisitsEntity visit = (VisitsEntity)query.uniqueResult();
        ss.getTransaction().commit();
        ss.close();
        return visit;
    }

    /**
     * Gets a list of VistsEntities from a port after given date
     *
     * @param port
     * @param dateBegin
     * @return List<VisitsEntity>
     */
    public List<VisitsEntity> getVisitFromPort(PortsEntity port, Date dateBegin)
    {
        Session ss = sessionFactory.openSession();
        ss.beginTransaction();

        Query query = ss.createQuery("FROM VisitsEntity VE WHERE portsEntity = :port " +
                                     "and VE.dateBegin > :dateBegin");
        query.setParameter("port", port);
        query.setParameter("dateBegin", dateBegin);
        List<VisitsEntity> visits = query.list();
        ss.getTransaction().commit();
        ss.close();
        return visits;
    }

    /**
     * Gets active visit for user with given login
     *
     * @param userLogin
     * @return VisitsEntity
     */
    public VisitsEntity getActiveVisit(String userLogin)
    {
        Session ss = sessionFactory.openSession();
        ss.beginTransaction();
        String query = "select get_active_visit(?) from visits";
        Query q = ss.createNativeQuery(query, VisitsEntity.class);
        q.setParameter(1, userLogin);
        VisitsEntity visit = (VisitsEntity) q.uniqueResult();
        ss.getTransaction().commit();
        ss.close();
        return visit;
    }

    /**
     * Fetches all ports in the database
     * @return List<PortsEntities>
     */
    public List<PortsEntity> getAllPorts()
    {
        Session ss = sessionFactory.openSession();
        ss.beginTransaction();

        Query query = ss.createQuery("from PortsEntity");
        List<PortsEntity> ports = query.list();
        ss.getTransaction().commit();
        ss.close();
        return ports;
    }

    /**
     * Adds ShipsEntity to the database
     *
     * @param ship
     */
    public void addShip(ShipsEntity ship)
    {
        Session ss = sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
        ss.persist(ship.getShipOwnersEntity());
        ss.persist(ship);
        tx.commit();
        ss.close();
    }

//    /**
//     * Adds ShipsEntity to the database and sets its shipowner to
//     * that one with given pesel
//     *
//     * @param ship
//     */
//    public void addShip(ShipsEntity ship, String pesel)
//    {
//        Session ss = sessionFactory.openSession();
//        Transaction tx = ss.beginTransaction();
//        Query query = ss.createQuery("from ShipOwnersEntity where pesel = :pesel");
//        query.setParameter("pesel", pesel);
//        ShipOwnersEntity shipOwner = (ShipOwnersEntity) query.uniqueResult();
//        ship.setShipOwnersEntity(shipOwner);
//        ss.save(ship);
//        tx.commit();
//        ss.close();
//    }

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


//    /**
//     * Method responsible for pulling data to database
//     * to the CAPTAINS table
//     *
//     * @param cap
//     */
//
//    public void addCaptain(CaptainsEntity cap)
//    {
//        Session ss = sessionFactory.openSession();
//        Transaction tx = ss.beginTransaction();
//        ss.save(cap);
//        tx.commit();
//        ss.close();
//    }

    /**
     * Adds new visit to the database
     * @param visit
     */
    public void addVisit(VisitsEntity visit)
    {
        Session ss = sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
        ss.persist(visit);
        tx.commit();
        ss.close();
    }


}
