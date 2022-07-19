package com.group.chatting.rest;

import com.group.chatting.mapper.UserMapper;
import com.group.chatting.vo.SocketVO;
import com.group.chatting.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/group_chat/insert")
    public String userAdd(SocketVO content){
        System.out.println("insert mapping");
        UserVO user = new UserVO(content.getUserName(), content.getUserMessage());
//        user.setUserName("sunny");
//        user.setUserMessage("hello");
        System.out.println(user);
        userMapper.insert(user);
        System.out.println(userMapper.getClass());
        return "redirect:/group_chat";
    }
//    @GetMapping(value = "/user")
//    public List<Chatting> getUserList() {
//        return chatting.getMessage();
//    }

    @GetMapping(value = "/group_chat/print")
    public String userPrint(UserVO user){
        String userName = user.getUserName();
        String userMessage = user.getUserMessage();
        System.out.println(userName);
        System.out.println(userMessage);
        return "redirect:/group_chat";
    }


    @GetMapping(value = "/group_chat")
    public String userlistPage(Model model) {
        model.addAttribute("group_chat", userMapper.listForBeanPropertyRowMapper());
        return "redirect:/group_chat";
    }
//@MessageMapping("/group_chat")
//
//// /send로 메시지를 반환합니다.
//@SendTo("/send")
//
//// SocketHandler는 1) /receive에서 메시지를 받고, /send로 메시지를 보내줍니다.
//// 정의한 SocketVO를 1) 인자값, 2) 반환값으로 사용합니다.
//public SocketVO SocketHandler(SocketVO socketVO) {
//    // vo에서 getter로 userName을 가져옵니다.
//    String userName = socketVO.getUserName();
//    // vo에서 setter로 content를 가져옵니다.
//    String content = socketVO.getContent();
//
//    // 생성자로 반환값을 생성합니다.
//    SocketVO result = new SocketVO(userName, content);
//    // 반환
//    return result;
//}

}
