package hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "movie")

public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String movieTitle;

	@Column(name = "year_released")
	private Integer yearReleased;

	@Column(name = "rating")
	private String rating;

	@Column(name = "rental_price", columnDefinition = "decimal", precision = 10, scale = 2 )
	private Double rentalPrice;

	@Column(name = "late_fee", columnDefinition = "decimal", precision = 10, scale = 2 )
	private Double lateFee;


	// one movie to movie rental
	@ToString.Exclude
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<MovieRental> movieRentals = new ArrayList<MovieRental>();
	
}
