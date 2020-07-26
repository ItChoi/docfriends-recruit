package docfriends.assignment.web.inquiry.service;

import docfriends.assignment.common.Utils;
import docfriends.assignment.web.inquiry.domain.Answer;
import docfriends.assignment.web.inquiry.repository.AnswerRepository;
import docfriends.assignment.web.inquiry.support.AnswerRequestDto;
import docfriends.assignment.web.inquiry.support.AnswerResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final ModelMapper modelMapper;
    private final AnswerRepository answerRepository;

    @Transactional
    public AnswerResponseDto writeAnswer(AnswerRequestDto answerRequestDto) {
        answerRequestDto.setMemberId((Long) Utils.getMemberIdFromSession());
        Answer answer = modelMapper.map(answerRequestDto, Answer.class);
        Answer savedDate = answerRepository.save(answer);

        return modelMapper.map(savedDate, AnswerResponseDto.class);
    }

}
