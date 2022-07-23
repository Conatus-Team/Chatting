package conatus.infra.controller;

import javax.transaction.Transactional;

import conatus.domain.repository.ChattingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/chattings")
@Transactional
public class ChattingController {

    @Autowired
    ChattingRepository chattingRepository;
    // keep
}
