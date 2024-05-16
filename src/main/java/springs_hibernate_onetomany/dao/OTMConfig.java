package springs_hibernate_onetomany.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"springs_hibernate_onetomany.dto","springs_hibernate_onetomany.dao"})
public class OTMConfig {
	
	@Bean
	public EntityManager getManager()
	{
		return Persistence.createEntityManagerFactory("kishor").createEntityManager();
	}

}
