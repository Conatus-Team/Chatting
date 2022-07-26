package conatus.infra.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class ChattingConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // defines the url of the socket so the client can connect to it
//        registry.addEndpoint("/ws/chat").setAllowedOriginPatterns("*").withSockJS();
        registry.addEndpoint("/ws/chat").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // prefix for the client to receive broadcasted messages from the server
        registry.enableSimpleBroker("/queue", "/topic");

        // prefix for the client to send messages to the server
        registry.setApplicationDestinationPrefixes("/app");
    }
}