package bookinghouse.entities;

import bookinghouse.enums.HouseType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "houses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "house_gen")
    @SequenceGenerator(name = "house_gen", sequenceName = "house_seq", allocationSize = 1, initialValue = 10)
    Long id;
    HouseType houseType;
    String address;
    int price;
    int rooms;
    String country;
    String description;
    boolean isBooked;
    @ManyToOne
    Agency agency;
    @OneToOne(mappedBy = "house")
    Booking booking;

}
