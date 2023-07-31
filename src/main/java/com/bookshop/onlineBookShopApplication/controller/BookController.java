package com.bookshop.onlineBookShopApplication.controller;

import com.bookshop.onlineBookShopApplication.model.BookRequestModel;
import com.bookshop.onlineBookShopApplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Object> booksCreate(@RequestBody BookRequestModel bookRequestModel){
        return bookService.createBook(bookRequestModel);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllBooks(){
        return bookService.getAllBooks();
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteBooks(@PathVariable Integer id){
        bookService.deleteBooks(id);
    }

    @GetMapping("/id/{bookId}")
    public ResponseEntity<Object> bookDetails(@PathVariable Integer bookId) {
        return bookService.bookDetails(bookId);
    }

    @GetMapping("/author/{authorName}")
    public ResponseEntity<Object> bookDetails(@PathVariable String authorName) {
        return bookService.getAuthorName(authorName);
    }

    @GetMapping("/author-title/{authorName}/{bookName}")
    public ResponseEntity<Object> bookDetails(@PathVariable String authorName,@PathVariable String bookName) {
        return bookService.getBookByAuthorName(authorName,bookName);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateBookInfo(@PathVariable Integer id, @RequestBody BookRequestModel updateBookModel, ModelAndView model) {
        return bookService.updateBookInfo(id,updateBookModel);
    }


}
