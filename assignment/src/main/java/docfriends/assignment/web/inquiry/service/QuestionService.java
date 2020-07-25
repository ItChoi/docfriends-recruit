package docfriends.assignment.web.inquiry.service;

import docfriends.assignment.web.hashtag.domain.HashTag;
import docfriends.assignment.web.hashtag.repository.HashTagRepository;
import docfriends.assignment.web.inquiry.domain.Question;
import docfriends.assignment.web.inquiry.repository.QuestionRepository;
import docfriends.assignment.web.inquiry.support.QuestionRequestDto;
import docfriends.assignment.web.inquiry.support.QuestionResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    private final ModelMapper modelMapper;

    private final HashTagRepository hashTagRepository;

    public List<QuestionResponseDto> findAll() {
        List<Question> questionList = questionRepository.findAll();

        return questionList.stream()
                .map(question -> modelMapper.map(question, QuestionResponseDto.class))
                .collect(Collectors.toList());

    }

    @Transactional
    public QuestionResponseDto save(QuestionRequestDto questionRequestDto) {
        questionRequestDto.setAnswerStatus("N");
        Question question = modelMapper.map(questionRequestDto, Question.class);
        question.changeHashTag();
        questionRepository.save(question);

        return modelMapper.map(question, QuestionResponseDto.class);
    }
}
