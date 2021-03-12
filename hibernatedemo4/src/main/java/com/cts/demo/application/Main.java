package com.cts.demo.application;

import java.util.Properties;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.cts.demo.domain.Employee;

public class Main {

	public static void main(String[] args) {
		 // TODO Auto-generated method stub

Configuration configuration = new Configuration(); 
Properties properties=new Properties();
properties.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
properties.put(Environment.URL, "jdbc:mysql://localhost:3306/empDB");
properties.put(Environment.USER,"root");
properties.put(Environment.PASS, "password@123");
properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
properties.put(Environment.SHOW_SQL, "true");
properties.put(Environment.HBM2DDL_AUTO, "update");
configuration.setProperties(properties);
// Is keeping the info relate to the hibernate configuration
SessionFactory sessionFactory=null;
Session session=null;
Scanner scan=new Scanner(System.in);
try
		{
		//configuration.configure("hibernate.cfg.xml");
// It is receiving the configuration information from hibernate.cfg.xml
		configuration.addAnnotatedClass(Employee.class);
		ServiceRegistry  serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	
		  session=sessionFactory.openSession();
		 Transaction transaction=session.beginTransaction();
	  	   Employee employee=new Employee();
	       System.out.println("Enter the name");
	       employee.setName(scan.next());
	       System.out.println("Enter the basic");
	       employee.setBasic(scan.nextInt());
	  	   session.save(employee);
          transaction.commit(); 
          
		}finally
		{
			      session.close();
				
				  if(!(sessionFactory.isClosed()))
				  { 
					  sessionFactory.close();
				  }
				 
		}

			
		}
		
		

}
