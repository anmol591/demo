package com.example.demo.filter;

import com.example.demo.exception.RequestErrorException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class TransactionFilter implements Filter {

    private final static Logger LOG = LoggerFactory.getLogger(TransactionFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
     LOG.info("Initializing Transaction Filter: {}",this);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        LOG.info("Starting Transaction for req :{}", req.getRequestURI());

//        String countryCode = req.getHeader("X-Country-Code");
//        if(StringUtils.isBlank(countryCode)){
//            throw new RequestErrorException("country code is empty");
//        }
//
//        if(!"IND".equalsIgnoreCase(countryCode)){
//            throw new RequestErrorException("Other country except india is not allowed");
//        }
        chain.doFilter(servletRequest, servletResponse);
        LOG.info("Committing Transaction for req :{}", req.getRequestURI());
    }

    @Override
    public void destroy() {
      LOG.info("Destroying Transaction filter: {}",this);
    }
}
