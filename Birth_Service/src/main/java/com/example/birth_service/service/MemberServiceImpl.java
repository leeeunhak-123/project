package com.example.birth_service.service;

import com.example.birth_service.mapper.MemberMapper;
import com.example.birth_service.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService{
    private final MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper){
        this.memberMapper = memberMapper;
    }
    @Override
    public Member getMemberById(Integer id) {
        return memberMapper.findById(id);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberMapper.findAll();
    }

    @Override
    public void addMember(Member member) {
        memberMapper.insert(member);
    }

    @Override
    public void updateMember(Member member) {
        memberMapper.update(member);
    }

    @Override
    public void deleteMember(Integer id) {
        memberMapper.deleteById(id);
    }
}
