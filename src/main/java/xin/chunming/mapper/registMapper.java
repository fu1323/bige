package xin.chunming.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xin.chunming.pojo.User;

import java.util.List;

@Mapper
public interface registMapper {
    @Select("select * from big_event.user where username=#{username}")
    public List<User> selectByName(String userName);

    @Insert("insert into big_event.user(username, password, create_time,update_time) VALUES (#{username},#{password},NOW(),NOW())")
    public void registInsert(@Param("username") String uName, @Param("password") String uPassword);
}
