package com.bookshop.onlineBookShopApplication.repository;


import com.bookshop.onlineBookShopApplication.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
        BookEntity findByBookId(Integer bookId);
        BookEntity findByBookName(String bookName);
        List<BookEntity> findAllByAuthorName(String authorName);
        BookEntity findByAuthorNameAndBookName(String authorName,String bookName);
}
