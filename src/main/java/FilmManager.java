public class FilmManager {
    private int result;
    private Poster[] items = new Poster[0];

    public void addFilm(Poster item) {
        Poster[] tmp = new Poster[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Poster[] findAll() {
        return items;
    }

    public Poster[] removeById(int id) {
        Poster[] tmp = new Poster[items.length - 1];
        int copyToIndex = 0;
        for (Poster item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
        return tmp;
    }

    public FilmManager() {
        result = 5;
    }

    public FilmManager(int resultLength) {
        if (resultLength == 0) {
            result = 1;
        } else {
            result = resultLength;
        }
    }

    public Poster[] findLast() {
        Poster[] all = findAll();
        int resultLength;
        if (result < all.length) {
            resultLength = result;
        } else {
            resultLength = all.length;
        }
        Poster[] result = new Poster[resultLength];
        for (int i = 0; i < result.length; i++) {
            result [i] = all[all.length - 1 - i];
        }
        return result;
    }
}
