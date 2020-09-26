package com.example.demo.controller;

import com.example.demo.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private Validator beanValidator;

    @GetMapping("/hii")
    public String hii(HttpServletRequest request){
        TestEntity entity = new TestEntity();
        Set<ConstraintViolation<TestEntity>> violations = beanValidator.validate(entity);
        if(CollectionUtils.isNotEmpty(violations)){
            return violations.iterator().next().getMessage();
        }
        return "hhhh";
    }
}
