package pl.javastart.interceptors;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@TimeLogger
@Interceptor
public class TimeLoggerInterceptor {
    @AroundInvoke
    public Object aroundInvoke(InvocationContext ic) throws Exception {
        Instant start = Instant.now();
        try {
            return ic.proceed();
        } finally {
            Duration duration = Duration.between(start, Instant.now());
            Method method = ic.getMethod();
            System.out.printf("%s.%s() method execution time: %dms \n", 
                    method.getDeclaringClass().getSimpleName(),
                    method.getName(), duration.toMillis());
        }
    }
}
