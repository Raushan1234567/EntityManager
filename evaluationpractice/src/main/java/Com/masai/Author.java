package Com.masai;

import jakarta.persistence.*;

@Entity
public class Author {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private int BookId;
private String name;
private double rating;
public Author() {
	super();
	// TODO Auto-generated constructor stub
}
public Author(String name, double rating) {
	super();
	this.name = name;
	this.rating = rating;
}
public int getBookId() {
	return BookId;
}
public void setBookId(int bookId) {
	BookId = bookId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getRating() {
	return rating;
}
public void setRating(double rating) {
	this.rating = rating;
}
@Override
public String toString() {
	return "Author [BookId=" + BookId + ", name=" + name + ", rating=" + rating + "]";
}


}
