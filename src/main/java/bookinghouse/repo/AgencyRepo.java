package bookinghouse.repo;

import bookinghouse.dto.houseDto.response.HouseResponse;
import bookinghouse.entities.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AgencyRepo extends JpaRepository<Agency, Long> {

    @Query(value = """
            select h.*
            from houses h
            join agencies a
            on h.agency_id = a.id
            where a.id = :id
            """, nativeQuery = true)
    List<HouseResponse> getAllHousesByAgencyId(@Param("id") Long id);
}
