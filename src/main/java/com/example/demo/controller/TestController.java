package com.example.demo.controller;

import com.example.demo.entity.SubscriptionEntity;
import com.example.demo.entity.TestEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;

@Path("/test")
public class TestController {

    @Autowired
    private Validator beanValidator;

    @GetMapping("/hii")
    public String hii(@RequestBody TestEntity request){
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

    @POST
    @Path("/hello")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(@Context HttpServletRequest httpServletRequest, @RequestParam MultivaluedMap<String,String> paramMap){
       String str = "my name is anmol";
       return Response.ok().entity(str).build();
    }

    private Response getResponse(){
       String str = "Successfully Merged :3; Duplicate Records :0; Failed Records :0";
       return Response.ok().entity(str).build();
    }
}
