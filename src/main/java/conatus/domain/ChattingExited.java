package conatus.domain;

import conatus.domain.*;
import conatus.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class ChattingExited extends AbstractEvent {

    private Long id;
    private Long groupId;
    private Date enterdTime;
    private Date exitTime;
    private Long userId;

    public ChattingExited(Chatting aggregate) {
        super(aggregate);
    }

    public ChattingExited() {
        super();
    }
    // keep

}
