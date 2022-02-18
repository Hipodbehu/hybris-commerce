package de.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.converters.populator.SearchResultVariantProductPopulator;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;

import java.util.ArrayList;

public class CustomSearchResultVariantProductPopulator extends SearchResultVariantProductPopulator {

  @Override
  public void populate(SearchResultValueData source, ProductData target) {
    super.populate(source, target);
    // populate unit property values
    target.setUnit(this.<ArrayList<String>> getValue(source, "unit").get(0));
    target.setQuestionCount(Integer.parseInt(this.<String> getValue(source, "questionCount")));
  }
}