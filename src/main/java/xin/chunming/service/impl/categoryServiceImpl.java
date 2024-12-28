package xin.chunming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.chunming.mapper.categoryMapper;
import xin.chunming.pojo.Category;
import xin.chunming.service.categoryService;

import java.util.List;

@Service
public class categoryServiceImpl implements categoryService {
    @Autowired
    categoryMapper c;

    @Override
    public List<Category> queryByUName(String create_user) {
        return c.getCategoryByUser(create_user);
    }

    @Override
    public void addCategory(Category category) {
        c.insertCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        System.out.println(category);
        c.updateCategory(category);
    }

    @Override
    public void deleteCategory(String id) {
        c.deleteCategory(id);
    }

    @Override
    public Category getCategory(String id) {
      return   c.queryById(id);
    }


}
