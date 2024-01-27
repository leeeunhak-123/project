package com.example.birth_service.mapper;

import com.example.birth_service.model.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("SELECT * FROM member WHERE id = #{id}")
    Member findById(@Param("id") Integer id);

    @Select("SELECT * FROM member")
    List<Member> findAll();

    @Insert("INSERT INTO member(userid, name, userpassword, birth, email, profileimage, nickname, marrystatus, childNum, role) " +
            "VALUES(#{userid}, #{name}, #{userpassword}, #{birth}, #{email}, #{profileimage}, #{nickname}, #{marrystatus}, #{childNum}, #{role})")
    void insert(Member member);

    @Update("UPDATE member SET userid = #{userid}, name = #{name}, userpassword = #{userpassword}, birth = #{birth}, " +
            "email = #{email}, profileimage = #{profileimage}, nickname = #{nickname}, marrystatus = #{marrystatus}, " +
            "childNum = #{childNum}, role = #{role} WHERE id = #{id}")
    void update(Member member);

    @Delete("DELETE FROM member WHERE id = #{id}")
    void deleteById(@Param("id") Integer id);
}
