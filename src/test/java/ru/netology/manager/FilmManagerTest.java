package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmPoster;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FilmManagerTest {
    private FilmManager manager = new FilmManager(new FilmPoster[0]);
    private final FilmPoster first = new FilmPoster(1, "Url 1", "Onward", "Cartoon");
    private final FilmPoster second = new FilmPoster(2, "Url 2", "John Wick 3", "Action");
    private final FilmPoster third = new FilmPoster(3, "Url 3", "Friends", "Serial");
    private final FilmPoster fourth = new FilmPoster(4, "Url 4", "Green Mile", "Drama");
    private final FilmPoster fifth = new FilmPoster(5, "Url 5", "Interstellar", "Fantasy");
    private final FilmPoster sixth = new FilmPoster(6, "Url 6", "Forest Gump", "Drama");
    private final FilmPoster seventh = new FilmPoster(7, "Url 7", "Pulp Fiction", "Thriller");
    private final FilmPoster eighth = new FilmPoster(8, "Url 8", "Inception", "Fantasy, Thriller");
    private final FilmPoster ninth = new FilmPoster(9, "Url 9", "Snatch", "Criminal comedy");
    private final FilmPoster tenth = new FilmPoster(10, "Url 10", "WALL-E", "Cartoon");
    private final FilmPoster eleventh = new FilmPoster(11, "Url 11", "Фильм без названия", "Пустой жанр");

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
        FilmPoster[] actual = manager.getAddedFilms();
        FilmPoster[] expected = new FilmPoster[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGetAddedFilmsUnderLimit() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        FilmPoster[] actual = manager.getAddedFilms();
        FilmPoster[] expected = new FilmPoster[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldChangeShowLimit() {
        FilmManager filmManager = new FilmManager(new FilmPoster[0], 2);
        filmManager.add(second);
        filmManager.add(third);
        filmManager.add(eighth);

        FilmPoster[] actual = filmManager.getAddedFilms();
        FilmPoster[] expected = new FilmPoster[]{eighth, third};
        assertArrayEquals(actual, expected);
    }
}