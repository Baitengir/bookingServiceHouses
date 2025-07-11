package bookinghouse.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
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
    @Column (unique = true)
    String email;
    @ManyToMany
    List<Customer> customers = new ArrayList<>();
    @OneToMany (mappedBy = "agency")
    List<House> houses = new ArrayList<>();

}
