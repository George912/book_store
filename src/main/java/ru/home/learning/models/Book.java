package ru.home.learning.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * POJO-объект "Книга"
 * Created by YANesterov on 15.05.2018.
 */
@Entity
@NamedQuery(name = "Book.findAllBooks", query = "SELECT b FROM Book b")
public class Book implements Serializable {
    public static final String FIND_ALL = "Book.findAllBooks";
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(nullable = false)
    private String title;
    private Float price;
    @Size(max = 2000)
    @Column(length = 2000)
    private String description;
    private String isbn;
    private Integer nbOfPage;
    private Boolean illustrations;

    public Book() {
    }

    public Book(String title) {
        this();
        this.title = title;
    }

    public Book(String title, Float price) {
        this(title);
        this.price = price;
    }

    public Book(String title, Float price, String description) {
        this(title, price);
        this.description = description;
    }

    public Book(String title, Float price, String description, String isbn) {
        this(title, price, description);
        this.isbn = isbn;
    }

    public Book(String title, Float price, String description, String isbn, Integer nbOfPage) {
        this(title, price, description, isbn);
        this.nbOfPage = nbOfPage;
    }

    public Book(String title, Float price, String description, String isbn, Integer nbOfPage, Boolean illustrations) {
        this(title, price, description, isbn, nbOfPage);
        this.illustrations = illustrations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNbOfPage() {
        return nbOfPage;
    }

    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }

    public Boolean getIllustrations() {
        return illustrations;
    }

    public void setIllustrations(Boolean illustrations) {
        this.illustrations = illustrations;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", price=").append(price);
        sb.append(", description='").append(description).append('\'');
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", nbOfPage=").append(nbOfPage);
        sb.append(", illustrations=").append(illustrations);
        sb.append('}');
        return sb.toString();
    }
}