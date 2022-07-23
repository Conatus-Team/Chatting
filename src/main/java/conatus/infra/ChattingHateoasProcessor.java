package conatus.infra;

import conatus.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ChattingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Chatting>> {

    @Override
    public EntityModel<Chatting> process(EntityModel<Chatting> model) {
        return model;
    }
}
