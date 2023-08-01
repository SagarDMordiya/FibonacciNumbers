package com.example.fibonacci.backendfibo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FiboController {

    @Autowired
    private FiboDataService fiboDataService;

    public FiboController(FiboDataService fiboDataService) {
        this.fiboDataService = fiboDataService;
    }

    // To test the application is running
    // to be deleted
    @GetMapping("welcome")
    public String testApi() {
        return "Welcome to Controller";
    }

    // To get the first N Fibonacci Numbers
    @GetMapping("fiboNo/{n}")
    public List<Long> getFiboNo(@PathVariable("n") Integer n) throws Exception {
        if (n <= 0)
            throw new ArithmeticException("Value Should be Greater than 0");
        List<Long> result = fiboDataService.getFiboNo(n);
        if (result.isEmpty()) {
            throw new Exception("Error occured");
        } else
            return result;
    }

    // To check the data in the Database
    @GetMapping("getAllFiboData")
    public List<FiboDataModel> getAllFiboData() {
        return fiboDataService.getAllFiboData();
    }

}
