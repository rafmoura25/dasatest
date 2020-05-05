package com.app.dasa.api.service;

import com.app.dasa.api.entity.Exam;

import java.util.List;
import java.util.Optional;

public interface ExamService {
    List<Exam> findAll();
    Optional<Exam> findById(Long id);
    Exam save(Exam exam);
}
