package com.lx.emp.aop;

import com.lx.emp.dao.SysLoggerMapper;
import com.lx.emp.pojo.SysLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLoggerMapper sysLoggerMapper;

    @Pointcut("@annotation(com.lx.emp.annotation.OperationLogDetail)")
    public void operationLog() {
    }


    /**
     *环绕通知,环绕增强
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("operationLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            //如果不执行这句，会不执行切面的Before方法及controller的业务方法
            Object o =  joinPoint.proceed();
            System.out.println("@Around执行");
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("operationLog()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("@Before执行");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        SysLogger sysLogger = new SysLogger();
        String url =  request.getRequestURL().toString();
        String requestMethod = request.getMethod();
        String host = request.getRemoteAddr();
        String class_method =  joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        String params = Arrays.toString(joinPoint.getArgs());
        sysLogger.setAddress(url);
        sysLogger.setCreateDate(new Date());
        sysLogger.setMethod(class_method);
        sysLogger.setParams(params);
        sysLogger.setHost(host);
        sysLogger.setRequestMethod(requestMethod);
        sysLoggerMapper.insertSelective(sysLogger);
    }

    /**
     * @Description: 后置返回通知
     */
    @AfterReturning(returning = "ret", pointcut = "operationLog()")
    public void afterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("@AfterReturning执行");
    }

    /**
     * 后置异常通知
     */
    @AfterThrowing("operationLog()")
    public void throwss(JoinPoint jp) {
        System.out.println("@AfterThrowing执行.....");
    }


    /**
     * 后置通知
     * @param jp
     */
    @After("operationLog()")
    public void after(JoinPoint jp) {
        System.out.println("@After执行.....");
    }

}
