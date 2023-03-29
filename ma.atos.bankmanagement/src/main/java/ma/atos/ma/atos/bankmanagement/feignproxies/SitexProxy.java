package ma.atos.ma.atos.bankmanagement.feignproxies;

import ma.atos.ma.atos.bankmanagement.Dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.Dtos.SitexDto;
import ma.atos.ma.atos.bankmanagement.entities.Post;
import ma.atos.ma.atos.bankmanagement.exceptions.SitexExeption;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(value = "BANKMANAGEMENT2", url = "${bank2url:}")
@FeignClient("BANKMANAGEMENT2")
public interface SitexProxy {

/*
    // Testing OpenFeign

    @GetMapping("/posts")
    List<Post> getPosts();

    @GetMapping("/posts/{id}")
    Post getPostById(@PathVariable Long id);

    // End of test*/
    @GetMapping("/comptes")
    List<CompteDto> getComptes();


    @GetMapping("")
    SitexDto getSitex(@PathVariable(name = "idSitex") Long idSitex);
    @GetMapping("")
    List<SitexDto> sitexes() throws SitexExeption;
    @PostMapping("")
    String createSitex(@RequestBody SitexDto sitexDto);
    @DeleteMapping("")
    void deleteSitex(@PathVariable Long idSitex);
}
