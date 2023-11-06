import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {

    FilmManager manager = new FilmManager();

    Poster item1 = new Poster(1, "Бладшот");
    Poster item2 = new Poster(2, "Вперёд");
    Poster item3 = new Poster(3, "Отель<Белград>");
    Poster item4 = new Poster(4, "Джентельмены");
    Poster item5 = new Poster(5, "Человек-неведимка");
    Poster item6 = new Poster(6, "Тролли. Мировой тур");
    Poster item7 = new Poster(7, "Номер один");

    @BeforeEach
    public void setup() {
        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);
        manager.addFilm(item4);
        manager.addFilm(item5);
        manager.addFilm(item6);
        manager.addFilm(item7);

    }

    @Test
    public void shouldGetItems() {

        Poster[] expected = {item1, item2, item3, item4, item5, item6, item7};
        Poster[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addFilmTest() {
        manager.addFilm(item7);

        Poster[] expected = {item1, item2, item3, item4, item5, item6, item7, item7};
        Poster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldGetDefaultValueReversedItems() {

        Poster[] expected = {item7, item6, item5, item4, item3};
        Poster[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGet1LastItem() {
        FilmManager len = new FilmManager(1);
        len.addFilm(item1);
        len.addFilm(item2);
        len.addFilm(item3);
        len.addFilm(item4);
        len.addFilm(item5);
        len.addFilm(item6);
        len.addFilm(item7);

        Poster[] expected = {item7};
        Poster[] actual = len.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGet3RLastItems() {
        FilmManager len = new FilmManager(3);
        len.addFilm(item1);
        len.addFilm(item2);
        len.addFilm(item3);
        len.addFilm(item4);
        len.addFilm(item5);
        len.addFilm(item6);
        len.addFilm(item7);

        Poster[] expected = {item7, item6, item5};
        Poster[] actual = len.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGet7LastItems() {
        FilmManager len = new FilmManager(7);
        len.addFilm(item1);
        len.addFilm(item2);
        len.addFilm(item3);
        len.addFilm(item4);
        len.addFilm(item5);
        len.addFilm(item6);
        len.addFilm(item7);

        Poster[] expected = {item7, item6, item5, item4, item3, item2, item1};
        Poster[] actual = len.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        manager.removeById(item2.getId());
        manager.removeById(item3.getId());

        Poster[] expected = {item1, item4, item5, item6, item7};
        Poster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
