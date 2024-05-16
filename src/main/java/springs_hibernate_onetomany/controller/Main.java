package springs_hibernate_onetomany.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springs_hibernate_onetomany.dao.CompanyDao;
import springs_hibernate_onetomany.dao.OTMConfig;
import springs_hibernate_onetomany.dto.Company;
import springs_hibernate_onetomany.dto.Employee;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(OTMConfig.class);
		Employee e1=context.getBean("employee",Employee.class);
		Company c1=context.getBean("company",Company.class);
		CompanyDao dao=(CompanyDao)context.getBean("companyDao");
		//dao.saveEmployee(c1);
		//dao.getCompany(3);
		//dao.updateBoth(9, c1);
		dao.deleteCompany(11);
		
	}

}
