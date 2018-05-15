package ru.home.learning.generators.impl;

import ru.home.learning.generators.api.NumberGenerator;

import java.util.Random;
import java.util.logging.Logger;

/**
 * Генерирует восьмизначный номер
 * Created by YANesterov on 15.05.2018.
 */
public class IssnGenerator implements NumberGenerator {
    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован ISSN : " + issn);
        return issn;
    }
}
