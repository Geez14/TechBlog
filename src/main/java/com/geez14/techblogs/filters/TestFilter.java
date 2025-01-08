package com.geez14.techblogs.filters;

import jakarta.servlet.GenericFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

public class TestFilter extends GenericFilter {
    static AtomicLong userVisits = new AtomicLong(0);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        userVisits.incrementAndGet();
        ((HttpServletRequest) request).getSession().setAttribute("total-requests", userVisits.get());
        chain.doFilter(request, response);
    }
}
