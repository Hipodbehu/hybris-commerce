package com.question.controllers.cms;

import com.question.model.cms2.components.QuestionCMSComponentModel;
import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller("QuestionCMSComponentController")
@RequestMapping(value = "/view/QuestionCMSComponentController")
public class QuestionCMSComponentController extends AbstractCMSAddOnComponentController<QuestionCMSComponentModel> {
  @Override
  protected void fillModel(HttpServletRequest request, Model model, QuestionCMSComponentModel component) {
    model.addAttribute("numberOfQuestions", component.getNumberOfQuestions());
    model.addAttribute("fontSize", component.getFontSize());
  }

  @Override
  protected String getView(final QuestionCMSComponentModel component) {
    return "addon:/question/cms/" + (getTypeCode(component).toLowerCase(Locale.ROOT));
  }
}
