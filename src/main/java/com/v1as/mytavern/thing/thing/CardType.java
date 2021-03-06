package com.v1as.mytavern.thing.thing;

public enum CardType {

    THING("Вы Нечто"),
    INFECT("Вы заражены"),
    //=============================
    SUSPECTION("Бросить подозрение"),
    ANALYS("Проанализировать"),
    //=============================
    RUN("Сматывать удочки"), // Сматывай удочки
    GOOD_HERE("Остаться на месте"), // Мне и здесь неплохо
    CHANGE_SIT("Поменяться местами"), // Меняемся местами
    //=============================
    DOOR("Заколоченная дверь"), // Заколоченная дверь
    AXE("Разбить дверь"), // Топор
    //=============================
    TEMPTATION("Соблазнить"), //соблазн
    NO_THANK_YOU("Нет, спасибо"),
    MISS("Мимо!"),
    //=============================
    WHISKEY("Выпить виски"),
    //=============================
    QUARANTINE("Посадить на карантин"),
    //=============================
    PERSISTENCE("Упорствовать"), // Упорство
    //=============================
    NO_KEBAB("Никакого шашлычка!"),
    //=============================
    FLAMETHROWER("Спалить!"),
    //=============================
    WATCH_AROUND("Оглядеться");
    //=============================

    private final String shortName;

    CardType(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}
