package springs_hibernate_onetomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springs_hibernate_onetomany.dto.Company;
import springs_hibernate_onetomany.dto.Employee;

@Component
public class CompanyDao {
	
	@Autowired
	private EntityManager manager;
	
	public void saveEmployee(Company company)
	{
		EntityTransaction transaction=manager.getTransaction();
		List<Employee>list=company.getList();
		transaction.begin();
//		for (Employee employee : list) {
//			getManager().persist(employee);
//			System.out.println(employee);
//		}
		manager.persist(company);
		transaction.commit();	
	}
	public void getCompany(int id)
	{
		EntityTransaction transaction=manager.getTransaction();
		Company company=manager.find(Company.class,id);
		if(company!=null)
		{
			System.out.println(company);
		}
		else
		{
			System.out.println("Company not found");
		}
	}
	public void deleteCompany(int id)
	{
		EntityTransaction transaction=manager.getTransaction();
		Company company=manager.find(Company.class,id);
		if(company!=null)
		{
			List<Employee>list=company.getList();
			transaction.begin();
//			for (Employee employee : list) {
//				manager.remove(employee);
//			}
			manager.remove(company);
			transaction.commit();	
		}
		else
		{
			System.out.println("Company not found");
		}
	}
	public void updateCompany(int id,Company company)
	{
		EntityTransaction transaction=manager.getTransaction();
		Company company2=manager.find(Company.class,id);
		if(company2!=null)
		{
			company.setId(id);
			company.setList(company2.getList());
			
			transaction.begin();
			manager.merge(company);
			transaction.commit();
		}
		else
		{
			System.out.println("No company found");
		}

	}
	public void updateBoth(int id,Company company)
	{
		EntityTransaction transaction=manager.getTransaction();
		Company company2=manager.find(Company.class,id);
		if(company2!=null)
		{
			company.setId(id);
			for (int i = 0; i < company2.getList().size(); i++) {
				company.getList().get(i).setId(company2.getList().get(i).getId());			
			}
			transaction.begin();
			for (Employee employee : company.getList()) {
				manager.merge(employee);
			}
			manager.merge(company);
			transaction.commit();
		}
		else
		{
			System.out.println("No company found");
		}

	}

}
