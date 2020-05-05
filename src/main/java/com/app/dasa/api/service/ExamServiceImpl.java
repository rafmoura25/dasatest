package com.app.dasa.api.service;

import com.app.dasa.api.entity.Exam;
import com.app.dasa.api.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService{

    @Autowired
    private ExamRepository _examRepository;

    @Override
    public List<Exam> findAll() {
        return _examRepository.findAll();
    }

    @Override
    public Optional<Exam> findById(Long id) {
        return _examRepository.findById(id);
    }

    @Override
    public Exam save(Exam exam) {
        return _examRepository.save(exam);
    }
}
