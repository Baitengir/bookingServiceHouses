package bookinghouse.repo;

import bookinghouse.dto.bookingDto.response.BookingResponse;
import bookinghouse.dto.customerDto.responses.CustomerResponse;
import bookinghouse.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository <Customer, Long> {

    @Query(value = """
            select new bookinghouse.dto.customerDto.responses.CustomerResponse(
                        c.id, c.name, c.surname,c.gender, c.phone, c.dateOfBirth
                        )
            from Customer c
            where c.name = :name
            """)
    List<CustomerResponse> searchByNameOrSurname(@Param("name") String searchName);

    @Query(value = """
            select new bookinghouse.dto.customerDto.responses.CustomerResponse(
                        c.id, c.name, c.surname,c.gender, c.phone, c.dateOfBirth
                        )
            from Customer c
            where c.surname = :name
            """)
    List<CustomerResponse> searchBySurname (@Param("name") String searchName);

    @Query("""
            select new bookinghouse.dto.bookingDto.response.BookingResponse (
                        b.id, c.id, b.house.id
                        )
            from Customer c
                        join Booking b
                                    on b.customer.id = c.id
                                                where c.id = :id
            """)
    public List<BookingResponse> getBookingsByCustomerId(@Param("id") Long id);

}
