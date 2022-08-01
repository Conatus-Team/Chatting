package conatus.infra.controller;

import javax.transaction.Transactional;

import conatus.domain.repository.ChattingRoomRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.stomp.service.ChatRoomService;

@RestController
@RequestMapping(value = "/chat")
@RequiredArgsConstructor
@Transactional
public class ChattingRoomController {

	private final ChattingRoomService chattingRoomService;
}
