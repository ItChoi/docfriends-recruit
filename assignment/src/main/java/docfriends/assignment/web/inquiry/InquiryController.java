package docfriends.assignment.web.inquiry;

import docfriends.assignment.web.inquiry.repository.QuestionRepository;
import docfriends.assignment.web.inquiry.service.QuestionService;
import docfriends.assignment.web.inquiry.support.QuestionRequestDto;
import docfriends.assignment.web.inquiry.support.QuestionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class InquiryController {

    private final QuestionService questionService;
    private final QuestionRepository questionRepository;

    @GetMapping("/question")
    public ResponseEntity<List<QuestionResponseDto>> list() {
        List<QuestionResponseDto> questionDtos = questionService.findAll();

        return new ResponseEntity<>(questionDtos, HttpStatus.OK);
    }

    @PostMapping("/question")
    public ResponseEntity<QuestionResponseDto> writeQuestion(@RequestBody QuestionRequestDto questionRequestDto) {
        QuestionResponseDto questionDto = questionService.save(questionRequestDto);

        return new ResponseEntity<>(questionDto, HttpStatus.OK);
    }




}
