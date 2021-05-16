package ru.netology.repository;

import ru.netology.domain.FilmPoster;

public class FilmRepository {
    private FilmPoster[] films = new FilmPoster[0];

    public void save(FilmPoster film) {
        int length = films.length + 1;
        FilmPoster[] tmp = new FilmPoster[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public FilmPoster[] findAll() {
        return films;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        FilmPoster[] tmp = new FilmPoster[length];
        int index = 0;
        for (FilmPoster film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }

    public FilmPoster[] removeAll() {
        return films;
    }
}
