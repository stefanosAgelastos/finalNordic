package databaseConnection;

import model.Employee;
import model.Mechanic;
import model.Owner;
import model.SalesAssistant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by aSeddik on 13-May-17.
 */
public class Staff {

    List<Employee> staff= new ArrayList();

    //TODO this list should be loaded from the database, this is a temporary testing constructor
    public Staff() {
        this.staff.add(new SalesAssistant(1,"salesperson",1234));
        this.staff.add( new Owner(2,"owner", 1234));
        this.staff.add( new SalesAssistant(3,"salesperson2",1234));
        this.staff.add( new Mechanic(4, "mechanic", 1234));
    }

    public List getStaff() {
        return staff;
    }

    public void setStaff(List staff) {
        this.staff = staff;
    }

    public Employee signIn(String username, int password){
        Iterator iterator= staff.iterator();
        while(iterator.hasNext()){
            Employee employeeToCheck= (Employee) iterator.next();
            if(employeeToCheck.identify(username, password)){
                return employeeToCheck;
            }
        }
        return null;
    }
}
