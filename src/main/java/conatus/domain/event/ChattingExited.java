package conatus.domain.event;

import conatus.domain.entity.ChattingMessage;
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

    public ChattingExited(ChattingMessage aggregate) {
        super(aggregate);
    }

    public ChattingExited() {
        super();
    }
    // keep

}
