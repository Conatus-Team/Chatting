package conatus.infra.hateos;

import conatus.domain.entity.ChattingMessage;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ChattingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ChattingMessage>> {

    @Override
    public EntityModel<ChattingMessage> process(EntityModel<ChattingMessage> model) {
        return model;
    }
}
