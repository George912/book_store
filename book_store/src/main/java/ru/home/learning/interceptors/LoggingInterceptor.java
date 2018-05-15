package ru.home.learning.interceptors;

import java.util.logging.Logger;

/**
 * Перехватчик записывает в журнал методы при входе и при выходе
 * Created by YANesterov on 15.05.2018.
 */
@Interceptor
@Loggable
public class LoggingInterceptor {
    @Inject
    private Logger logger;

    @AroundInvoke
    public Object logMethod(InvocationContext context) throws Exception {
        logger.entering(context.getTarget().getClass().getName()
                , context.getMethod().getName());
        try {
            return context.proceed();
        } finally {
            logger.exiting(context.getTarget().getClass().getName()
                    , context.getMethod().getName());
        }
    }
}
