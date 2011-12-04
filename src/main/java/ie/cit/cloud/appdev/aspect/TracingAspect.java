package ie.cit.cloud.appdev.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.*;
import ie.cit.cloud.appdev.EmployeeService;

@Aspect
@Component
public class TracingAspect {

    Log log = LogFactory.getLog(TracingAspect.class);
    
    // Function Name = trace
    // Any classes that is annotated with repository in the pacakage ie.cit..*
    // Taking any method
    @Before("execution(* (@org.springframework.stereotype.Repository ie.cit..*).*(..))")
    public void traceRepositoryCalls(JoinPoint jp, Object repo) {
    	String clazz = repo.getClass().getName();
    	String method = jp.getSignature().getName();
    	log.trace("Repository Layer Calls to method invoked:" + clazz + "#" + method);
    }
    
    @Pointcut("execution(* ie.cit.cloud.appdev.*(..))")
    public void traceServiceGetCalls(JoinPoint jp, Object repo) {
    	String clazz = repo.getClass().getName();
    	String method = jp.getSignature().getName();
    	log.trace("Service Layer Getter Calls method invoked:" + clazz + "#" + method);
    }
    
    @Pointcut("execution(* ie.cit.cloud..EmployeeServiceImpl.add*(..))")
    public void traceServiceAddCalls(JoinPoint jp, Object repo) {
    	String clazz = repo.getClass().getName();
    	String method = jp.getSignature().getName();
    	log.trace("Service Layer Insert Calls method invoked:" + clazz + "#" + method);
    }

}