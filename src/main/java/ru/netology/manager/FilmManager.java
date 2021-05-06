package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.PosterFilms;
import ru.netology.repository.FilmRepository;

@NoArgsConstructor
public class FilmManager {
  private FilmRepository repository;

  public FilmManager(FilmRepository repository) {
    this.repository = repository;
  }

  public void add(PosterFilms films){
    repository.save(films);
  }

  public PosterFilms[] getAll(){
    int maxShowFilms = 10;
    PosterFilms[] films = repository.findAll();
    PosterFilms[] result = new PosterFilms[films.length];

    if (films.length > maxShowFilms) {
      result = new PosterFilms[maxShowFilms];
    }

    for (int i = 0; i < result.length; i++) {
      int index = films.length -i - 1;
      result[i] = films[index];
    }

    return result;
  }

  public void removeById(int id){
    repository.removeById(id);
  }

  public void removeAll(){
    repository.removeAll();
  }
}