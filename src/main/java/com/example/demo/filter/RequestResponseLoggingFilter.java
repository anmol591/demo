package com.example.demo.filter;

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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@Order(2)
public class RequestResponseLoggingFilter implements Filter {
    private final static Logger LOG = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      LOG.info("Initializing filter: {}",this);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        LOG.info("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        LOG.info("Logging Response :{}", res.getContentType());
    }

    @Override
    public void destroy() {
      LOG.warn("Destroying Filter: {}",this);
    }
}
