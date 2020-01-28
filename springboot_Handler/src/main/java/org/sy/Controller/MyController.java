package org.sy.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello(){
        log.debug("hello Run.................");
        return "hello";
    }
}
