package docfriends.assignment.web.member.support;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MemberRequestDto {
    @NotBlank(message = "이메일은 필수 입력 값 입니다.")
    private String email;
    @NotBlank(message = "비밀번호는 필수 입력 값 입니다.")
    private String password;
    private String name;
}
