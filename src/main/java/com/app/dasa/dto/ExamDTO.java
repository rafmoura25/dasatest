package com.app.dasa.dto;

import com.app.dasa.api.entity.Exam;
import lombok.Getter;

@Getter
public class ExamDTO {
    private String nome;
    private String tipo;

    public Exam toExam(){
        return new Exam(getNome(), getTipo());
    }

}


