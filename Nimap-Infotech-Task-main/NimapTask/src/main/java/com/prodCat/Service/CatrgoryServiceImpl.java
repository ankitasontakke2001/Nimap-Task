package com.prodCat.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodCat.Entity.CategoryEntity;
import com.prodCat.Repository.CatrgoryRepo;
@Service
public class CatrgoryServiceImpl implements CategoryService{
	
	@Autowired
	private CatrgoryRepo catrgoryRepo;
	@Override
	public CategoryEntity saveCategory(CategoryEntity category) {
		return catrgoryRepo.save(category);
	}

	@Override
	public List<CategoryEntity> getAllCategory() {
		return (List<CategoryEntity>) catrgoryRepo.findAll();
	}

	@Override
	public CategoryEntity updateCategory(CategoryEntity category, Integer categoryId) {
		CategoryEntity cat = catrgoryRepo.findById(categoryId).get();

		if (Objects.nonNull(category.getCategoryName()) && !"".equalsIgnoreCase(category.getCategoryName())) {
			cat.setCategoryName(category.getCategoryName());
		}

		return catrgoryRepo.save(cat);
	}

	@Override
	public void delectCategoryById(Integer categoryId) {
		catrgoryRepo.deleteById(categoryId);
		
	}

	@Override
	public Optional<CategoryEntity> findById(Integer categoryId) {
		return catrgoryRepo.findById(categoryId);
	}

}
