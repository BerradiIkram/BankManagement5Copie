package ma.atos.ma.atos.bankmanagement.proxies;

import ma.atos.ma.atos.bankmanagement.Dtos.RestrictionDto;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import ma.atos.ma.atos.bankmanagement.exceptions.RestrictionException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "restriction-service", url = "${url.bankmanagment}")

public interface RestrictionServiceProxy {
    @GetMapping("")
    public List<RestrictionDto> getRestriction();

    @GetMapping("")
    public Restriction getRestrictionById(@PathVariable Long idRestriction);

    @PostMapping("")
    public void createRestriction(@RequestBody RestrictionDto restrictionDto);

    @GetMapping("")
    public void deleteRestriction(@PathVariable Long idRestriction) throws RestrictionException;

}
