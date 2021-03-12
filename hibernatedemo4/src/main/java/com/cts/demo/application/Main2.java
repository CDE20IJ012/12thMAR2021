package com.cts.demo.application;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.cts.demo.domain.Employee;

public class Main2 {

	public static void main(String[] args) {
		 // TODO Auto-generated method stub
Scanner scan=new Scanner(System.in);
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

	
SessionFactory sessionFactory=null;
Session session=null;	
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
	  	  // String hql = "FROM Employee";
	  	   
     	  String hql = "FROM Employee E";
	  	 // String hql = "FROM Employee E WHERE E.id = 1"; 
	  	 //String hql = "FROM Employee E WHERE E.id = :employee_id";
	  	   Query query = session.createQuery(hql);
	  	  //System.out.println("Enter the id");
	  	  //int id=scan.nextInt();
	  	 //query.setParameter("employee_id",id);
	     	List<Employee> results = (List<Employee>) query.list();
	  	    for(Employee emp  : results) 
	  	    {
	  	    	System.out.format("%5d%-20s%6d\n",emp.getId(),emp.getName(),emp.getBasic());
	  	    	//System.out.format("%-20s\n",name);
	  	    }
	      	
	  	   
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