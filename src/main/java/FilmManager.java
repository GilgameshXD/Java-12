public class FilmManager {
    private Poster[] items = new Poster[0];


    public void addFilm(Poster item) {
        Poster[] tmp = new Poster[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
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

    public Poster[] findLast() {
        Poster[] all = findAll();
        Poster[] reversed = new Poster[5];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = all[all.length - 1 - i];
        }
        return reversed;
    }

    public Poster[] findLast(int result) {
        Poster[] all = findAll();
        Poster[] reversed = new Poster[result];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = all[all.length - 1 - i];
        }
        return reversed;
    }

}
