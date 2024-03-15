package jp.ac.fgrope.Memo.model;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 
@Data
@Entity
@Table(name = "authorities")
public class AuthoritiesBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
 
	@Column(length = 64, nullable = false)
	private String username;
	
	
	@Column(length = 64, nullable = false)
	private String authority;

 
}
