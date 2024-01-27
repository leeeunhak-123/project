package com.example.birth_service.service;

import com.example.birth_service.model.Member;

import java.util.List;

public interface MemberService {

    Member getMemberById(Integer id);

    List<Member> getAllMembers();

    void addMember(Member member);

    void updateMember(Member member);

    void deleteMember(Integer id);

}
