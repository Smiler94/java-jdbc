package com.jdbcDemo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodeFilter implements Filter{
    public void init(FilterConfig config)
    {

    }

    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws ServletException, IOException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        req.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }
}
