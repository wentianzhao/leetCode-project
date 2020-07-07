package com.wentzh.projectboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@RestController
@SpringBootApplication
public class ProjectBootApplication {

    /*@RequestMapping("index")
    public String index(){
        return "hello world!";
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ProjectBootApplication.class, args);
    }

}
