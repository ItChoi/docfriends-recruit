package docfriends.assignment.web.inquiry.domain;

import docfriends.assignment.common.BaseDateTimeEntity;
import docfriends.assignment.web.hashtag.domain.HashTag;
import docfriends.assignment.web.member.domain.Member;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Question extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    @Column(columnDefinition = "text")
    private String content;

    private String answerStatus;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<HashTag> hashTagList = new ArrayList<>();


    public void changeHashTag() {
        hashTagList.forEach(hashTag -> {
            hashTag.changeQuestion(this);
        });
    }

}
