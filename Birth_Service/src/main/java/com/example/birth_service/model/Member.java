package com.example.birth_service.model;

import org.springframework.data.annotation.Id;

public class Member {
    @Id
    private Integer id;
    private String userid;
    private String name;
    private String userpassword;
    private String birth;
    private String email;
    private byte[] profileimage;
    private String nickname;
    private MarryStatus marrystatus;
    private Integer childNum;
    private Role role;

    public Integer getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public String getBirth() {
        return birth;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getProfileimage() {
        return profileimage;
    }

    public String getNickname() {
        return nickname;
    }

    public MarryStatus getMarrystatus() {
        return marrystatus;
    }

    public Integer getChildNum() {
        return childNum;
    }

    public Role getRole() {
        return role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfileimage(byte[] profileimage) {
        this.profileimage = profileimage;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setMarrystatus(MarryStatus marrystatus) {
        this.marrystatus = marrystatus;
    }

    public void setChildNum(Integer childNum) {
        this.childNum = childNum;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
