package com.cts.demo.application;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import com.cts.demo.domain.Employee;

public class MainCriteria {

	public static void main(String[] args) {
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
				  Criteria cr = session.createCriteria(Employee.class);
				  cr.add(Restrictions.eq("basic", 12000));
				  List<Employee> results = (List<Employee>)cr.list();
				  for(Employee emp : results)
				  {
					  System.out.println(emp.getId()+emp.getName()+emp.getBasic());
				  }
				  
				
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