package ru.home.learning.generators.impl;

import ru.home.learning.generators.api.NumberGenerator;
import ru.home.learning.interceptors.bindings.Loggable;
import ru.home.learning.qualifiers.ThirteenDigits;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Генерирует тринадцатизначный номер
 * Created by YANesterov on 15.05.2018.
 */
@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {
    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String isbn = "13-84356-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован ISBN : " + isbn);
        return isbn;
    }
}