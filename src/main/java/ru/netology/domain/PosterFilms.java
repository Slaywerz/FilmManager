package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PosterFilms {
  private int id;
  private String imageUrl;
  private String filmName;
  private String genre;
}