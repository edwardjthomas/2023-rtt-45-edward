package hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "orderdetails")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "order_id", insertable = false, updatable = false)
	private Integer orderId;
	
	@Column(name = "product_id", insertable = false, updatable = false)
	private Integer productId;

	@Column(name = "quantity_ordered")
	private Integer quantityOrdered;
	
	@Column(name = "price_each", columnDefinition = "decimal", precision = 10, scale = 2)
	private Double priceEach;

	@Column(name = "order_line_number", columnDefinition = "SMALLINT") // text?
	private Integer orderLineNumber;

//	// points back to customer
//	@ToString.Exclude
//	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
//	@JoinColumn(name = "order_id", nullable = true)
//	private Order order;
	
	// points back to customer
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;
	
//	// points back to product
//	@ToString.Exclude
//	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
//	@JoinColumn(name = "product_id", nullable = true)
//	private Product product;
	
	// points back to product
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
}