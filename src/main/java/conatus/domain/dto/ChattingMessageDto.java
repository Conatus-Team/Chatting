package conatus.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ChattingMessageDto {
	public enum MessageType {
		ENTER, TALK
	}

	private Long id;

	private MessageType type;
	// 채팅방 ID
	private Long groupId;
	// 보내는 사람
	private Long userId;
	
	private String nickname;
	
	// 내용
	private String message;
	
	// 메시지 보낸 시각
	private LocalDateTime createdTime = LocalDateTime.now();
}
