package com.bookshop.onlineBookShopApplication.service;

import com.bookshop.onlineBookShopApplication.model.BookRequestModel;
import org.springframework.http.ResponseEntity;

public interface BookService {
    ResponseEntity<Object> createBook(BookRequestModel bookRequestModel);
    ResponseEntity<Object> getAllBooks();
    void deleteBooks(Integer bookId);
    ResponseEntity<Object> bookDetails( Integer bookId) ;
    ResponseEntity<Object> getAuthorName(String authorName);
    ResponseEntity<Object> getBookByAuthorName(String authorName, String bookName);
    ResponseEntity<Object> updateBookInfo( Integer id,BookRequestModel updateBookModel) ;
}
