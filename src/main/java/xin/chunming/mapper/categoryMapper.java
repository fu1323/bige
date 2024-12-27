package xin.chunming.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xin.chunming.pojo.Category;

import java.util.List;

@Mapper
public interface categoryMapper {
    @Select("select  * from category where creat_user = #{user}")
     List<Category> getCategoryByUser(String user);
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time) values (#{categoryName},#{categoryAlias},#{createUser},NOW(),NOW())")
    void insertCategory(Category category);
}
