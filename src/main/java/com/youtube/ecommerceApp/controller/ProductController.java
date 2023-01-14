package com.youtube.ecommerceApp.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.youtube.ecommerceApp.entity.ImageModel;
import com.youtube.ecommerceApp.entity.Product;
import com.youtube.ecommerceApp.service.ProductService;

@RestController
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	
	@PreAuthorize("hasRole('Admin')")
	@PostMapping(value = {"/addNewProduct"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Product addNewProduct(@RequestPart("product") Product product,
			@RequestPart("imageFile") MultipartFile[] file)
	{
		
		
		try {
		Set<ImageModel>  imageModels=	uploadImage(file);
		product.setImageModels(imageModels);
		return productService.addNewProduct(product);
		} catch (IOException e) {
		
			e.printStackTrace();
			return null;
		}
		
		
		
//		return productService.addNewProduct(product);
	}
	
	public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException
	{
		Set<ImageModel> imageModels=new HashSet<>();
		
		for(MultipartFile multipartFile:multipartFiles)
		{
			ImageModel imageModel=new ImageModel(
					
					multipartFile.getOriginalFilename(),
					multipartFile.getContentType(),
					multipartFile.getBytes()
					);
			
			imageModels.add(imageModel);
		}
		return imageModels;
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@DeleteMapping("/deleteProductDetails/{productId}")
	public void deleteProductDetails(@PathVariable("productId") Integer poductId)
	
	{
	   productService.deleteProductDetails(poductId);	
	}
	
}
