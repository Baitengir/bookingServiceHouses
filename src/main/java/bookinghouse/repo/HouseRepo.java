package bookinghouse.repo;

import bookinghouse.dto.houseDto.response.HouseResponse;
import bookinghouse.entities.House;
import bookinghouse.enums.HouseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepo extends JpaRepository<House, Long> {

//    Long id;
//    HouseType houseType;
//    String address;
//    int price;
//    int rooms;
//    String country;
//    String description;

    @Query(value = """
            select new bookinghouse.dto.houseDto.response.HouseResponse (
                        id, houseType, address, price, rooms, country, description
                        )
            from House
            where isBooked = false
            """)
    List<HouseResponse> getAllFreeHouses();

    @Query("""
            select new bookinghouse.dto.houseDto.response.HouseResponse(
            h.id, h.houseType, h.address, h.price, h.rooms, h.country, h.description
                        )
            from House h
            where h.country = :country
            and h.rooms = :room
            """)
    List<HouseResponse> searchHousesByCountryAndRoom(@Param("country") String country,@Param("room") String room);


}
