package conatus.common;

import conatus.ChattingApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ChattingApplication.class })
public class CucumberSpingConfiguration {}
