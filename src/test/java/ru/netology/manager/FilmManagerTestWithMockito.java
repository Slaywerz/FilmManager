package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmPoster;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FilmManagerTestWithMockito {
    @Mock
    FilmRepository repository;
    @InjectMocks
    FilmManager manager;

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
    public void shouldFindAll() {
        FilmPoster[] returned = new FilmPoster[]{first, second, tenth};
        doReturn(returned).when(repository).findAll();

        FilmPoster[] actual = manager.getAll();
        FilmPoster[] expected = new FilmPoster[]{tenth, second, first};
        assertArrayEquals(actual, expected);

        verify(repository).findAll();
    }

    @Test
    public void shouldRemoveAll() {
        FilmPoster[] returned = new FilmPoster[0];
        doReturn(returned).when(repository).removeAll();

        FilmPoster[] actual = manager.removeAll();
        FilmPoster[] expected = new FilmPoster[0];
        assertArrayEquals(actual, expected);

        verify(repository).removeAll();
    }
}