package docfriends.assignment.web.member;

import docfriends.assignment.web.member.service.MemberService;
import docfriends.assignment.web.member.support.MemberRequestDto;
import docfriends.assignment.web.member.support.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<MemberResponseDto> registerMember(@RequestBody MemberRequestDto memberRequestDto) {
        MemberResponseDto memberResponseDto = memberService.save(memberRequestDto);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    // 가입 시 중복 이메일 체크
    @GetMapping("/member/email-check")
    public ResponseEntity<Boolean> emailCheck(String email) {
        boolean alreadyExists = memberService.emailCheck(email);

        return new ResponseEntity<>(alreadyExists, HttpStatus.OK);
    }

    @PostMapping("/member/login")
    public ResponseEntity<String> login(@RequestBody MemberRequestDto memberRequestDto) {
        String message = memberService.login(memberRequestDto);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
