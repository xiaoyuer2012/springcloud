package com.demo.springcloud;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class TokenFilter  extends ZuulFilter {
    //四种类型：pre,routing,error,post
    //pre：主要用在路由映射的阶段是寻找路由映射表的
    //routing:具体的路由转发过滤器是在routing路由器，具体的请求转发的时候会调用
    //error:一旦前面的过滤器出错了，会调用error过滤器。
    //post:当routing，error运行完后才会调用该过滤器，是在最后阶段的
    @Override
    public String filterType() {
        return "pre";
    }
    //自定义过滤器执行的顺序，数值越大越靠后执行，越小就越先执行
    @Override
    public int filterOrder() {
        return 0;
    }
    //控制过滤器生效不生效，可以在里面写一串逻辑来控制
    @Override
    public boolean shouldFilter() {
        return false;
    }
    //执行过滤逻辑
    @Override
    public Object run() throws ZuulException {
        try{
            RequestContext context = RequestContext.getCurrentContext();
            HttpServletRequest request = context.getRequest();
            String token = request.getParameter("token");
            if (token == null){
                context.setSendZuulResponse(false);
                context.setResponseStatusCode(401);
                context.setResponseBody("unAuthrized");
                return null;
            }
        }catch(Exception e){
            RequestContext context = RequestContext.getCurrentContext();
            context.set("error.status_code",401);
            context.set("error.exception",e);
            context.set("error.message",e.getMessage());
        }


        return null;
    }
}
