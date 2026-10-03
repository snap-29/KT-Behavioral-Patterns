package org.example.patterns;

interface BookIterator {

    boolean hasNext();

    String next();
}

class Library {

    private final String[] books = {
            "Чистый код",
            "Java. Эффективное программирование",
            "Паттерны проектирования",
            "Алгоритмы"
    };

    public BookIterator iterator() {
        return new LibraryIterator();
    }

    private class LibraryIterator
            implements BookIterator {

        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < books.length;
        }

        @Override
        public String next() {

            if (!hasNext()) {
                throw new IllegalStateException(
                        "Книг больше нет"
                );
            }

            return books[position++];
        }
    }
}

public class IteratorExample {

    public static void main(String[] args) {

        Library library = new Library();

        BookIterator iterator =
                library.iterator();

        while (iterator.hasNext()) {

            String book = iterator.next();

            System.out.println(
                    "Книга: " + book
            );
        }
    }
}