package com.spring.orm.springORM;

import com.spring.orm.dao.StudentDao;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	public static Student getStudentDetails() {
		Scanner scan = new Scanner(System.in);
		Student st = new Student();
		System.out.println("Enter Student Id:");
		st.setId(scan.nextInt());
		System.out.println("Enter Student Name:");
		st.setName(scan.next());
		System.out.println("Enter Student City:");
		st.setCity(scan.next());
		return st;		
	}
    public static void main( String[] args ) throws InterruptedException
    {
        ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/orm/springORM/config.xml");
        
        StudentDao sdao= context.getBean("studentDao",StudentDao.class);
        
        //Student st = new Student(101,"Saroj Thakur", "Patna Bihar");
        
       //System.out.println(sdao.insert(st));
        
//       List<Student> students= sdao.getStudents();
//       for(Student student:students) {
//    	   System.out.println(student);
//       }
       
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Starting the databse console for you, please wait...");
        Thread.sleep(1000);
       
       
        while(true) {
        	 System.out.println("Welcome to Spring Hibernate database..");
             System.out.println("Please select operations ypou want to perform:\n Press 1 for Insert \n Press 2 for Update \n Press 3 for select "
             		+ "\n Press 4 to select all students \n Press 5 for delete a student \n Press 6 to exit");
             
             Scanner sc = new Scanner(System.in);
             int choice= sc.nextInt();
             
             switch (choice) {
			case 1: sdao.insert(App.getStudentDetails());
			System.out.println("insert Done");
			System.out.println("---------------------------------------------------------------------------");
			Thread.sleep(1000);
				break;
				
			case 2: sdao.update(App.getStudentDetails());
			System.out.println("update Done");
			System.out.println("---------------------------------------------------------------------------");
			Thread.sleep(1000);
			break;
			case 3: System.out.println("Please enter Student id:");
			System.out.println(sdao.getStudent(sc.nextInt()));
			System.out.println("---------------------------------------------------------------------------");
			Thread.sleep(1000);
			break;
			case 4: 
				List<Student> students= sdao.getStudents();
		        for(Student student:students) {
		    	   System.out.println(student);
		       }
		        System.out.println("---------------------------------------------------------------------------");
		        Thread.sleep(1000);
			break;
			case 5: System.out.println("Please enter Student id:");
			sdao.delete(sc.nextInt());
			System.out.println("delete Done");
			System.out.println("---------------------------------------------------------------------------");
			Thread.sleep(1000);
			
			break;
			case 6: 
				System.out.println("Thanks For Using bye bye!!");
				System.exit(0);
			
			break;

			default:
				System.out.println("invalid Choice..Please Select again");
				break;
			}
             
        }
        
       
       
        
    }
}
