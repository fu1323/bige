package xin.chunming.mapper;

import org.apache.ibatis.annotations.*;
import xin.chunming.pojo.Category;

import java.util.List;

@Mapper
public interface categoryMapper {
    @Select("select  * from category where create_user = #{user}")
     List<Category> getCategoryByUser(String user);
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time) values (#{categoryName},#{categoryAlias},#{createUser},NOW(),NOW())")
    void insertCategory(Category category);
    @Update("update category set category_name=#{categoryName} , category_alias = #{categoryAlias} , update_time=NOW() where id = #{id}")
    void updateCategory(Category category);
   @Delete("delete from category where id=#{id}")
    void deleteCategory(String id);
    @Select("select  * from category where id = #{id}")
    Category queryById(String id);
}
