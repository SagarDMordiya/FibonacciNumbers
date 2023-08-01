package com.example.fibonacci.backendfibo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FiboController {

    @GetMapping("welcome")
    public String testApi(){
        return "Welcome to Controller";
    }
    
    @GetMapping("fiboNo/{n}")
    public List<Integer> getFiboNo(@PathVariable("n") Integer n){
        List<Integer> result = new ArrayList<>();
        System.out.println(n);
        return null;
    }

}
