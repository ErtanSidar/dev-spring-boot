package com.essoft.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    /*
    If you add devtools dependency to your project and you save your code, your code automatically will update
    If you want to get some information about your app, you can use actuator
    Some examples url about get detail about app
    http://localhost:8080/actuator/health => "status":"UP"
    http://localhost:8080/actuator/info => default empty {},
    if you add some info about your app in application.properties after that you can see infos like this {"app":{"name":"My Super Cool App","description":"A crazy fun app","version":"1.0.0"}}
    */

    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day.";
    }
}
