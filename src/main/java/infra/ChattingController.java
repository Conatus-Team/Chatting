package infra;
import domain.*;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping(value="/chattings")
public class ChattingController {
//     private final ChatService chatService;
//        @Autowired
//        ChattingRepository chattingRepository;
    //chattingroom 으로 routing하는 코드

       //채팅 리스트 화면
       @GetMapping("/")
       public String rooms(Model model){
           return "/chatRoom";
       }

}
