package com.question.controllers.cms;

import com.question.model.cms2.components.QuestionCMSComponentModel;
import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller("QuestionCMSComponentController")
@RequestMapping(value = "/view/QuestionCMSComponentController")
public class QuestionCMSComponentController extends AbstractCMSAddOnComponentController<QuestionCMSComponentModel> {
  public static final String PRODUCT_CODE_ATTRIBUTE = "productCode";
  public static final String QUESTIONS_ATTRIBUTE = "questions";
  public static final String NUMBER_OF_QUESTIONS_ATTRIBUTE = "numberOfQuestions";
  public static final String FONT_SIZE_ATTRIBUTE = "fontSize";

  @Resource(name = "productVariantFacade")
  private ProductFacade productFacade;

  @Override
  protected void fillModel(HttpServletRequest request, Model model, QuestionCMSComponentModel component) {
    List<ProductOption> options = Arrays.asList(ProductOption.QUESTIONS);
    String code = (String) request.getAttribute(PRODUCT_CODE_ATTRIBUTE);
    ProductData productData = productFacade.getProductForCodeAndOptions(code, options);
    model.addAttribute(QUESTIONS_ATTRIBUTE, productData.getQuestions());
    model.addAttribute(NUMBER_OF_QUESTIONS_ATTRIBUTE, component.getNumberOfQuestions());
    model.addAttribute(FONT_SIZE_ATTRIBUTE, component.getFontSize());
  }
}
