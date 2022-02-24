package com.question.populators;

import com.question.data.QuestionData;
import com.question.model.QuestionModel;
import de.hybris.platform.commercefacades.product.converters.populator.AbstractProductPopulator;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.List;
import java.util.stream.Collectors;

public class ProductQuestionPopulator<SOURCE extends ProductModel, TARGET extends ProductData>
        extends AbstractProductPopulator<SOURCE, TARGET> {

  @Override
  public void populate(SOURCE source, TARGET target) throws ConversionException {
    target.setQuestions(getQuestionData(source));
  }

  private List<QuestionData> getQuestionData(SOURCE source) {
    return source.getQuestion().stream()
            .map(this::convertQuestionModelToData)
            .collect(Collectors.toList());
  }

  private QuestionData convertQuestionModelToData(QuestionModel questionModel) {
    QuestionData questionData = new QuestionData();
    questionData.setQuestion(questionModel.getQuestion());
    questionData.setAnswer(questionModel.getAnswer());
    return questionData;
  }
}
