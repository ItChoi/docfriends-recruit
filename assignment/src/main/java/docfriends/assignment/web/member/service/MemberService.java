package docfriends.assignment.web.member.service;

import docfriends.assignment.common.SecurityUtils;
import docfriends.assignment.exception.UserNotFoundException;
import docfriends.assignment.web.member.domain.Member;
import docfriends.assignment.web.member.repository.MemberRepository;
import docfriends.assignment.web.member.support.MemberRequestDto;
import docfriends.assignment.web.member.support.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

    public String login(MemberRequestDto memberRequestDto) {
        Member member = memberRepository.findByEmail(memberRequestDto.getEmail()).orElseThrow(() -> new UserNotFoundException(memberRequestDto.getEmail()));

        String message = "";
        String inputPw = SecurityUtils.encryptSha256(memberRequestDto.getPassword());

        if (member.getPassword().equals(inputPw)) {
            message = "success";
        } else {
            message = "fail";
        }

        return message;
    }


}
