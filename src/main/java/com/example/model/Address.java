package com.example.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

@Embeddable
public class Address
{
	  
	   int zipcode;
	   String city;
	   String state;
	   
   
		public int getZipcode() {
			return zipcode;
		}
		public void setZipcode(int zipcode) {
			this.zipcode = zipcode;
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
   
   
   
}
