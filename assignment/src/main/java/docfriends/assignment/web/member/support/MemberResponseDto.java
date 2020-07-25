package docfriends.assignment.web.member.support;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponseDto {
    private long id;
    private String email;
    private String password;
    private String name;
}
