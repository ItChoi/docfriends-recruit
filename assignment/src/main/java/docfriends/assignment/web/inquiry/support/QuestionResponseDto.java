package docfriends.assignment.web.inquiry.support;

import docfriends.assignment.web.hashtag.support.HashTagResponseDto;
import docfriends.assignment.web.member.support.MemberResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionResponseDto {
    private Long id;
    private MemberResponseDto member;
    private String title;
    private String content;
    private String answerStatus;
    private List<HashTagResponseDto> hashTagList;
}
