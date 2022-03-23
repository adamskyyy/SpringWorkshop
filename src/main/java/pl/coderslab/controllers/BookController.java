package pl.coderslab.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.datasource.MockbookService;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/books")
public class BookController {

    private MockbookService mockbookService = new MockbookService();
    private List<Book> books = mockbookService.getBooks();

    @GetMapping("/helloBook")
    public Book helloBook() {
        Book book = new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming");
        return book;
    }

    @GetMapping("")
    public List<Book> getBooks() {
        return books;
    }


    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return this.mockbookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ni ma");
        });
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        books.add(book);
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        mockbookService.deleteBook(id);
    }

    


}

