package com.zan.hu.sys.filter;

import com.zan.hu.mybatis.sql.SqlThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-05-19 11:27
 * @Description todo
 **/
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class ParamFilter implements Filter {

    @Autowired
    private SqlThreadLocal sqlThreadLocal;

    // 在业务处理器处理请求之前被调用
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    // 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest.getAttribute("tenantId") != null) {
            sqlThreadLocal.getThreadLocal().set(servletRequest.getAttribute("tenantId").toString());
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    // 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    @Override
    public void destroy() {
        sqlThreadLocal.getThreadLocal().set("");
    }
}
