package ar.edu.unq.desapp.grupoG.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name= "History")
@Table(name="history")
public class History {

    @Id
    @GeneratedValue private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auction_id")
    private Auction auction;


    private String userEmail;
	private Float price;
	private LocalDate date;

	
	public History (String email, Float price, Auction auction) {
		this.userEmail=email;
		this.price=price;
		this.date = LocalDate.now();
		this.auction = auction;
	}

	public void setAuction(Auction auction){
	    this.auction = auction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof History )) return false;
        return id != null && id.equals(((History) o).id);
    }

	public void print(){
		System.out.print("\n");
		System.out.print(this.userEmail);
		System.out.print("\n");
		System.out.print(this.price);
		System.out.print("\n");
		System.out.print(this.date);
		System.out.print("\n");
		System.out.print(this.auction.getId());
		System.out.print("\n");
		System.out.print("\n");
	}

}
