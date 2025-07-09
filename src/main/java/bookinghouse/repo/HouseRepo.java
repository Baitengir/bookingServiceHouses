package bookinghouse.repo;

import bookinghouse.entities.Agency;
import bookinghouse.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepo extends JpaRepository<House, Long> {
}
