package com.cpe.wongnai_server.Controller;
import com.cpe.wongnai_server.entity.MeRe;
import com.cpe.wongnai_server.entity.Owner;
import com.cpe.wongnai_server.entity.ReOw;
import com.cpe.wongnai_server.entity.Restaurant;
import com.cpe.wongnai_server.entity.TypRe;
import com.cpe.wongnai_server.entity.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import com.cpe.wongnai_server.Repository.RestaurantRepository;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cpe.wongnai_server.entity.Restaurant;
import com.cpe.wongnai_server.Repository.PromoRepository;
import com.cpe.wongnai_server.Repository.RestaurantRepository;
import com.cpe.wongnai_server.Repository.OwnerRepository;
import com.cpe.wongnai_server.Repository.MenuRepository;
import com.cpe.wongnai_server.Repository.ReOwRepository;
import com.cpe.wongnai_server.Repository.MeReRepository;
import com.cpe.wongnai_server.Repository.TypReRepository;
import com.cpe.wongnai_server.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
class RestaurantController {
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ReOwRepository reOwRepository;
    @Autowired
    MeReRepository meReRepository;
    @Autowired
    TypReRepository typReRepository;

    public RestaurantController(RestaurantRepository restaurantRepository,CategoryRepository categoryRepository) {
        this.restaurantRepository = restaurantRepository;
        this.categoryRepository = categoryRepository;
    }
    @GetMapping("/Restaurant")
    public Collection<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll().stream()
            .collect(Collectors.toList());
    }
    @GetMapping("/Restaurant/{rid}")
    public Restaurant ShowRestaurantInfo(@PathVariable Long rid) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(rid);
        return restaurant.get();
    }
//    @GetMapping("restaurant/owner/{rid}")
//    public List<Restaurant> findAllReOw(@PathVariable Long rid){
//        return restaurantRepository.findAllReOw(rid);
//    }

  /* @PostMapping("/owner/create/{owname}/{tel}")
    public Owner createOwner(@PathVariable String owname,@PathVariable String tel){
        
        Owner owner = new Owner();
        owner.setOwname(owname);
        owner.setTel(tel);
        return ownerRepository.save(owner);
    }*/

    @PostMapping("/restaurant/create/{rname}/{catego}/{menus}/{owa}/{tel}")
    public Restaurant createRestaurant(@PathVariable Long menus,@PathVariable Long owa,@PathVariable String tel,@PathVariable String rname,@PathVariable Long catego,@RequestBody String packAddress)
    throws IOException,JsonParseException {
        final String decoded = URLDecoder.decode(packAddress, "UTF-8");
        packAddress = decoded;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(packAddress);
        JsonNode jsonText = actualObj.get("addressSelect");
        Restaurant restaurant = new Restaurant();
        MeRe mere = new MeRe();
        ReOw reow = new ReOw();
        TypRe typre = new TypRe();
        restaurant.setRtel(tel);
        restaurant.setRname(rname);

        mere.setFmere(menuRepository.getOne(menus));
        mere.setFreme(restaurantRepository.getOne(menus));
        reow.setFreow(restaurantRepository.getOne(owa));
        reow.setFowre(ownerRepository.getOne(owa));
        typre.setFreca(restaurantRepository.getOne(catego));
        typre.setFcare(categoryRepository.getOne(catego));
        restaurant.setRaddress(jsonText.textValue());

        typReRepository.save(typre);
        reOwRepository.save(reow);
        meReRepository.save(mere);
        return restaurantRepository.save(restaurant);
    }
}    