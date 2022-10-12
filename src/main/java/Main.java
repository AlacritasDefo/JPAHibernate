import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;



public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            //Create
            Employee employee = new Employee();
            employee.setName("Arek");
            employee.setEmail("arek@gmail.com");
            session.save(employee);
            session.getTransaction().commit();
            //Get
            session.beginTransaction();
            Employee getEemployee = session.get(Employee.class, 1);
            System.out.println(getEemployee);
            //Update
            Employee updateEmp = session.get(Employee.class, 1);
            updateEmp.setName("newName");
            session.save(updateEmp);
            session.getTransaction().commit();
            //Get Updated
            Employee getEemployee2 = session.get(Employee.class, 1);
            System.out.println(getEemployee2);
            //Delete
            Employee deleteEmployee = session.get(Employee.class, 1);
            session.delete(deleteEmployee);

            Employee deletedEmp = session.get(Employee.class, 1);
            System.out.println(deletedEmp);


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
