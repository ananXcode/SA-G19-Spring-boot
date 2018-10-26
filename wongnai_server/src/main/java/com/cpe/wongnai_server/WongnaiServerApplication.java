package com.cpe.wongnai_server;
import com.cpe.wongnai_server.entity.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;
import lombok.*;
import com.cpe.wongnai_server.Repository.OwnerRepository;
import com.cpe.wongnai_server.Repository.RestaurantRepository;
import com.cpe.wongnai_server.Repository.CategoryRepository;
import com.cpe.wongnai_server.Repository.MenuRepository;
import com.cpe.wongnai_server.Repository.MeReRepository;
import com.cpe.wongnai_server.Repository.TypReRepository;
import com.cpe.wongnai_server.Repository.ReOwRepository;
import com.cpe.wongnai_server.Repository.PromoRepository;
@Getter@Setter
@SpringBootApplication
public class WongnaiServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(WongnaiServerApplication.class, args);}
		@Bean
    ApplicationRunner init(OwnerRepository ownerRepository,CategoryRepository categoryRepository
                           ,MenuRepository menuRepository,RestaurantRepository restaurantRepository,PromoRepository promoRepository
                            ,MeReRepository meReRepository,TypReRepository typReRepository,ReOwRepository reOwRepository) {
        return args -> {
            Stream.of("Anan", "Kathin", "Sathorn", "Garran" ).forEach(owname -> {
                Owner owner = new Owner();
                if(owname=="Anan"){
                    owner.setTel("0971957408");
                }
                else if(owname=="Kathin"){
                    owner.setTel("0977777777");
                }
                else if(owname=="Sathorn"){
                    owner.setTel("0988888888");
                }
                else if(owname=="Garran"){
                    owner.setTel("0966666666");
                }
                owner.setOwname(owname);
                ownerRepository.save(owner);

    });ownerRepository.findAll().forEach(System.out::println);
    Stream.of("Chinese", "Europe", "Thai", "Esan" ).forEach(catego -> {
        Category cater = new Category();
        cater.setCategory(catego);
        categoryRepository.save(cater);
        } );
    categoryRepository.findAll().forEach(System.out::println);
    Stream.of("kapao", "soup", "tomyumkung", "salad","Meat grill" , "Somtum" ).forEach(foodname -> {
        Menu menu = new Menu();
        if(foodname == "kapao"){
            menu.setFoodprice(50);
        }else if(foodname == "soup"){
            menu.setFoodprice(60);
        }
        else if(foodname == "tomyumkung"){
            menu.setFoodprice(80);
        }
        else if(foodname == "salad"){
            menu.setFoodprice(40);
        }
        else if(foodname == "Meat grill"){
            menu.setFoodprice(150);
        }
        else if(foodname == "Somtum"){
            menu.setFoodprice(35);
        }
        menu.setFoodname(foodname);
        menuRepository.save(menu);
        } );
    menuRepository.findAll().forEach(System.out::println);
    
    Stream.of("4paid3", "1 Free 1", "Free 50%", "Free 30%" ).forEach(promot -> {
        Promo promo = new Promo();
        promo.setProname(promot);
        promoRepository.save(promo);
        } );
    promoRepository.findAll().forEach(System.out::println);

    Restaurant restaurant1 = new Restaurant();
    MeRe meRe1 = new MeRe();
    TypRe typRe1 = new TypRe();
    ReOw reOw1 = new ReOw();
    restaurant1.setRname("Korkok");
    restaurant1.setRaddress("SUT Gate 1");
    restaurant1.setRtel("095422547");
    meRe1.setFreme(restaurantRepository.getOne(1L));
            restaurantRepository.save(restaurant1);
    meRe1.setFmere(menuRepository.getOne(3L));
            meReRepository.save(meRe1);
    meRe1.setFmere(menuRepository.getOne(2L));
            meReRepository.save(meRe1);
    meRe1.setFmere(menuRepository.getOne(1L));
    typRe1.setFreca(restaurantRepository.getOne(1L));
    typRe1.setFcare(categoryRepository.getOne(3L));
    reOw1.setFreow(restaurantRepository.getOne(1L));
    reOw1.setFowre(ownerRepository.getOne(3L));
               restaurantRepository.save(restaurant1);
               meReRepository.save(meRe1);
               typReRepository.save(typRe1);
               reOwRepository.save(reOw1);
    Restaurant restaurant2 = new Restaurant();
            MeRe meRe2 = new MeRe();
            MeRe meRe3 = new MeRe();
            MeRe meRe4 = new MeRe();
            TypRe typRe2 = new TypRe();
            ReOw reOw2 = new ReOw();
    restaurant2.setRname("เป๋า");
    restaurant2.setRaddress("SUT Gate 18");
    restaurant2.setRtel("085441225");
    meRe2.setFreme(restaurantRepository.getOne(2L));
    meRe2.setFmere(menuRepository.getOne(3L));
    meRe3.setFreme(restaurantRepository.getOne(2L));
    meRe3.setFmere(menuRepository.getOne(2L));
    meRe4.setFreme(restaurantRepository.getOne(2L));
    meRe4.setFmere(menuRepository.getOne(4L));
    typRe2.setFreca(restaurantRepository.getOne(2L));
    typRe2.setFcare(categoryRepository.getOne(4L));
    reOw2.setFreow(restaurantRepository.getOne(2L));
    reOw2.setFowre(ownerRepository.getOne(3L));
            restaurantRepository.save(restaurant2);
            meReRepository.save(meRe2);
            meReRepository.save(meRe3);
            meReRepository.save(meRe4);
            typReRepository.save(typRe2);
            reOwRepository.save(reOw2);
;};}}

     

