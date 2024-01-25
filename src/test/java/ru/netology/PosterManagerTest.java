package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;
import ru.netology.manager.PosterManager;

public class PosterManagerTest {
    PosterItem poster_1 = new PosterItem("Бладшот");
    PosterItem poster_2 = new PosterItem("Вперёд");
    PosterItem poster_3 = new PosterItem("Отель Белград");
    PosterItem poster_4 = new PosterItem("Джентельмены");
    PosterItem poster_5 = new PosterItem("Человек-невидимка");
    PosterItem poster_6 = new PosterItem("Тролли. Мировой тур");
    PosterItem poster_7 = new PosterItem("Номер один");

    @Test
    public void shouldFindAllItems() {
        PosterManager manager = new PosterManager();
        manager.addPoster(poster_1);
        manager.addPoster(poster_2);
        manager.addPoster(poster_3);
        manager.addPoster(poster_4);
        manager.addPoster(poster_5);
        manager.addPoster(poster_6);
        manager.addPoster(poster_7);

        PosterItem[] expected = {poster_1, poster_2, poster_3, poster_4, poster_5, poster_6, poster_7};
        PosterItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    // тест, когда в менеджере меньше фильмов, чем предустановленный лимит 5.
    @Test
    public void shouldFindLastItemsWhenPresetLimitMoreElementsAmount() {
        PosterManager manager = new PosterManager();
        manager.addPoster(poster_1);
        manager.addPoster(poster_3);
        manager.addPoster(poster_4);

        PosterItem[] expected = {poster_4, poster_3, poster_1};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    // тест, когда в менеджере фильмов больше чем предустановленный лимит 5
    @Test
    public void shouldFindLastItemsPresetLimit() {
        PosterManager manager = new PosterManager();
        manager.addPoster(poster_1);
        manager.addPoster(poster_2);
        manager.addPoster(poster_3);
        manager.addPoster(poster_4);
        manager.addPoster(poster_5);
        manager.addPoster(poster_6);
        manager.addPoster(poster_7);

        PosterItem[] expected = {poster_7, poster_6, poster_5, poster_4, poster_3};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    // тест, когда в менеджере количество фильмов равно лимиту
    @Test
    public void shouldFindLastItemsSetLimitEqualElementsAmount() {
        PosterManager manager = new PosterManager(3);
        manager.addPoster(poster_1);
        manager.addPoster(poster_2);
        manager.addPoster(poster_3);

        PosterItem[] expected = {poster_3, poster_2, poster_1};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    // тест когда в менеджере фильмов меньше чем лимит
    @Test
    public void shouldFindLastItemsWithLimitMoreElementsAmount() {
        PosterManager manager = new PosterManager(6);
        manager.addPoster(poster_1);
        manager.addPoster(poster_2);

        PosterItem[] expected = {poster_2, poster_1};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    // тест когда установленный лимит равен нулю
    @Test
    public void shouldFindLastElementsWithZeroLimit() {
        PosterManager manager = new PosterManager(0);
        manager.addPoster(poster_7);
        manager.addPoster(poster_6);
        manager.addPoster(poster_6);

        PosterItem[] expected = {};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }
}
