package com.konesfind.api.classes;

import java.util.Currency;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

//import org.hibernate.validator.constraints.Currency;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "auction")
@EntityListeners(AuditingEntityListener.class)
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    
    @Column(name = "auction_name", nullable = false)
    private String auctionName;
    
    @Column(name = "product_type", nullable = false)
    private String productType;
    
    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private Date createdAt;
    
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;
    
    @Column(name = "updated_by", nullable = false)
    @LastModifiedBy
    private String updatedBy;
    
    @Column(name = "closing_at", nullable = false)
    private Date closingAt;

	@Column(name = "base_price", nullable = false)
    private String BasePrice;
    
    @Column(name = "current_price", nullable = false)
    private String CurrentPrice;
    
    Auction(){}
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuctionName() {
		return auctionName;
	}

	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getClosingAt() {
		return closingAt;
	}

	public void setClosingAt(Date closingAt) {
		this.closingAt = closingAt;
	}

    public String getBasePrice() {
		return BasePrice;
	}

	public void setBasePrice(String basePrice) {
		BasePrice = basePrice;
	}

	public String getCurrentPrice() {
		return CurrentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		CurrentPrice = currentPrice;
	}
    
}
    //תאריך פרסום, תאריך סגירה, פרטי המוצר, מחיר התחלתי, הצעה מקסימלית ידועה
