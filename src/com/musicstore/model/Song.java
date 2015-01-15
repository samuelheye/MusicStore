package com.musicstore.model;
 
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
 
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="Song", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "artist"}))
public class Song {
 
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty(message = "The song name can not be empty")
    private String name;    
    @NotEmpty(message = "The artist name can not be empty")
    private String artist;    
    @NotEmpty(message = "The album name can not be empty")
    private String album;
    @NotNull(message = "The quanity can not be empty")
    @Min(value= 0, message = "Quantity in stock must be positive number")
    private int quantityInStock;
    @NotNull(message = "The unit price can not be empty")
    @Min(value= 0, message = "The unit price must be a positive number")
    @NumberFormat(style=Style.CURRENCY)
    private BigDecimal unitPrice;
    @NotEmpty(message = "The song category can not be empty")
    private String category;    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}	
	
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", artist=" + artist
				+ ", album=" + album + ", quantityInStock=" + quantityInStock
				+ ", unitPrice=" + unitPrice + ", category=" + category
				 + "]";
	}
    
   
     
    
}