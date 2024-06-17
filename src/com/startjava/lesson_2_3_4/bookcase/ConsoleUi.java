package com.startjava.lesson_2_3_4.bookcase;

public class ConsoleUi {
    protected final String emptyBookcase = "Шкаф пуст.";
    protected final String fullBookcase = "Шкаф полон.";
    protected final String booksAmount = "В шкафу книг:";
    protected final String emptyShelves = "Свободно полок:";
    protected final String setAuthor = "Введите имя автора: ";
    protected final String setTitle = "Введите название книги: ";
    protected final String setYearEstablishment = "Введите год выпуска: ";
    protected final String chooseOptions = "Введите пункт меню: ";
    protected final String separator = "--------------------------------------------------";
    protected final String pressEnter = "Продолжить <Enter>";
    protected final String chooseShelf = "Введите номер полки: ";
    protected final String wrongShelfInput = "Неверно указан № полки. Занято полок: ";
    protected final String searchResult = "Подходящие варианты:";
    protected final String findNothing = "Поск не дал результатов.";
    protected final String mainMenu = """
                Книжный шкаф.
                1. Осмотреть
                2. Добавить
                3. Удалить
                4. Поиск
                5. Завершить
                """;
    protected final String addBook = """
                1. Добавить книгу
                2. Главное меню
                """;
    protected final String deleteBook = """
                1. Удалить книгу
                2. Очистить шкаф
                3. Главное меню
                """;
}
