package conatus.domain.event;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import conatus.infra.AbstractEvent;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GroupCreated extends AbstractEvent {
    Long groupId;
    Long userId;
    String Category;
    String name;



}
