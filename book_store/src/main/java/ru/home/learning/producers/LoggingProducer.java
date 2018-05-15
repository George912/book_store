package ru.home.learning.producers;

import java.util.logging.Logger;

/**
 * Механизм записи в журнал
 * Created by YANesterov on 15.05.2018.
 */
public class LoggingProducer {
    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMemeber().getDeclaringClass().getName());
    }
}
