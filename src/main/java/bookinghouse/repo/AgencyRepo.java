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
            select new bookinghouse.dto.houseDto.response.HouseResponse(
                        h.id, h.houseType, h.address, h.price, h.rooms, h.country, h.description
                        )
            from House h
            join Agency a on h.agency.id = a.id
            where a.id = :id
            """)
    List<HouseResponse> getAllHousesByAgencyId(@Param("id") Long id);

    @Query(value = """
            select count(h.id)
            from houses h
            where h.agency_id = :id
            """, nativeQuery = true)
    int getTotalHousesByAgencyId(@Param("id") Long id);
}
