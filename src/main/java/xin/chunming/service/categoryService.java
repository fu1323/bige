package xin.chunming.service;

import xin.chunming.pojo.Category;

import java.util.List;

public interface categoryService {

    List<Category> queryByUName(String create_user);
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(String id);
    Category getCategory(String id);
}
