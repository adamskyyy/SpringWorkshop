package pl.coderslab.controllers;

import org.springframework.context.annotation.Bean;
import pl.coderslab.model.Book;
import java.util.List;
import java.util.Optional;


public interface BookInterface {
    List<Book> getBooks();

    void addBook(Book book);

    void deleteBook(Long id);

    Optional<Book> get(Long id);

    void updateBook(Book book);
}
