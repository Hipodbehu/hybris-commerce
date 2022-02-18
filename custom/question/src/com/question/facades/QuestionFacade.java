package com.question.facades;

import com.question.data.QuestionData;

import java.util.List;

public interface QuestionFacade {
  List<QuestionData> getQuestionsByCode(String code);
}
