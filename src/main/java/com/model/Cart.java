package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Cart")
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int CartId;
	private int RegisterId;
	private int ProductId;
	private String PrdName;
	private float Price;
	private float Discount;
	private int Warranty;
	private String ImgPath;
	@NotNull(message="Quantity cannot be empty")
	private float Quantity;
	private float CartAmount;
	private String CartStatus;

	public int getCartId() {
		return CartId;
	}

	public void setCartId(int cartId) {
		CartId = cartId;
	}

	public int getRegisterId() {
		return RegisterId;
	}

	public void setRegisterId(int registerId) {
		RegisterId = registerId;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public String getPrdName() {
		return PrdName;
	}

	public void setPrdName(String prdName) {
		PrdName = prdName;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public float getDiscount() {
		return Discount;
	}

	public void setDiscount(float discount) {
		Discount = discount;
	}

	public String getImgPath() {
		return ImgPath;
	}

	public void setImgPath(String imgPath) {
		ImgPath = imgPath;
	}

	public float getQuantity() {
		return Quantity;
	}

	public void setQuantity(float quantity) {
		Quantity = quantity;
	}

	public int getWarranty() {
		return Warranty;
	}

	public void setWarranty(int warranty) {
		Warranty = warranty;
	}

	public float getCartAmount() {
		return CartAmount;
	}

	public void setCartAmount(float cartAmount) {
		CartAmount = cartAmount;
	}

	public String getCartStatus() {
		return CartStatus;
	}

	public void setCartStatus(String cartStatus) {
		CartStatus = cartStatus;
	}
	
	

}

