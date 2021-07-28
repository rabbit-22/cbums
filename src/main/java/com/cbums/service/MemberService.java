package com.cbums.service;

import com.cbums.model.Member;
import com.cbums.model.UserRoleType;
import com.cbums.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public Member joinForWriteForm(Member member) {
        return member;
    }

    public Member signUp(Member member) {

        return member;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email).get();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (email.equals("admin")) {
            grantedAuthorities.add(new SimpleGrantedAuthority(UserRoleType.ADMIN.name()));
        } else if(member.getRegisterNumber() != null) {
            grantedAuthorities.add(new SimpleGrantedAuthority(UserRoleType.MEMBER.name()));
        } else {
            grantedAuthorities.add(new SimpleGrantedAuthority(UserRoleType.VISITANT.name()));
        }

        return new User(member.getEmail(), member.getPassword(), grantedAuthorities);
    }

}