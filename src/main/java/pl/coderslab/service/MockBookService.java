package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class MockBookService implements BookService{
    private List<Book> list;
    private static Long nextId = 4L;

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public static Long getNextId() {
        return nextId;
    }

    public static void setNextId(Long nextId) {
        MockBookService.nextId = nextId;
    }

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getBooks(){
        return this.list;
    }

    public Optional<Book> getBookById(long id){
         return list.stream()
                .filter(n -> n.getId()==id).findFirst();
    }

    public void add(Book book)
    {
        book.setId(nextId);
        list.add(book);
        nextId++;
    }

    public void delete(long id){
        if(getBookById(id).isPresent()){
            getList().remove(getBookById(id).get());
        }
    }

    public void update(Book book){
        if (this.getBookById(book.getId()).isPresent()) {
            int indexOf = list.indexOf(this.getBookById(book.getId()).get());
            list.set(indexOf, book);
        }
    }


}
