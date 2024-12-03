package com.prodCat.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodCat.Entity.ProductEntity;
import com.prodCat.Repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public ProductEntity saveProduct(ProductEntity product) {
		return productRepo.save(product);
	}

	@Override
	public List<ProductEntity> getAllProduct() {
		return (List<ProductEntity>) productRepo.findAll();
	}

	@Override
	public void delectProductById(Integer productId) {
		productRepo.deleteById(productId);
	}

	@Override
	public ProductEntity updateProduct(ProductEntity product, Integer productId) { 
		ProductEntity prod = productRepo.findById(productId).get();

		if (Objects.nonNull(product.getProductName()) && !"".equalsIgnoreCase(product.getProductName())) {
			prod.setProductName(product.getProductName());
		}

		if (Objects.nonNull(product.getProductPrice()) && !"".equalsIgnoreCase(product.getProductPrice())) {
			prod.setProductPrice(product.getProductPrice());
		}

		return productRepo.save(prod);
	}

	@Override
	public Optional<ProductEntity> findById(Integer productId) {
		return productRepo.findById(productId);
	}

}
