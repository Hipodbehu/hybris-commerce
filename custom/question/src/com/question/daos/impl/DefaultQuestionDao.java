package com.question.daos.impl;

import com.question.daos.QuestionDao;
import com.question.model.QuestionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;

import java.util.List;

public class DefaultQuestionDao extends AbstractItemDao implements QuestionDao {
  @Override
  public List<QuestionModel> findQuestionsByCode(String code) {
    final String queryString = "SELECT {q:" + QuestionModel.QUESTION + "} " +
            "FROM {" + QuestionModel._TYPECODE + " AS q JOIN Question2Product as rel" +
            "ON {q:" + QuestionModel.PK + "} = {rel:target}" +
            "JOIN " +  ProductModel._TYPECODE + "AS p" +
            "ON {rel:source} = {" + ProductModel.PK + "}" +
            "}";
    final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
    return flexibleSearchService.<QuestionModel> search(query).getResult();
  }
}
