package ma.atos.ma.atos.bankmanagement.web;
import com.rabbitmq.http.client.domain.Page;
import lombok.extern.slf4j.Slf4j;
import ma.atos.ma.atos.bankmanagement.Dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.Dtos.PersonnePhysiqueDto;
import ma.atos.ma.atos.bankmanagement.exceptions.TierNotFoundExeption;
import ma.atos.ma.atos.bankmanagement.services.TierService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/tiers")
@Slf4j
@CrossOrigin(origins = "*")
public class TiersController {
TierService tierService;
    public TiersController(TierService tierService) {
        this.tierService = tierService;
    }
  /*  @GetMapping("/listPersonnePhysique")
    @ResponseBody
    public List<PersonnePhysiqueDto> personnePhysiqueDTOList(@RequestParam(name = "page",defaultValue = "1") int page,
                                                             @RequestParam(name = "size",defaultValue = "1") int size){
        return tierService.getAllPersonnePhysique(page, size);
    }*/
  /*  @GetMapping("/listPersonneMorale")
    @ResponseBody
    public List<PersonneMoraleDto> personneMoraleDTOList(){
        return tierService.getAllPersonneMorale();
    }*/
    @GetMapping("/personnePhysique/{id}")
    @ResponseBody
    public PersonnePhysiqueDto getPersonnePhysique(@PathVariable(name = "id") Long tierId) throws TierNotFoundExeption {
        return tierService.getPersonnePhysique(tierId);
    }
    @GetMapping("/personneMorale/{id}")
    @ResponseBody
    public PersonneMoraleDto getPersonneMorale(@PathVariable(name = "id") Long tierId) throws TierNotFoundExeption {
        return tierService.getPersonneMorale(tierId);
    }
    @DeleteMapping("/PersonnePhysiquedelete/{id}")
    public void deletPersonnePhysique(@PathVariable Long id) {
        tierService.deletPersonnePhysique(id);
    }
    @DeleteMapping("/PersonneMoraledelete/{id}")
    public void deletPersonneMorale(@PathVariable Long  id)throws TierNotFoundExeption {

         tierService.deletPersonneMorale(id);
    }
    @PostMapping("/savePersonnePhysique")
    @ResponseBody
    public PersonnePhysiqueDto savePersonnePhysique(@RequestBody PersonnePhysiqueDto request) {
        return tierService.savePersonnePhysique(request);
    }
    @PostMapping("/savePersonneMorale")
    @ResponseBody
    public PersonneMoraleDto savePersonneMorale(@RequestBody PersonneMoraleDto request) {
        return tierService.savePersonneMorale(request);
    }
    @GetMapping("/searchPersonneMorale/{numClient}")
    @ResponseBody
    public List<PersonneMoraleDto> searchPersonneMorale(@PathVariable(name = "numClient") String numClient){
        return tierService.searchPersonneMorale(numClient);
    }
    @GetMapping("/searchPersonneMoralePagination/{numClient}")
    @ResponseBody
    public List<PersonneMoraleDto> searchPersonneMoralePagination(@PathVariable(name = "numClient") String numClient,
                                                                  @RequestParam(name = "page",defaultValue = "0") int page,
                                                                  @RequestParam(name = "size",defaultValue = "10") int size){
        return tierService.searchPersonneMorale(numClient,page,size);
    }
    @GetMapping("/searchPersonnePhysique/{numClient}")
    @ResponseBody
    public List<PersonnePhysiqueDto> searchPersonnePhysique(@PathVariable(name = "numClient") String numClient,
                                                            @RequestParam(name = "page",defaultValue = "0") int page,
                                                            @RequestParam(name = "size",defaultValue = "10") int size
                                                                ){
        return tierService.searchPersonnePhysique(numClient,page,size);
    }
    @GetMapping("/listPersonneMorale")
    @ResponseBody
    public List<PersonneMoraleDto> personneMoraleDTOList(  @RequestParam(name = "page",defaultValue = "1") int page,
                                                           @RequestParam(name = "size",defaultValue = "1") int size){
        return tierService.getAllPersonneMorale(page,size);
    }
@GetMapping("/nombrpersonne/{type}")
    @ResponseBody
    public Long nbrPersonneMorale(@PathVariable String type){
        return tierService.nbrPersonne(type);
}
    @GetMapping("/listPersonnePhysique")
    @ResponseBody
    public List<PersonnePhysiqueDto> personnePhysiqueDTOList(@RequestParam(name = "page",defaultValue = "1") int page,
                                                             @RequestParam(name = "size",defaultValue = "1") int size){
        return tierService.getAllPersonnePhysique(page, size);
    }
}
