package com.spring.orm.springORM;

import com.spring.orm.dao.StudentDao; 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/orm/springORM/config.xml");
        
        StudentDao sdao= context.getBean("studentDao",StudentDao.class);
        
        Student st = new Student(101,"Saroj Thakur", "Patna Bihar");
        
       System.out.println(sdao.insert(st));
        
    }
}
