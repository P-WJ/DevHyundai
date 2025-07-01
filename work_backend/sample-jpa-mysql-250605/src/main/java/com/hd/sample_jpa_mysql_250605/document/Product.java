package com.hd.sample_jpa_mysql_250605.document;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    private String id;
    private String name;
    private int price;
    private int quantity;
}
