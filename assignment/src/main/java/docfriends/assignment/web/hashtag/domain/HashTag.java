package docfriends.assignment.web.hashtag.domain;

import docfriends.assignment.common.BaseDateTimeEntity;
import docfriends.assignment.web.inquiry.domain.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class HashTag extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    private String tagName;

    public void changeQuestion(Question question) {
        this.question = question;
    }

}
