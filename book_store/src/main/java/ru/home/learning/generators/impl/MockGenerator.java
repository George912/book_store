package ru.home.learning.generators.impl;

import ru.home.learning.generators.api.NumberGenerator;

import java.util.Random;
import java.util.logging.Logger;

/**
 * Имитационный генератор чисел, применяемый
 * в качестве альтернативы
 * тринадцатизначного числа
 * Created by YANesterov on 15.05.2018.
 */
@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {
    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String mock = "MOCK-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован Mock : " + mock);
        return mock;
    }
}
