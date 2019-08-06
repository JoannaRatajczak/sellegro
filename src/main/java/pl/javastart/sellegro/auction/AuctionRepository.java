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

    @Query(value = "SELECT * FROM auction WHERE (:make% IS NULL OR car_make =:make% )" +
            "AND (:model% IS NULL OR car_model = :model% ) " +
            "AND (:color% IS NULL OR color = :color% )", nativeQuery = true)
    List<Auction> selectByParameters(@Param("make") String make, @Param("model") String model, @Param("color") String color);


}
