//package conatus.infra.config;
//
//import org.springframework.cloud.stream.annotation.Input;
//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.SubscribableChannel;
//
//public interface KafkaProcessor {
//    String INPUT = "myTopic";
//    String OUTPUT = "myTopic";
//
//    @Input(INPUT)
//    SubscribableChannel inboundTopic();
//
//
//    @Output(OUTPUT)
//    MessageChannel outboundTopic();
//}
