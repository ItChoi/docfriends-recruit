package docfriends.assignment.web.member.service;

import docfriends.assignment.common.SecurityUtils;
import docfriends.assignment.common.Utils;
import docfriends.assignment.exception.UserNotFoundException;
import docfriends.assignment.web.member.domain.Member;
import docfriends.assignment.web.member.repository.MemberRepository;
import docfriends.assignment.web.member.support.MemberRequestDto;
import docfriends.assignment.web.member.support.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    public MemberResponseDto save(MemberRequestDto memberRequestDto) {
        memberRequestDto.setPassword(SecurityUtils.encryptSha256(memberRequestDto.getPassword()));
        Member member = modelMapper.map(memberRequestDto, Member.class);
        memberRepository.save(member);

        return modelMapper.map(member, MemberResponseDto.class);
    }


    public boolean emailCheck(String email) {
        return memberRepository.existsByEmail(email);
    }

    public String login(MemberRequestDto memberRequestDto, HttpServletRequest request) {
        Member member = memberRepository.findByEmail(memberRequestDto.getEmail()).orElseThrow(() -> new UserNotFoundException(memberRequestDto.getEmail()));

        String message = "";
        String inputPw = SecurityUtils.encryptSha256(memberRequestDto.getPassword());

        if (member.getPassword().equals(inputPw)) {
            Utils.registerSessionByMemberId(member.getId());
            message = "success";
        } else {
            message = "fail";
        }

        return message;
    }



}
