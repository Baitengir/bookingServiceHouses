package bookinghouse.repo;

import bookinghouse.dto.houseDto.response.HouseResponse;
import bookinghouse.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HouseRepo extends JpaRepository<House, Long> {

    @Query(value = """
            select * from houses where is_booked = false
            """, nativeQuery = true)
    List<HouseResponse> getAllFreeHouses();
}
