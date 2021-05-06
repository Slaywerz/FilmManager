package ru.netology.repository;

import ru.netology.domain.PosterFilms;

public class FilmRepository {
    private PosterFilms[] films = new PosterFilms[0];

    public void save(PosterFilms film) {
        int length = films.length + 1;
        PosterFilms[] tmp = new PosterFilms[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public PosterFilms[] findAll() {
        return films;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        PosterFilms[] tmp = new PosterFilms[length];
        int index = 0;
        for (PosterFilms film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }

    public PosterFilms[] removeAll() {
        return films;
    }
}
