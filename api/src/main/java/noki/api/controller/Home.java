package noki.api.controller;

import noki.api.domain.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class Home {

    @GetMapping
    public String home(){
        return "Meu portifolio";
    }
}
