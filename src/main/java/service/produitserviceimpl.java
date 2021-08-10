package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.produit;
import reposotory.ProductRepository;

@Service
public class produitserviceimpl implements IProductService {

	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public produit addProduct(produit p) {
		return productRepository.save(p);
	}
	
	@Override
	public produit editProduct(produit p) {
		produit product=productRepository.findById(p.getId_produit()).get();
		product.setTitle(p.getTitle());
		product.setPrice(p.getPrice());
		product.setQuantity(p.getQuantity());
		return productRepository.save(p);
	}
	
	@Override 
	public void deleteProduct (Long idProduct) {
		Optional <produit> product=productRepository.findById(idProduct);
		if (product.isPresent()) {
			productRepository.deleteById(idProduct);
		}else {
			System.out.println("No produit existe par id");
	
		}
	}
	
	
	@Override
	public List<produit> retrieveAll(){
		return productRepository.findAll();
	}
}
