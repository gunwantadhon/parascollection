package career.parascollectionbackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="user_detail")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	//@NotBlank(message="please enter first name")
	private String firstname;
	
	
	public String getFirstname() {
		return firstname;
	}




	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Column(name="last_name")
	@NotBlank(message="please enter last name")
	private String lastname;
	
	@NotBlank(message="please enter email")
	private String email; 
	
	@Column(name="contact_name")
	@NotBlank(message="please enter contact number")
	private String contactNumber; 
	
	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}




	public void setCart(Cart cart) {
		this.cart = cart;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", enabled="
				+ enabled + "]";
	}
	private String role;
	private String password;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	private boolean enabled=true;
	
	
	
	
	
	
	
	
}
