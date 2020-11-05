package com.example.demo.controller;

import com.example.demo.entity.TestEntity;
import org.apache.commons.lang3.StringUtils;
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
    public String hii(TestEntity request){
        //TestEntity entity = new TestEntity();
//        System.out.println("starting validation");
//        Set<ConstraintViolation<TestEntity>> violations = beanValidator.validate(request);
//        if(CollectionUtils.isNotEmpty(violations)){
//            return violations.iterator().next().getMessage();
//        }
        if(StringUtils.isBlank(request.getJwt())){
            return "306";
        }
        return "hhhh";
    }
}
