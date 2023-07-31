package com.bookshop.onlineBookShopApplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequestModel {
    private Integer bookId;
    private String bookName;
    private String authorName;
    private Integer price;
    private  Integer quantity;

}
