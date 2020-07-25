package docfriends.assignment.web.inquiry.support;

import docfriends.assignment.web.hashtag.support.HashTagRequestDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionRequestDto {
    private Long id;
    private Long memberId;
    private String title;
    private String content;
    private String answerStatus;
    private List<HashTagRequestDto> hashTagList;
}
