package xin.chunming.mapper;

import org.apache.ibatis.annotations.*;
import xin.chunming.pojo.User;

import java.util.List;

@Mapper
public interface userMapper {
    @Select("select * from big_event.user where username=#{username}")
    public List<User> selectByName(String userName);

    @Insert("insert into big_event.user(username, password, create_time,update_time) VALUES (#{username},#{password},NOW(),NOW())")
    public void registInsert(@Param("username") String uName, @Param("password") String uPassword);

    @Select("select * from big_event.user where username=#{username} and password=#{password}")
    public List<User> select2Login(@Param("username") String userName, @Param("password") String password);

    @Update("update user set username=#{username},nickname=#{nickname},email=#{email},update_time=now() where id = #{id}")
    public void update(User u);

    @Update("update user set user_pic = #{avatorURL} where id = #{id} ")
    void updateURL(@Param("avatorURL") String avatarURL, @Param("id") String id);

    @Update("update user set password = #{pwd} where username = #{username}")
    void updatePwd(@Param("pwd") String pwd, @Param("username") String username);
}
