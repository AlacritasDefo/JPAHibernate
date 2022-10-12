import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import java.util.*;


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
            //Get list
            List<Employee> employeeList = session.createQuery("From Employee").list();
            for(Employee e : employeeList){
                System.out.println(e);
            }
            //Get Updated
            Employee getEemployee2 = session.get(Employee.class, 1);
            System.out.println(getEemployee2);
            //Delete
            session.beginTransaction();
            Employee deleteEmployee = session.get(Employee.class, 1);
            session.delete(deleteEmployee);
            session.getTransaction().commit();
            Employee deletedEmp = session.get(Employee.class, 1);
            System.out.println(deletedEmp);
            List<Employee> employeeList2 = session.createQuery("From Employee").list();
            for(Employee e : employeeList2){
                System.out.println(e);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
