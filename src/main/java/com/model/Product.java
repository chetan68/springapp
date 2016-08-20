package com.model;

import java.io.BufferedOutputStream;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Entity
@Table(name="Product")
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Length(min=3, max=20)
	@NotEmpty(message="Product Name should not be empty")
	private String PrdName;
	
	@NotNull(message="Product Price should not be null")
	private float Price;
	private String Category;
	private int Warranty;
	private float Discount;
	private String ImgPath;
	
	transient private MultipartFile mpartFile;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getWarranty() {
		return Warranty;
	}
	public void setWarranty(int warranty) {
		Warranty = warranty;
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
	public MultipartFile getMpartFile() {
		return mpartFile;
	}
	public void setMpartFile(MultipartFile mpartFile) {
		this.mpartFile = mpartFile;
	}
	
	public String getFilePath(String path1,String contextPath,String category)
	{
		String fileName=null;
		if(!mpartFile.isEmpty())
		{
			try
			{
				fileName=mpartFile.getOriginalFilename().toString();
				System.out.println("FileName: "+fileName);
				byte[] bytes = mpartFile.getBytes();
				String npath="",devicepath="";
				if(category.equals("camera"))
					devicepath="resources\\images\\cameras\\";
				else if(category.equals("ehdd"))
					devicepath="resources\\images\\ehdds\\";
				else if(category.equals("tablet"))
					devicepath="resources\\images\\tablets\\";
				
				npath=path1+devicepath+fileName;
				System.out.println("npath: "+npath);
				BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(npath)));
				//BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File("D:\\images\\"+fileName)));
				buffStream.write(bytes);
	            buffStream.close();
	            String dbfilename=contextPath+"/"+devicepath+fileName;
	            //String dbfilename=npath;
	            setImgPath(dbfilename);
	            return dbfilename;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				return "fail";
			}
		}
		else
		{
			System.out.println("error: mpartFile is Empty");
			return "fail";
		}
	}

}


