package com.cpe.wongnai_server.Controller;

import com.cpe.wongnai_server.Repository.CategoryRepository;
import com.cpe.wongnai_server.Repository.RestaurantRepository;
import com.cpe.wongnai_server.entity.Restaurant;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import com.cpe.wongnai_server.Repository.OwnerRepository;
import com.cpe.wongnai_server.entity.ReOw;
import com.cpe.wongnai_server.Repository.ReOwRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReowController {
    @Autowired ReOwRepository reOwRepository;

    public ReowController(ReOwRepository reOwRepository) {
        this.reOwRepository=reOwRepository;
    }

    @GetMapping("/reow/{reow_id}")
    public ReOw ShowreowInfo(@PathVariable Long reow_id) {
        Optional<ReOw> reOw = reOwRepository.findById(reow_id);
        return reOw.get();
    }
}
