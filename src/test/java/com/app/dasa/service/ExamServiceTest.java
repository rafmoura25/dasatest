package com.app.dasa.service;

import com.app.dasa.api.entity.Exam;
import com.app.dasa.api.service.ExamService;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ExamServiceTest {

    @Mock
    private ExamService _service;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllExams() throws Exception{
        List<Exam> exams = new ArrayList<Exam>();

        Faker faker = new Faker();

        exams.add(Exam.builder().id((long) 1)
                .nome(faker.gameOfThrones().character())
                .tipo(faker.gameOfThrones().house())
                .status(true)
                .build());

        exams.add(Exam.builder().id((long) 2)
                .nome(faker.pokemon().name())
                .tipo(faker.pokemon().location())
                .status(true)
                .build());

        when(_service.findAll()).thenReturn(exams);

        List<Exam> examsList = _service.findAll();
        assertEquals(2, exams.size());
        verify(_service, times(1)).findAll();
    }

    @Test
    public void createExam(){
        Exam exam = Exam.builder().id((long) 1)
                .nome("Colonoscopia")
                .tipo("Imagem")
                .status(true)
                .build();

        _service.save(exam);

        verify(_service, times(1)).save(exam);
    }

    @Test
    public void getExamById(){
        when(_service.findById((long)1)).thenReturn(java.util.Optional.ofNullable(
                Exam.builder().id((long) 1)
                .nome("Colonoscopia")
                .tipo("Imagem")
                .status(true)
                .build()));

        Optional<Exam> exam = _service.findById((long)1);

        assertEquals("Colonoscopia", exam.get().getNome());
        assertEquals("Imagem", exam.get().getTipo());
        assertEquals(true, exam.get().getStatus());

    }
}
