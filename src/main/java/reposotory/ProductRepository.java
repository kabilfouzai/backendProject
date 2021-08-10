package reposotory;

import org.springframework.data.jpa.repository.JpaRepository;

import model.produit;

public interface ProductRepository extends JpaRepository<produit, Long> {

}
