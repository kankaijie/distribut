package com.org.tx.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class MyZuulFilter extends ZuulFilter {


    /***
     * 前置过滤
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /***
     *优先级为0，数字越大，优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 5;
    }

    /***
     * 是否执行该过滤器，此处为true，说明需要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /***
     * 用于拦截请求(用于token校验)
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //获取应用程序上下文
        RequestContext requestContext=RequestContext.getCurrentContext();
        HttpServletRequest request=requestContext.getRequest();
        String toke=request.getParameter("token");
        if(StringUtils.isEmpty(toke)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("{\"result\":\"password is not correct!\"}");
            requestContext.set("isSuccess", false);
        }

        return null;
    }
}
