//
//package ma.atos.ma.atos.bankmanagement.config;
//
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.*;
//
//@FeignClient(name = "service",
//        url = "http://localhost:8081")
//
////@FeignClient(value = "OPERATIONS-SERVICE", url = "http://localhost:8080")
//
//public inteface SitexProxy {
//
////    String  SDK_CONTROLLER = "sdk/";
////
////    @GetMapping(SDK_CONTROLLER + "test")
////        String test();
////
////    @PostMapping(SDK_CONTROLLER + "send/pacs008")
////        PayloadResponse pacs008(@RequestBody Pacs008Payload pcas008Payload);
////
////    @PostMapping(SDK_CONTROLLER + "send/pacs008")
////        PayloadResponse pacs008(@RequestBody Pacs008Payload pcas008Payload);
////
////    @PostMapping(SDK_CONTROLLER + "send/pacs008")
////        PayloadResponse pacs008(@RequestBody Pacs008Payload pcas008Payload);
//
//
////    @GetMapping(value = "/api/departments/{id}")
////        DepartmentDto getDepartmentById(@PathVariable("id") Long departmentId);
//
//        @GetMapping
//        public ResponseEntity<List<OperationDto>> getAllOperations();
//
//        @GetMapping
//        public ResponseEntity<List<OperationDto>> getAllOperations();
//
//        @GetMapping("/{id}")
//        public ResponseEntity<OperationDto> getOperationById(@PathVariable Long id);
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
//
//
//
//
//
//        }
