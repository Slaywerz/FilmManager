package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterFilms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FilmManagerTest {
    private FilmManager manager = new FilmManager();
    private final PosterFilms first = new PosterFilms(1, "Url 1", "Onward", "Cartoon");
    private final PosterFilms second = new PosterFilms(2, "Url 2", "John Wick 3", "Action");
    private final PosterFilms third = new PosterFilms(3, "Url 3", "Friends", "Serial");
    private final PosterFilms fourth = new PosterFilms(4, "Url 4", "Green Mile", "Drama");
    private final PosterFilms fifth = new PosterFilms(5, "Url 5", "Interstellar", "Fantasy");
    private final PosterFilms sixth = new PosterFilms(6, "Url 6", "Forest Gump", "Drama");
    private final PosterFilms seventh = new PosterFilms(7, "Url 7", "Pulp Fiction", "Thriller");
    private final PosterFilms eighth = new PosterFilms(8, "Url 8", "Inception", "Fantasy, Thriller");
    private final PosterFilms ninth = new PosterFilms(9, "Url 9", "Snatch", "Criminal comedy");
    private final PosterFilms tenth = new PosterFilms(10, "Url 10", "WALL-E", "Cartoon");
    private final PosterFilms eleventh = new PosterFilms(11, "Url 11", "Фильм без названия", "Пустой жанр");

    @Test
    public void shouldGetAddedFilmsOverLimit() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        PosterFilms[] actual = manager.getAddedFilms();
        PosterFilms[] expected = new PosterFilms[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGetAddedFilmsUnderLimit() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        PosterFilms[] actual = manager.getAddedFilms();
        PosterFilms[] expected = new PosterFilms[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }
}