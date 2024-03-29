package com.ecommerce.ecommercespringboot.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class PaymentInformation {
	
	@Column(name = "card_holder_name")
	private String cardHolderName;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	
	@Column(name = "expiration_date")
	private LocalDateTime expirationDate;
	
	
	@Column(name = "cvv")
	private String cvv;
	
	

}
