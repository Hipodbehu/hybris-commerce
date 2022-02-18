package com.question.service.impl;

import com.question.daos.QuestionDao;
import com.question.model.QuestionModel;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultQuestionService implements QuestionService {
  private QuestionDao questionDao;

  @Override
  public List<QuestionModel> getQuestionsByCode(String code) {
    return questionDao.findQuestionsByCode(code);
  }

  @Required
  public void setQuestionDao(final QuestionDao questionDao) {
    this.questionDao = questionDao;
  }
}
