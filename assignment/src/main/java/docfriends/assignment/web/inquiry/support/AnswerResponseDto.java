package docfriends.assignment.web.inquiry.support;

import docfriends.assignment.web.member.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerResponseDto {
    private Long id;
    private Long questionId;
    private Long memberId;
    private String content;
}
