package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.PosterFilms;

@NoArgsConstructor
public class FilmManager {
  private PosterFilms[] films = new PosterFilms[0];

  public void add(PosterFilms item) {
    int length = films.length + 1;
    PosterFilms[] tmp = new PosterFilms[length];
    System.arraycopy(films, 0, tmp, 0, films.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    films = tmp;
  }

  public PosterFilms[] getAddedFilms() {
    int maxShowFilms = 10;
    PosterFilms[] result = new PosterFilms[films.length];
    if (films.length > maxShowFilms) {
      result = new PosterFilms[maxShowFilms];
    }
    for (int i = 0; i < result.length; i++) {
      int index = films.length - i - 1;
      result[i] = films[index];
    }
    return result;
  }
}