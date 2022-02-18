package com.question.service;

import com.question.model.QuestionModel;

import java.util.List;

public interface QuestionService {
  List<QuestionModel> getQuestionsByCode(String code);
}
