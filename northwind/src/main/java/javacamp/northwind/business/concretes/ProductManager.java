package javacamp.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.northwind.business.abstracts.ProductService;
import javacamp.northwind.core.utilities.results.DataResult;
import javacamp.northwind.core.utilities.results.Result;
import javacamp.northwind.core.utilities.results.SuccessDataResult;
import javacamp.northwind.core.utilities.results.SuccessResult;
import javacamp.northwind.dataAccess.abstracts.ProductDao;
import javacamp.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService{

	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data Listelendi");
				
	}

	@Override
	public Result add(Product product) {

		this.productDao.save(product);
		return new SuccessResult("ürün Eklendi");
	}

}
