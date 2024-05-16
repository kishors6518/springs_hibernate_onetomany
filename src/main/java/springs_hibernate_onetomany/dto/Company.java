package springs_hibernate_onetomany.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Component
@Data
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Value("Tesla")
	private String name;
	@Value("Benglore")
	private String location;
	@OneToMany(cascade = CascadeType.ALL)
	@Autowired
	List<Employee>list;
	

}
