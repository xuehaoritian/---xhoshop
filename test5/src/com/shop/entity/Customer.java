package com.shop.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="CUS")
public class Customer extends User {
	
}
