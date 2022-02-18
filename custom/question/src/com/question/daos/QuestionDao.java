package com.question.daos;

import com.question.model.QuestionModel;

import java.util.List;

public interface QuestionDao {
  List<QuestionModel> findQuestionsByCode(String code);
}
