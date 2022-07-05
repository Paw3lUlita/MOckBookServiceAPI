package pl.coderslab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.beans.Book;
import pl.coderslab.service.MockBookService;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/helloBook")
    public pl.coderslab.beans.Book helloBook() {
        return new pl.coderslab.beans.Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return mockBookService.getAllBooks();
    }


}

