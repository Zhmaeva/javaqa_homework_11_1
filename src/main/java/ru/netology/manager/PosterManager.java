package ru.netology.manager;

import ru.netology.domain.PosterItem;

public class PosterManager {
    private PosterItem[] allPosters = new PosterItem[0];

    // добавление фильма
    public void addPoster(PosterItem item) {
        PosterItem[] tmp = new PosterItem[allPosters.length + 1];
        for (int i = 0; i < allPosters.length; i++) {
            tmp[i] = allPosters[i];
        }
        tmp[tmp.length - 1] = item;
        allPosters = tmp;
    }

    // вывод фильмов в порядке добавления
    public PosterItem[] findAll() {
        PosterItem[] posters = allPosters;
        PosterItem[] tmp = new PosterItem[posters.length];
        for (int i = 0; i < posters.length; i++) {
            tmp[i] = posters[i];
        }
        posters = tmp;

        return posters;
    }

    // вывод 5 последних добавленных фильмов в обратном от добавления порядке
    public PosterItem[] findLast() {
        PosterItem[] posters = allPosters;
        PosterItem[] lastPosters = new PosterItem[Math.min(posters.length, 5)];
        for (int i = 0; i < lastPosters.length; i++) {
            lastPosters[i] = posters[posters.length - i - 1];
        }

        return lastPosters;
    }

    // вывод установленного лимит* штук последних добавленных фильмов в обратном порядке
    public PosterItem[] findLast(int length) {
        PosterItem[] posters = allPosters;
        PosterItem[] lastPosters = new PosterItem[Math.min(posters.length, length)];
        for (int i = 0; i < lastPosters.length; i++) {
            lastPosters[i] = posters[posters.length - i - 1];
        }

        return lastPosters;
    }
}
