package pl.coderslab.controllers;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;


@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping("/helloBook")
    public Book helloBook() {
        Book book = new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming");
        return book;
    }
}

