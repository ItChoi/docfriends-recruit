package docfriends.assignment.web.inquiry;

import docfriends.assignment.web.inquiry.domain.Answer;
import docfriends.assignment.web.inquiry.repository.QuestionRepository;
import docfriends.assignment.web.inquiry.service.AnswerService;
import docfriends.assignment.web.inquiry.service.QuestionService;
import docfriends.assignment.web.inquiry.support.AnswerRequestDto;
import docfriends.assignment.web.inquiry.support.AnswerResponseDto;
import docfriends.assignment.web.inquiry.support.QuestionRequestDto;
import docfriends.assignment.web.inquiry.support.QuestionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class InquiryController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @GetMapping("/question")
    public ResponseEntity<List<QuestionResponseDto>> list() {
        List<QuestionResponseDto> questionDtos = questionService.findAll();

        return new ResponseEntity<>(questionDtos, HttpStatus.OK);
    }

    @PostMapping("/question")
    public ResponseEntity<QuestionResponseDto> writeQuestion(@RequestBody QuestionRequestDto questionRequestDto, HttpServletRequest request) {
        QuestionResponseDto questionDto = questionService.save(questionRequestDto, request);

        return new ResponseEntity<>(questionDto, HttpStatus.OK);
    }

    @PostMapping("/answer")
    public ResponseEntity<AnswerResponseDto> writeAnswer(@RequestBody AnswerRequestDto answerRequestDto) {
        AnswerResponseDto answerResponseDto = answerService.writeAnswer(answerRequestDto);

        return new ResponseEntity<>(answerResponseDto, HttpStatus.OK);
    }



}
