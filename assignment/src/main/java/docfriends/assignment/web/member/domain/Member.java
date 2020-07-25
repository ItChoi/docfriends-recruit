package docfriends.assignment.web.member.domain;

import docfriends.assignment.common.BaseDateTimeEntity;
import docfriends.assignment.web.inquiry.domain.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Question> questionList = new ArrayList<>();

}
