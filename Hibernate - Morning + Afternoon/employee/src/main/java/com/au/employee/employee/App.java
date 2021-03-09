package com.au.employee.employee;

import com.au.employee.employee.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Scanner;

public class App {

    private static Session session = Confi.getSession();;
    private static Configuration configuration = new Configuration();
    private static SessionFactory factory;
    private static Transaction transaction = session.beginTransaction();;

    private static <T> List<T> loadAllEmployeeData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> listEmployees = session.createQuery(criteria).getResultList();
        return listEmployees;
    }

    private static void chooseChoice(){
        System.out.print("\n1. Create Employee\n" +
                "2. Update all Employees\n" +
                "3. Update Employee by Id\n" +
                "4. Delete Employee - Warning: this cannot be recovered\n" +
                "5. Get all Employees\n" +
                "6. Get Employee by Id\n" +
                "7. Exit\n" +
                "Enter your choice (1-7): ");
    }

    private static void createOrUpdateEmployee(Employee employee, Scanner sc){
        System.out.print("Enter Employee's First Name: ");
        String firstName = sc.next();
        System.out.print("\nEnter Employee's Last Name: ");
        String lastName = sc.next();
        System.out.print("\nEnter Employee's DOB: ");
        String dob = sc.next();
        System.out.print("\nEnter Employee's Age: ");
        int age = sc.nextInt();
        System.out.print("\nEnter Employee's Designation: ");
        String designation = sc.next(); 
        System.out.print("\nEnter Employee's Salary: ");
        long salary = sc.nextLong();

        if(firstName.length() != 0){
            employee.setfirstName(firstName);
        }
        if(lastName.length() != 0) {
            employee.setlastName(lastName);
        }
        if (dob.length() != 0) {
            employee.setDob(dob);
        }
        if(String.valueOf(age).length() > 0 && String.valueOf(age).length() <= 2) {
            employee.setAge(age);
        }
        if(designation.length() != 0) {
            employee.setDesignation(designation);
        }
        if(String.valueOf(salary).length() > 0) {
            employee.setSalary(salary);
        }
        session.save(employee);
    }

    public static void main(String args[]) {
        configuration.configure("hibernate.cfg.xml");
        factory = configuration.buildSessionFactory();

        Scanner sc = new Scanner(System.in);

        while (true) {
            chooseChoice();
            int choice = sc.nextInt();
            System.out.println();
            switch(choice) {
            case 1: System.out.println("Please Enter Employee Details:- ");
                    Employee employee = new Employee();
                    createOrUpdateEmployee(employee, sc);
                    transaction.commit();
                    System.out.println("\n Employee has been successfully created");
                    break;
                    
            case 2: System.out.println("Enter Ids of Employee to Update Details:- ");
            		while(true) {
            				System.out.print("\n Enter Employee Id: ");
            				int employeeId = sc.nextInt();
            				try{
            					employee = session.load(Employee.class, employeeId);
            					System.out.println();
            					createOrUpdateEmployee(employee, sc);
            					transaction.commit();
            					System.out.println("\n Successfully Updated Employee Details");
            				} catch(NullPointerException e) {
            						System.out.println("\n No Such Employee Found");
            				}
            				System.out.print("\nPress Y to continue and N to break: ");
            				char ch = sc.next().charAt(0);
            				if(ch == 'N' || ch == 'n') break;
            	    }
            		break;
            		
            case 3: System.out.print("Enter Id of Employee to Update Details: ");
                    int employeeId = sc.nextInt();
                    try {
                        employee = session.load(Employee.class, employeeId);
                        createOrUpdateEmployee(employee, sc);
                        transaction.commit();
                        System.out.println("\n Successfully Updated Employee Details");
                    }
                    catch(NullPointerException e){
                           System.out.println("\n No Such Employee Found");
                    }
                    break;
                    
            case 4: System.out.print("Enter Id of employee to Deleting: ");
                    employeeId = sc.nextInt();
            		try {
            			employee = session.get(Employee.class, employeeId);
            			if(employee != null) {
            					System.out.print("\nAre You Sure You Want To Delete Employee ? You Won't be able to revert your changes later. Press Y / N: ");
            					char ch = sc.next().charAt(0);
            					if (ch == 'Y' || ch == 'y') {
            						session.delete(employee);
            						transaction.commit();
            						System.out.println("\n Successfully Deleted Employee");
                                } else {
                                	System.out.println("\nProcess Terminated by user");
                                }
            			}
            			else{
            				System.out.println("No Such Employee Found");
            			}
            		}
            		catch(NullPointerException e){
            			System.out.println("No Such Employee Found");
            		}
            		break;
            		
            case 5: try{
                		System.out.println(loadAllEmployeeData(Employee.class, session));
            		}catch(NullPointerException e){
            			System.out.println("Table Not Yet Registered");
            		}
            		break;
            		
            case 6: System.out.print("Enter id of employee to Fetch Details: ");
            		employeeId = sc.nextInt();
            		try {
            			employee = session.load(Employee.class, employeeId);
            			System.out.println("\n" + employee.toString());
            		}
            		catch (NullPointerException e){
            			System.out.println("#nNo Such Employee Found");
            		}
            		break;
            		
            case 7: System.exit(0);
                    break;
                    
            default: System.out.println("\nEnter a Correct Choice Please");
                     break;
            }
        }
    }
}