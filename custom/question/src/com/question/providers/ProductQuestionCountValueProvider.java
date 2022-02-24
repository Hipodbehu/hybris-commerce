package com.question.providers;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductQuestionCountValueProvider implements FieldValueProvider, Serializable {
  @Resource(name = "solrFieldNameProvider")
  private FieldNameProvider fieldNameProvider;

  @Override
  public Collection<FieldValue> getFieldValues(final IndexConfig indexConfig, final IndexedProperty indexedProperty, final Object model) throws FieldValueProviderException {
    if (model instanceof ProductModel) {
      final ProductModel product = (ProductModel) model;
      final Collection<FieldValue> fieldValues = new ArrayList<FieldValue>();
      fieldValues.addAll(createFieldValue(product, null, indexedProperty));
      return fieldValues;
    }

    throw new FieldValueProviderException("Error: item is not a Product type !");
  }

  protected List<FieldValue> createFieldValue(final ProductModel product, final LanguageModel language, final IndexedProperty indexedProperty) {
    final List<FieldValue> fieldValues = new ArrayList<FieldValue>();
    int questionCount = product.getQuestion().size();
    addFieldValues(fieldValues, indexedProperty, language, questionCount);
    return fieldValues;
  }

  protected void addFieldValues(final List<FieldValue> fieldValues, final IndexedProperty indexedProperty, final LanguageModel language, final Object value) {
    final Collection<String> fieldNames = fieldNameProvider.getFieldNames(indexedProperty, language == null ? null : language.getIsocode());
    for (final String fieldName : fieldNames) {
      fieldValues.add(new FieldValue(fieldName, value));
    }
  }
}
