package pl.javastart.sellegro.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuctionController {

    @Autowired
    AuctionRepository auctionRepository;

    public AuctionController(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }


    @GetMapping("/auctions")
    public String auctions(Model model,
                           @RequestParam(required = false, defaultValue = "ALL") String sort,
                           @RequestParam(required = false, name = "carMake") String carMake,
                           @RequestParam(required = false, name = "carModel") String carModel,
                           @RequestParam(required = false, name = "color") String color,
                           AuctionFilters auctionFilters) {

//        Pageable pageable0 = PageRequest.of(0, 50);
//        Pageable pageable1 = PageRequest.of(1, 100);
//        Pageable pageable2 = PageRequest.of(2, 150);

        List<Auction> auctions = new ArrayList<>();

        if (sort != null) {
            switch (sort) {
                case "ALL":
                    auctions = auctionRepository.findAll();
                    break;

                case "carMake":
                    auctions = auctionRepository.findByOrderByCarMake();
                    break;

                case "carModel":
                    auctions = auctionRepository.findByOrderByCarModel();
                    break;

                case "price":
                    auctions = auctionRepository.findByOrderByPrice();
                    break;

                case "color":
                    auctions = auctionRepository.findByOrderByColor();
                    break;

                case "endDate":
                    auctions = auctionRepository.findByOrderByEndDate();
                    break;
            }
        } else auctions = auctionRepository.selectByParameters(carMake, carModel, color);




        model.addAttribute("cars", auctions);
        model.addAttribute("filters", auctionFilters);
        return "auctions";

    }
}



