package conatus.domain.event;


import conatus.infra.AbstractEvent;

import lombok.Data;

@Data
public class GroupQuitted extends AbstractEvent {

    private Long id;
    private Long groupId;
    private Long userId;
    // keep

}
