package javacamp.northwind.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

	
}
