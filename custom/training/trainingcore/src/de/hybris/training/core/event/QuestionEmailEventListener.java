package de.hybris.training.core.event;

import com.question.model.custom.QuestionEmailProcessModel;
import de.hybris.platform.commerceservices.event.RegisterEvent;
import de.hybris.platform.core.Registry;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;

public class QuestionEmailEventListener extends AbstractEventListener<RegisterEvent> {
  private ModelService modelService;

  public BusinessProcessService getBusinessProcessService() {
    return (BusinessProcessService) Registry.getApplicationContext().getBean("businessProcessService");
  }

  protected ModelService getModelService() {
    return modelService;
  }

  public void setModelService(final ModelService modelService) {
    this.modelService = modelService;
  }

  @Override
  protected void onEvent(RegisterEvent registerEvent) {
    final QuestionEmailProcessModel questionEmailProcessModel = (QuestionEmailProcessModel) getBusinessProcessService()
            .createProcess("questionEmailProcess" + System.currentTimeMillis(), "questionEmailProcess");
    questionEmailProcessModel.setSite(registerEvent.getSite());
    questionEmailProcessModel.setCustomer(registerEvent.getCustomer());
    getModelService().save(questionEmailProcessModel);
    getBusinessProcessService().startProcess(questionEmailProcessModel);
  }
}
