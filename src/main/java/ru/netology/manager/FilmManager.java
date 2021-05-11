package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.FilmPoster;
import ru.netology.repository.FilmRepository;

@NoArgsConstructor
public class FilmManager {
    private FilmRepository repository;
    private int maxShowFilms = 10;

    public FilmManager(FilmRepository repository, int maxShowFilms) {
        this.repository = repository;
        this.maxShowFilms = maxShowFilms;
    }

    public FilmManager(FilmRepository repository) {
        this.repository = repository;
    }

    public void add(FilmPoster films) {
        repository.save(films);
    }

    public FilmPoster[] getAll() {
        FilmPoster[] films = repository.findAll();
        FilmPoster[] result;

        if (films.length < maxShowFilms) {
            result = new FilmPoster[films.length];
        } else {
            result = new FilmPoster[maxShowFilms];
        }

        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }

        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public FilmPoster[] removeAll() {
        return repository.removeAll();
    }
}