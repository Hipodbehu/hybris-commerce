package com.question.facades.impl;

import com.question.data.QuestionData;
import com.question.facades.QuestionFacade;
import com.question.model.QuestionModel;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;

public class DefaultQuestionFacade implements QuestionFacade {
  private QuestionService questionService;

  @Override
  public List<QuestionData> getQuestionsByCode(String code) {
    final List<QuestionModel> questionModels = questionService.getQuestionsByCode(code);
    final List<QuestionData> questionDataList = new ArrayList<>();
    questionModels.forEach(questionModel -> questionDataList.add(createData(questionModel)));
    return questionDataList;
  }

  private QuestionData createData(QuestionModel questionModel) {
    final QuestionData questionData = new QuestionData();
    questionData.setQuestion(questionModel.getQuestion());
    return questionData;
  }

  @Required
  public void setQuestionService(final QuestionService questionService) {
    this.questionService = questionService;
  }
}
