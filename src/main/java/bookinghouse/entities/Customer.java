package bookinghouse.entities;

import bookinghouse.enums.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

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
    @Column(unique = true, nullable = false)
    String email;
    @Enumerated(EnumType.STRING)
    Gender gender;
    String phone;
    LocalDate dateOfBirth;
    int totalBookings = 0;
    @ManyToMany(mappedBy = "customers", cascade = {DETACH, MERGE})
    List<Agency> agencies;
    @OneToMany(mappedBy = "customer", cascade = {REMOVE})
    List<Booking> bookings = new ArrayList<>();
}
