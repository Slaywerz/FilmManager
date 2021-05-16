package ru.netology.manager;

import ru.netology.domain.FilmPoster;

public class FilmManager {
    private FilmPoster[] films;
    private int maxShowFilm = 10;

    public FilmManager(FilmPoster[] films) {
        this.films = films;
    }

    public FilmManager(int maxShowFilm) {
        this.maxShowFilm = maxShowFilm;
    }

    public void add(FilmPoster film) {
        int length = films.length + 1;
        FilmPoster[] tmp = new FilmPoster[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public FilmPoster[] getAddedFilms() {
        FilmPoster[] result;
        if (films.length < maxShowFilm) {
            result = new FilmPoster[films.length];
        } else {
            result = new FilmPoster[maxShowFilm];
        }

        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}