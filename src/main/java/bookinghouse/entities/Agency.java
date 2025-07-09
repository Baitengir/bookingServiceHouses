package bookinghouse.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Entity
@Table (name = "agencies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Agency {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "agency_gen")
    @SequenceGenerator(name = "agency_gen", sequenceName = "agency_seq", allocationSize = 1, initialValue = 10)
    Long id;
    String name;
    String country;
    String phone;
    String email;
    @ManyToMany
    List<Customer> customers;
    @OneToMany (mappedBy = "agency")
    List<House> houses;

    public Agency(String name, String country, String phone, String email) {
        this.name = name;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }
}
