package docfriends.assignment.web.hashtag.support;

import docfriends.assignment.web.inquiry.support.QuestionRequestDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashTagRequestDto {
    private Long id;
    //private Long questionId;
    private QuestionRequestDto question;
    private String tagName;
}
