package javacamp.northwind.business.abstracts;

import java.util.List;

import javacamp.northwind.core.utilities.results.DataResult;
import javacamp.northwind.core.utilities.results.Result;
import javacamp.northwind.entities.concretes.Product;

public interface ProductService {

	DataResult<List<Product>> getAll();
	Result add(Product product);
}
