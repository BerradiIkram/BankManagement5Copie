package ma.atos.ma.atos.bankmanagement.web;

import ma.atos.ma.atos.bankmanagement.Dtos.DepotDto;
import ma.atos.ma.atos.bankmanagement.Dtos.OperationDto;
import ma.atos.ma.atos.bankmanagement.Dtos.PersonnePhysiqueDto;
import ma.atos.ma.atos.bankmanagement.Dtos.VirementDto;
import ma.atos.ma.atos.bankmanagement.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import ma.atos.ma.atos.bankmanagement.Dtos.DepotDto;
import ma.atos.ma.atos.bankmanagement.Dtos.OperationDto;
import ma.atos.ma.atos.bankmanagement.Dtos.PersonnePhysiqueDto;
import ma.atos.ma.atos.bankmanagement.Dtos.VirementDto;
import ma.atos.ma.atos.bankmanagement.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/operations")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class OperationController {

    @Autowired
    private final OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public ResponseEntity<List<OperationDto>> getAllOperations() {
        List<OperationDto> operations = operationService.getAllOperations();
        if (operations == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(operations);
        }
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<OperationDto> getOperationById(@PathVariable Long id) {
        OperationDto operation = operationService.getOperationById(id);

        if (operation == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(operation);
        }
    }

    @GetMapping("/type/{typeOperation}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<OperationDto>> getOperationsByTypeOperation(
            @PathVariable String typeOperation) {
        List<OperationDto> operations = operationService.getOperationsByTypeOperation(typeOperation);
        if (operations == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(operations);
    }

//    @PostMapping
//    public ResponseEntity<OperationDto> createOperation(@RequestBody OperationDto operationDto) {
//        OperationDto createdOperation = operationService.createOperation(operationDto);
//        return ResponseEntity.status(HttpStatus.OK).body(createdOperation);
//    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createOperation(@RequestBody OperationDto operationDto) {
        OperationDto createdOperation = operationService.createOperation(operationDto);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Operation created successfully");
        response.put("operationId", createdOperation.getIdOperation());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }





    @GetMapping("/getByRIB/{ribCompte}")
    public ResponseEntity<List<OperationDto>> getOperationsByRibCompte(@PathVariable Long ribCompte) {
        List<OperationDto> operationDtos = operationService.getOperationsByRibCompte(ribCompte);
        if (operationDtos == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(operationDtos);
    }


}






