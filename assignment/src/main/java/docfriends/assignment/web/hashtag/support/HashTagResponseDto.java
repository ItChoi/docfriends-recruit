package docfriends.assignment.web.hashtag.support;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashTagResponseDto {
    private Long id;
    private Long questionId;
    private String tagName;
}
