package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;
import ru.netology.manager.PosterManager;

public class PosterManagerTest {

    PosterManager manager = new PosterManager();

    PosterItem poster_1 = new PosterItem("Бладшот");
    PosterItem poster_2 = new PosterItem("Вперёд");
    PosterItem poster_3 = new PosterItem("Отель Белград");
    PosterItem poster_4 = new PosterItem("Джентельмены");
    PosterItem poster_5 = new PosterItem("Человек-невидимка");
    PosterItem poster_6 = new PosterItem("Тролли. Мировой тур");
    PosterItem poster_7 = new PosterItem("Номер один");

    @BeforeEach
    public void setup() {
        manager.addPoster(poster_1);
        manager.addPoster(poster_2);
        manager.addPoster(poster_3);
        manager.addPoster(poster_4);
        manager.addPoster(poster_5);
        manager.addPoster(poster_6);
        manager.addPoster(poster_7);
    }

    @Test
    public void shouldFindAllItems() {
        PosterItem[] expected = {poster_1, poster_2, poster_3, poster_4, poster_5, poster_6, poster_7};
        PosterItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastItems() {
        PosterItem[] expected = {poster_7, poster_6, poster_5, poster_4, poster_3};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindLastItemsWithLength() {
        PosterItem[] expected = {poster_7, poster_6, poster_5};
        PosterItem[] actual = manager.findLast(3);

        Assertions.assertArrayEquals(expected, actual);
    }


}
