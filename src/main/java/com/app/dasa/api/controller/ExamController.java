package com.app.dasa.api.controller;

import com.app.dasa.api.entity.Exam;
import com.app.dasa.api.service.ExamService;
import com.app.dasa.dto.ExamDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController("ExamController")
@Api(value = "DasaApi")
@RequestMapping(value = "/exam")
public class ExamController {

    @Autowired
    private ExamService _examService;

    @ApiOperation(value = "List all exams", response = Exam.class)
    @GetMapping(value = "/exams", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity GetAll() throws Exception{
        List<Exam> exams = _examService.findAll();
        if(exams.isEmpty()){
            return new ResponseEntity(exams, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(exams, HttpStatus.OK);

    }

    @ApiOperation(value = "Get an exam by id", response = Exam.class)
    @GetMapping(value = "/exam/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity GetById(@PathVariable(value = "id") long id) throws Exception{
        Optional<Exam> exam = _examService.findById(id);
        if(exam.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Exam>(exam.get(), HttpStatus.OK);
    }

    @ApiOperation(value = "Post a new exam", response = Exam.class)
    @PostMapping(value = "/exam", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Exam Post(@Valid @RequestBody ExamDTO dto) throws Exception{
        return _examService.save(dto.toExam());
    }

    @ApiOperation(value = "Update an exam", response = Exam.class)
    @PutMapping(value = "/exam/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Exam> Put(@PathVariable(value = "id") long id,
                                    @Valid @RequestBody ExamDTO dto) throws Exception{
        Optional<Exam> oldExam = _examService.findById(id);
        if(oldExam.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Exam exam = oldExam.get();
        exam.setNome(dto.getNome());
        exam.setTipo(dto.getTipo());
        _examService.save(exam);

        return new ResponseEntity<Exam>(exam, HttpStatus.OK);
    }
}
