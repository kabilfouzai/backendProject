package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.produit;
import service.IProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductRestController {
	
	@Autowired
	IProductService productService;
	
	//http://localhost/8081/all-products
	@GetMapping("/all-Products")
	@ResponseBody
	public List <produit> getProducts(){
		return productService.retrieveAll();
	}
	//http://localhost/3306/add-Product
	@GetMapping("/add-Product")
	@ResponseBody
	public produit addProduct(@RequestBody produit p){
		return productService.addProduct(p);
	}
	//http://localhost/3306/edit-Product
		@GetMapping("/edit-Product")
		@ResponseBody
		public produit editProduct(@RequestBody produit p){
			return productService.editProduct(p);
		}
		//http://localhost/3306/edit-Product
				@GetMapping("/delete-Product/{idProduct}")
				@ResponseBody
				public void deleteProduct(@PathVariable("idProduct") Long id){
					 productService.deleteProduct(id);
				}
				


}
