package pl.coderslab.service;

import pl.coderslab.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getBooks();

    Optional<Book> getBookById(long id);

    void add(Book book);

    void delete(long id);

    void update(Book book);
}
