package ma.atos.ma.atos.bankmanagement.config;


import ma.atos.ma.atos.bankmanagement.Dtos.DepotDto;
import ma.atos.ma.atos.bankmanagement.Dtos.OperationDto;
import ma.atos.ma.atos.bankmanagement.Dtos.VirementDto;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient("service")
//@LoadBalanced

public interface OperationProxy {


    @GetMapping("/operations")
    public ResponseEntity<List<OperationDto>> getAllOperations();


//    @GetMapping("/{id}")
//    public ResponseEntity<OperationDto> getOperationById(@PathVariable Long id);
//
//
//    @GetMapping("/type/{typeOperation}")
//    public ResponseEntity<List<OperationDto>> getOperationsByTypeOperation();
//
//    @PostMapping
//    public ResponseEntity<OperationDto> createOperation(@RequestBody OperationDto operationDto);
//
//    @PostMapping("/saveVirement")
//    @ResponseBody
//    public VirementDto saveVirement(@RequestBody VirementDto request);
//
//    @PostMapping("/saveDepot")
//    @ResponseBody
//    public DepotDto saveDepot(@RequestBody DepotDto request);
//
//    @GetMapping("/getOperations/{ribCompte}")
//    public ResponseEntity<List<OperationDto>> getOperationsByRibCompte(@PathVariable Long ribCompte);
}
