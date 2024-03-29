package conatus.infra.hateoas;

import conatus.domain.entity.ChattingRoom;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ChattingRoomHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ChattingRoom>> {

    @Override
    public EntityModel<ChattingRoom> process(EntityModel<ChattingRoom> model) {
        return model;
    }
}
