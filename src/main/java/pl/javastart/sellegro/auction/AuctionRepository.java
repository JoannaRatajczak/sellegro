package pl.javastart.sellegro.auction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long>, PagingAndSortingRepository<Auction, Long> {


    List<Auction> findAll();

    List<Auction> findByOrderByCarMake();

    List<Auction> findByOrderByCarModel();

    List<Auction> findByOrderByColor();

    List<Auction> findByOrderByEndDate();

    List<Auction> findByOrderByPrice();

//    @Query("SELECT a FROM Auction a WHERE (?1 IS NULL OR a.carMake =?1 ) AND (?2 IS NULL OR a.carModel = ?2) AND (?3 IS NULL OR a.color = ?3)")
//    List<Auction> selectByParameters(String carMake, String carModel, String color);

//    @Query("SELECT a FROM Auction a WHERE (':carMake' IS NULL OR a.carMake =':carMake' ) AND (':carModel' IS NULL OR a.carModel = ':carModel') AND (':color' IS NULL OR a.color = ':color')")
//    List<Auction> selectByParameters(@Param("carMake") String carMake, @Param("carModel") String carModel, @Param("color") String color);
//
    @Query(value = "SELECT * FROM auction WHERE (:carMake IS NULL OR car_make =:carMake )" +
            "AND (:carModel IS NULL OR car_model = :carModel ) " +
            "AND (:color IS NULL OR color = :color)", nativeQuery = true)
    List<Auction> selectByParameters(@Param("carMake") String carMake, @Param("carModel") String carModel, @Param("color") String color);


}
