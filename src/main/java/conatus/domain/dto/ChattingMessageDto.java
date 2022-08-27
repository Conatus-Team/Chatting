package conatus.domain.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import conatus.domain.entity.ChattingMessage;
import conatus.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChattingMessageDto {
    public enum MessageType {
        ENTER, TALK
    }

    private Long id;

    private MessageType type;
    // 채팅방 ID
    private Long roomId;
    // 보내는 사람
    private Long userId;

    private String nickname;

    // 내용
    private String message;

    // 메시지 보낸 시각
    private LocalDateTime createdTime = LocalDateTime.now();

    public static ChattingMessageDto from(ChattingMessage data) {

        return ChattingMessageDto.builder()
                .id(data.getId())
                .createdTime(data.getCreatedTime())
                .userId(data.getUserId())
                .message(data.getMessage())
                .roomId(data.getChattingRoom().getId())
                .build();
    }
}
