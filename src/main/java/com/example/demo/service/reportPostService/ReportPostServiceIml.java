package com.example.demo.service.reportPostService;

import com.example.demo.model.ReportPost;
import com.example.demo.repository.ReportPostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ReportPostServiceIml implements ReportPostService {
    @Autowired
    ReportPostRepository reportPostRepository;

    @Override
    public Iterable<ReportPost> findAll() {
        return reportPostRepository.findAll();
    }

    @Override
    public Optional<ReportPost> findById(Long id) {
        return reportPostRepository.findById(id);
    }

    @Override
    public ReportPost save(ReportPost reportPost) {
        return reportPostRepository.save(reportPost);
    }


    @Override
    public void remove(Long id) {
        reportPostRepository.deleteById(id);
    }
}
