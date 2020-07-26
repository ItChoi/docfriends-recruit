package docfriends.assignment.web.inquiry.support;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequestDto {
    private Long id;
    private Long questionId;
    private Long memberId;
    private String content;
}
