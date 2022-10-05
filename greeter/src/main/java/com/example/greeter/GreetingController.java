package com.example.greeter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${message:value was not read from config server}")
    private String message;

    @Value("${key:not from config server}")
    private String key;

    @GetMapping("/")
    public String greet()
    {
        return message;
    }

    @GetMapping("/key")
    public String key()
    {
        return key;
    }
}




// Deploy to ASA standard

//  az spring config-server git set -n standard --label main --uri https://github.com/practical-microservices/spring-cloud-config-basics-repo.git
//  az spring config-server git repo add --repo-name sensitive -n standard --label main --uri https://github.com/practical-microservices/spring-cloud-config-basics-repo-sensitive.git

// az spring app create -n greeter -s standard -g demo --assign-endpoint true
// az spring app deploy -n greeter -s standard -g demo  --artifact-path greeter/target/greeter-0.0.1-SNAPSHOT.jar  --runtime-version Java_17
// az spring app logs -n greeter -s standard -g demo

// Deploy to ASA-E

// az spring  application-configuration-service git repo add -n demo-asa -g demo --label main --uri https://github.com/practical-microservices/spring-cloud-config-basics-repo.git
// az spring  application-configuration-service bind -g demo -s demo-asa --app greeter

// az spring app create -n greeter -s demo-asa -g demo --assign-endpoint true
// az spring app deploy -n greeter -s demo-asa -g demo  --artifact-path greeter/target/greeter-0.0.1-SNAPSHOT.jar
// az spring app logs -n greeter -s demo-asa -g demo
