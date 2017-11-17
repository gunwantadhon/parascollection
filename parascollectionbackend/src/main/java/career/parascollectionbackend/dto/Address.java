package career.parascollectionbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Address implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

@ManyToOne
private User user;

@Column(name="address_line_one")
@NotBlank(message="please enter address line one")
private String addressLineOne;




@Column(name="address_line_two")
@NotBlank(message="please enter address line two")
private String addressLineTwo;

@NotBlank(message="please enter city name")
private String city;
	
public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}

@NotBlank(message="plaese enter state name")
private String state;

@NotBlank(message="please enter country name")
private String country;


@Column(name="postal_code")
@NotBlank(message="please enter postal code")
private String postalCode;

@Column(name="is_shipping")
private boolean shipping;

@Column(name="is_billing")
private boolean billing;



@Override
public String toString() {
	return "Address [id=" + id + ", user=" + user + ", addressLineOne=" + addressLineOne + ", addressLineTwo="
			+ addressLineTwo + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode="
			+ postalCode + ", shipping=" + shipping + ", billing=" + billing + "]";
}


public Address() {
	// TODO Auto-generated constructor stub
}








public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}


public String getAddressLineOne() {
	return addressLineOne;
}

public void setAddressLineOne(String addressLineOne) {
	this.addressLineOne = addressLineOne;
}

public String getAddressLineTwo() {
	return addressLineTwo;
}

public void setAddressLineTwo(String addressLineTwo) {
	this.addressLineTwo = addressLineTwo;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getPostalCode() {
	return postalCode;
}

public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}

public boolean isShipping() {
	return shipping;
}

public void setShipping(boolean shipping) {
	this.shipping = shipping;
}

public boolean isBilling() {
	return billing;
}

public void setBilling(boolean billing) {
	this.billing = billing;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}







}
