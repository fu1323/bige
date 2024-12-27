package xin.chunming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xin.chunming.pojo.Category;
import xin.chunming.pojo.Result;
import xin.chunming.service.impl.categoryServiceImpl;
import xin.chunming.service.impl.userServiceImpl;
import xin.chunming.utils.ThreadLocalUtil;

import java.util.Map;

@RestController
@RequestMapping("/category")
public class categoryController {
    @Autowired
    categoryServiceImpl categoryService;

    @GetMapping
    public Result getCategory() {
        Map<String, Object> stringObjectMap = ThreadLocalUtil.get();
        return Result.success(categoryService.queryByUName(stringObjectMap.get("id").toString()));
    }
    @PostMapping
    public Result addCategory(@RequestBody @Validated Category category) {
        Map<String, Object> stringObjectMap = ThreadLocalUtil.get();
        category.setCreateUser((Integer) stringObjectMap.get("id"));
        categoryService.addCategory(category);
        return Result.success();
    }
}
