package bookinghouse.entities;

import bookinghouse.enums.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_gen")
    @SequenceGenerator(name = "customer_gen", sequenceName = "customer_seq", allocationSize = 1, initialValue = 10)
    Long id;
    String name;
    String surname;
    String email;
    Gender gender;
    String phone;
    LocalDate dateOfBirth;
    @ManyToMany(mappedBy = "customers")
    List<Agency> agencies;
    @OneToMany(mappedBy = "customer")
    List<Booking> bookings;
}
