package conatus.infra.controller;

import javax.transaction.Transactional;

import conatus.domain.repository.ChattingRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/chattingRooms")
@Transactional
public class ChattingRoomController {

    @Autowired
    ChattingRoomRepository chattingRoomRepository;
    // keep
}
