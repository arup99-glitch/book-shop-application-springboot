package com.bookshop.onlineBookShopApplication.service.impl;

import com.bookshop.onlineBookShopApplication.entity.BookEntity;
import com.bookshop.onlineBookShopApplication.model.BookRequestModel;
import com.bookshop.onlineBookShopApplication.model.BookResponseModel;
import com.bookshop.onlineBookShopApplication.repository.BookRepository;
import com.bookshop.onlineBookShopApplication.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    @Autowired
    private final BookRepository bookRepository;

    @Override
    public ResponseEntity<Object> createBook(BookRequestModel bookRequestModel) {
        BookEntity bookEntity = BookEntity.builder()
                .bookName(bookRequestModel.getBookName())
                .authorName(bookRequestModel.getAuthorName())
                .price(bookRequestModel.getPrice())
                .quantity(bookRequestModel.getQuantity())
                .build();
        BookEntity savedBook = bookRepository.save(bookEntity);
        BookResponseModel bookResponseModel = BookResponseModel.builder()
                .bookId(savedBook.getBookId())
                .bookName(savedBook.getBookName())
                .authorName(savedBook.getAuthorName())
                .price(savedBook.getPrice())
                .quantity(savedBook.getQuantity())
                .build();
        return new ResponseEntity<>(bookResponseModel, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getAllBooks() {
        List<BookEntity> BookList = bookRepository.findAll();
        List<BookResponseModel> responseList = new ArrayList<>();
        for (BookEntity book : BookList) {
            BookResponseModel bookResponseModel = BookResponseModel.builder()
                    .bookId(book.getBookId())
                    .bookName(book.getBookName())
                    .authorName(book.getAuthorName())
                    .price(book.getPrice())
                    .quantity(book.getQuantity())
                    .build();
            responseList.add(bookResponseModel);
        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    public void deleteBooks(Integer bookId) {
        BookEntity bookEntity = bookRepository.findByBookId(bookId);
        if (bookEntity != null) {
            bookRepository.delete(bookEntity);
        }
    }

    public ResponseEntity<Object> bookDetails(Integer bookId) {
        BookEntity bookEntity = bookRepository.findByBookId(bookId);
        if (bookEntity != null) {
            BookResponseModel bookResponseModel = BookResponseModel.builder()
                    .bookId(bookEntity.getBookId())
                    .bookName(bookEntity.getBookName())
                    .authorName(bookEntity.getAuthorName())
                    .price(bookEntity.getPrice())
                    .quantity(bookEntity.getQuantity())
                    .build();
            return new ResponseEntity<>(bookResponseModel, HttpStatus.OK);
        }
        return new ResponseEntity<>(new RuntimeException("Nothing Found"), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> getAuthorName(String authorName) {
        List<BookEntity> authorList = bookRepository.findAllByAuthorName(authorName);
        List<BookResponseModel> responseList = new ArrayList<>();
        for (BookEntity book : authorList) {
            BookResponseModel bookResponseModel = BookResponseModel.builder()
                    .bookId(book.getBookId())
                    .bookName(book.getBookName())
                    .authorName(book.getAuthorName())
                    .price(book.getPrice())
                    .quantity(book.getQuantity())
                    .build();
            responseList.add(bookResponseModel);
        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    public ResponseEntity<Object> updateBookInfo(Integer bookId, BookRequestModel updateBookModel) {
        BookEntity bookEntity = bookRepository.findByBookId(bookId);
        if (bookEntity != null) {
            bookEntity.setBookName(updateBookModel.getBookName());
            bookEntity.setAuthorName(updateBookModel.getAuthorName());
            bookEntity.setPrice(updateBookModel.getPrice());
            bookEntity.setQuantity(updateBookModel.getQuantity());
            bookRepository.save(bookEntity);
            return new ResponseEntity<>(bookEntity, HttpStatus.OK);
        }
        return new ResponseEntity<>(new RuntimeException("Doesn't match authorName and book Name"), HttpStatus.BAD_GATEWAY);
    }

    public ResponseEntity<Object> getBookByAuthorName(String authorName, String bookName) {
        BookEntity bookEntity = bookRepository.findByAuthorNameAndBookName(authorName, bookName);
        if (bookEntity != null) {
            return new ResponseEntity<>(bookEntity, HttpStatus.OK);
        }
        return new ResponseEntity<>(new RuntimeException("Doesn't match authorName and book Name"), HttpStatus.BAD_GATEWAY);
    }
}



