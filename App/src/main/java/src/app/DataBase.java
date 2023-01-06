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
import src.logic.*;

import java.sql.Date;
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
        ss.persist(cap);
        tx.commit();
        ss.close();
    }

    /**
     * Get PriceListEntity from database
     *
     * @param listId
     */

    public PriceListEntity getPriceList(int listId){
        Session ss = sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
        //String id = Integer.toString(listId);
        PriceListEntity priceList = ss.get(PriceListEntity.class, listId);
        tx.commit();
        ss.close();
        return priceList;
    }

    /**
     * Get CaptainsEntity from database
     *
     * @param id
     */

    public CaptainsEntity getCaptain(int id){
        Session ss = sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
        CaptainsEntity captian = ss.get(CaptainsEntity.class, id);
        tx.commit();
        ss.close();
        return captian;
    }

    /**
     * Get ShipsEntity from database
     *
     * @param callSign
     */

    public ShipsEntity getShip(String callSign){
        Session ss = sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
        ShipsEntity s = ss.get(ShipsEntity.class, callSign);
        tx.commit();
        ss.close();
        return s;
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
        ss.persist(ship);
        tx.commit();
        ss.close();
    }


    public ShipOwnersEntity getOwner(String id){
        Session ss = sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
        ShipOwnersEntity s = ss.get(ShipOwnersEntity.class, id);
        tx.commit();
        ss.close();
        return s;
    }

    public void addOwner(ShipOwnersEntity owner){
        Session ss = sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
        ss.persist(owner);
        tx.commit();
        ss.close();
    }

    /**
     * Gets a list of VistsEntities from a port after given date
     *
     * @param port
     * @param dateBegin
     * @return List<VisitsEntity>
     */
    public List<VisitsEntity> getVisitFromPort(PortsEntity port, Date dateBegin, Date dateEnd)
    {
        Session ss = sessionFactory.openSession();
        ss.beginTransaction();

        Query query = ss.createQuery("FROM VisitsEntity VE WHERE portsEntity = :port " +
                "and VE.dateBegin >= :dateBegin" + "and VE.dateEnd =< :dateEnd");
        query.setParameter("port", port);
        query.setParameter("dateBegin", dateBegin);
        query.setParameter("dateEnd", dateEnd);
        List<VisitsEntity> visits = query.list();
        ss.getTransaction().commit();
        ss.close();
        return visits;
    }

}
