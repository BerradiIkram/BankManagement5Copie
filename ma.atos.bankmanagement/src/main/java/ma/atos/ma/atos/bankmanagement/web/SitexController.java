package ma.atos.ma.atos.bankmanagement.web;
import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.Dtos.SitexDto;
import ma.atos.ma.atos.bankmanagement.Dtos.responses.GenericResponse;
import ma.atos.ma.atos.bankmanagement.exceptions.GenResponse;
import ma.atos.ma.atos.bankmanagement.exceptions.SitexExeption;
import ma.atos.ma.atos.bankmanagement.repositories.SitexRepository;
import ma.atos.ma.atos.bankmanagement.services.SitexServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/sitex")
@AllArgsConstructor
public class SitexController {
     SitexRepository sitexRepository;
     SitexServiceImpl sitexService;
    MessageSource messageSource;

    @GetMapping(path = "/{idSitex}")
    public SitexDto getSitex(@PathVariable(name = "idSitex") Long idSitex) {
       return sitexService.getSitex(idSitex);
    }
    @GetMapping("")
    public List<SitexDto> sitexes() throws SitexExeption {
        return sitexService.listSitex();
    }
    @PostMapping("/create")
    public ResponseEntity<GenericResponse> createSitex(@RequestBody SitexDto sitexDto) throws SitexExeption {
        GenericResponse result = new GenericResponse();
        sitexService.createSitex(sitexDto);
        result.setDescription(messageSource.getMessage("sitex.created.success", new Object[] {sitexDto.getIdSitex()}, Locale.getDefault()));

        return ResponseEntity.ok(result);

    }
    @DeleteMapping("delete/{idSitex}")
    public ResponseEntity<GenResponse> deleteSitex(@PathVariable Long idSitex) throws SitexExeption {
        GenResponse response = new GenResponse();
        sitexService.deleteSitex(idSitex);
        response.setError(false);
        response.setDescription(messageSource.getMessage("sitex.deleted.success", new Object[]{}, Locale.getDefault()));
        response.setDescriptionFront(messageSource.getMessage("sitex.deleted.success", new Object[]{}, Locale.getDefault()));
        return ResponseEntity.ok(response);
    }




}
