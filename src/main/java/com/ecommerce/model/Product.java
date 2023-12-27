package com.ecommerce.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "street_address")
	private String streetAddress;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "discounted_price")
	private float discountedPrice;
	
	@Column(name = "discount_percent")
	private float discountPercent;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "brand")
	private float brand;
	
	@Embedded
	@ElementCollection
	@Column(name = "sizes")
	private Set<Size> sizes = new HashSet<>();
	
	@Column(name = "image_url")
	private float imageUrl;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Rating> rating = new ArrayList<>();
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Review> review = new ArrayList<>();
	
	@Column(name = "num_rating")
	private int numRating;
	
	public Product() {
		
	}

	public Product(Long id, String title, String description, String streetAddress, float price, float discountedPrice,
			float discountPercent, int quantity, float brand, Set<Size> sizes, float imageUrl, List<Rating> rating,
			List<Review> review, int numRating) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.streetAddress = streetAddress;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.discountPercent = discountPercent;
		this.quantity = quantity;
		this.brand = brand;
		this.sizes = sizes;
		this.imageUrl = imageUrl;
		this.rating = rating;
		this.review = review;
		this.numRating = numRating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(float discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public float getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getBrand() {
		return brand;
	}

	public void setBrand(float brand) {
		this.brand = brand;
	}

	public Set<Size> getSizes() {
		return sizes;
	}

	public void setSizes(Set<Size> sizes) {
		this.sizes = sizes;
	}

	public float getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(float imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public int getNumRating() {
		return numRating;
	}

	public void setNumRating(int numRating) {
		this.numRating = numRating;
	}
	
	

}
