package com.konesfind.api.classes;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "money")
@EntityListeners(AuditingEntityListener.class)
class Money {

	enum Currency {CAD, EUR, USD,ILS }

	@DecimalMin(value="0",inclusive=false)
	@Digits(integer=1000000000,fraction=2)
	
	@Id
	@GeneratedValue
	private int id;
	
	private BigDecimal amount;

	private Currency currency;

	Money(BigDecimal amount){
		this(Currency.ILS, amount);
	}

	Money(Currency currency, BigDecimal amount){
		this.currency = currency;
		this.amount = amount;
	}
}
