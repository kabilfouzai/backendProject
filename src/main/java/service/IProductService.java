package service;

import java.util.List;

import model.produit;

public interface IProductService {

	produit addProduct(produit p);

	produit editProduct(produit p);

	void deleteProduct(Long idProduct);

	List<produit> retrieveAll();

}
