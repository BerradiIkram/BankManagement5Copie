package ma.atos.ma.atos.bankmanagement.services;

import ma.atos.ma.atos.bankmanagement.Dtos.DepotDto;
import ma.atos.ma.atos.bankmanagement.Dtos.OperationDto;
//import ma.atos.ma.atos.bankmanagement.Dtos.PersonneMoraleDto;
import ma.atos.ma.atos.bankmanagement.Dtos.VirementDto;
import ma.atos.ma.atos.bankmanagement.entities.*;
//import ma.atos.ma.atos.bankmanagement.exceptions.CompteNotFoundException;
import ma.atos.ma.atos.bankmanagement.exceptions.CustomerException;
import ma.atos.ma.atos.bankmanagement.mappers.DepotMapper;
import ma.atos.ma.atos.bankmanagement.mappers.OperationMapper;
//import ma.atos.ma.atos.bankmanagement.mappers.PersonneMoraleMapper;
import ma.atos.ma.atos.bankmanagement.mappers.VirementMapper;
import ma.atos.ma.atos.bankmanagement.repositories.CompteRepository;
import ma.atos.ma.atos.bankmanagement.repositories.OperationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
//import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Locale;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationMapper operationMapper;
    @Autowired
    private VirementMapper virementMapper;
    @Autowired
    private DepotMapper depotMapper;
    @Autowired
    private MessageSource messageSource;


    @Override
    public List<OperationDto> getOperationsByRibCompte(Long ribCompte) {

        Compte compte = compteRepository.findCompteByRibCompte(ribCompte);

        if (compte == null) {
            String msgError = messageSource.getMessage("operation.not.found.message",
                    new Object[]{}, Locale.getDefault());
            throw new CustomerException(msgError);
        } else {
            List<Operation> operations = operationRepository.findByCompte_IdCompte(compte.getIdCompte());
            List<OperationDto> operationDtos = new ArrayList<>();
            for (Operation operation : operations) {
                OperationDto operationDto;
                if (operation instanceof Depot) {
                    operationDto = new DepotDto();
                } else if (operation instanceof Virement) {
                    operationDto = new VirementDto();
                } else {
                    throw new IllegalArgumentException("Unknown operation type");
                }
                BeanUtils.copyProperties(operation, operationDto);
//                operation.setCompte(compte);
                operationDto.setIdCompte(operation.getCompte().getIdCompte());
                operationDtos.add(operationDto);


            }
            return operationDtos;
        }
    }

    @Override
    public OperationDto getOperationById(Long id) {

        Optional<Operation> optionalOperation = operationRepository.findById(id);

        if (optionalOperation.isPresent()) {
            Operation operation = optionalOperation.get();

            if (operation instanceof Depot) {
                DepotDto depotDto = new DepotDto();
                Depot depot = (Depot) operation;
                depotDto.setIdOperation(depot.getIdOperation());
                depotDto.setMontant(depot.getMontant());
                depotDto.setDescription(depot.getDescription());
                depotDto.setDateOperation(depot.getDateOperation());
                depotDto.setSensOperation(depot.getSensOperation());
                depotDto.setTypeOperation(depot.getTypeOperation());
                depotDto.setSourceDepot(depot.getSourceDepot());
                depotDto.setIdCompte(depot.getCompte().getIdCompte());
                depotDto.setRibCompte(depot.getCompte().getRibCompte());
                return depotDto;
            } else if (operation instanceof Virement) {
                VirementDto virementDto = new VirementDto();
                Virement virement = (Virement) operation;
                virementDto.setIdOperation(virement.getIdOperation());
                virementDto.setMontant(virement.getMontant());
                virementDto.setDescription(virement.getDescription());
                virementDto.setDateOperation(virement.getDateOperation());
                virementDto.setSensOperation(virement.getSensOperation());
                virementDto.setTypeOperation(virement.getTypeOperation());
                virementDto.setIdCompte(virement.getCompte().getIdCompte());
                virementDto.setRibCompte(virement.getCompte().getRibCompte());
                virementDto.setRibCompteDestinataire(virement.getRibCompteDestinataire());
                return virementDto;
            } else {
                String msgError = messageSource.getMessage("operation.not.found.message",
                        new Object[]{}, Locale.getDefault());
                throw new CustomerException(msgError);
            }
        } else {
            String msgError = messageSource.getMessage("operation.not.found.message",
                    new Object[]{}, Locale.getDefault());
            throw new CustomerException(msgError);
        }
    }


    @Override
    public List<OperationDto> getOperationsByTypeOperation(String typeOperation) {
        if (typeOperation.equals("depot")) {
            List<Operation> operations = operationRepository.findByTypeOperation("depot");
            return operations.stream()
                    .map(operation -> (Depot) operation)
                    .map(depot -> {
                        DepotDto depotDto = depotMapper.depotToDepotDto(depot);
                        depotDto.setIdCompte(depot.getCompte().getIdCompte());
                        return depotDto;
                    })
                    .collect(Collectors.toList());

        } else if (typeOperation.equals("virement")) {
            List<Operation> operations = operationRepository.findByTypeOperation("virement");
            return operations.stream()
                    .map(operation -> (Virement) operation)
                    .map(virement -> {
                        VirementDto virementDto = virementMapper.virementToVirementDto(virement);
                        virementDto.setIdCompte(virement.getCompte().getIdCompte());
                        return virementDto;
                    })
                    .collect(Collectors.toList());
        } else {
            String msgError = messageSource.getMessage("operation.not.found.message",
                    new Object[]{}, Locale.getDefault());
            throw new CustomerException(msgError);
        }
    }

    // Version 2 to creat OpertionDto
    @Override
    public OperationDto createOperation(OperationDto operationDto) {

        Compte compte = compteRepository.findCompteByRibCompte(operationDto.getRibCompte());
        System.out.println("Display Account:" + compte);
        if (compte == null) {
            String msgError = messageSource.getMessage("account.not.found.message",
                    new Object[]{}, Locale.getDefault());
            throw new CustomerException(msgError);
        }

        if (operationDto.getTypeOperation().equals("depot")) {
            Depot depot = new Depot();
            depot.setMontant(operationDto.getMontant());
            depot.setDescription(operationDto.getDescription());
            depot.setDateOperation(operationDto.getDateOperation());
            depot.setSensOperation(operationDto.getSensOperation());
            depot.setTypeOperation(operationDto.getTypeOperation());
            depot.setCompte(compte);
            depot.setSourceDepot(operationDto.getSourceDepot());
            Depot saveDepot = operationRepository.save(depot);
            DepotDto depotDto = depotMapper.depotToDepotDto(saveDepot);
            depotDto.setIdCompte(compte.getIdCompte());
            System.out.println("get id compte" + compte.getIdCompte());
            return depotDto;

        } else {
            Virement virement = new Virement();
            virement.setMontant(operationDto.getMontant());
            virement.setDescription(operationDto.getDescription());
            virement.setDateOperation(operationDto.getDateOperation());
            virement.setSensOperation(operationDto.getSensOperation());
            virement.setTypeOperation(operationDto.getTypeOperation());
            virement.setRibCompteDestinataire(operationDto.getRibCompteDestinataire());
            virement.setCompte(compte);
            Virement saveVirement = operationRepository.save(virement);
            VirementDto virementDto = virementMapper.virementToVirementDto(saveVirement);
            virementDto.setIdCompte(compte.getIdCompte());
            return virementMapper.virementToVirementDto(saveVirement);
        }
    }


    public List<VirementDto> getAllVirements() {
        List<Operation> operations = operationRepository.findByTypeOperation("virement");

        if (operations == null || operations.isEmpty()) {
            String msgError = messageSource.getMessage("virement.not.found.message",
                    new Object[]{}, Locale.getDefault());
            throw new CustomerException(msgError);
        }

        List<VirementDto> virementDtos = new ArrayList<>();
        for (Operation operation : operations) {
            VirementDto virementDto = new VirementDto();
            virementDto.setIdOperation(operation.getIdOperation());
            virementDto.setMontant(operation.getMontant());
            virementDto.setDescription(operation.getDescription());
            virementDto.setDateOperation(operation.getDateOperation());
            virementDto.setSensOperation(operation.getSensOperation());
            virementDto.setTypeOperation(operation.getTypeOperation());
            virementDto.setIdCompte(operation.getCompte().getIdCompte());
            virementDto.setRibCompte(operation.getCompte().getRibCompte());
            virementDto.setRibCompteDestinataire(operation.getCompte().getIdCompte());
            virementDto.setRibCompteDestinataire(operation.getCompte().getRibCompte());
            virementDtos.add(virementDto);
        }
        return virementDtos;
    }


    public List<OperationDto> getAllOperations() {

        List<Operation> operations = operationRepository.findAll();

        if (operations == null) {
            String msgError = messageSource.getMessage("operation.not.found.message",
                    new Object[]{}, Locale.getDefault());
            throw new CustomerException(msgError);
        }

        List<OperationDto> operationDtos = new ArrayList<>();
        for (Operation operation : operations) {
            OperationDto operationDto;

            if (operation instanceof Virement) {
                operationDto = new VirementDto();
                Virement virement = (Virement) operation;
                ((VirementDto) operationDto).setRibCompteDestinataire(virement.getRibCompteDestinataire());
//                ((VirementDto) operationDto).setMotif(virement.getMotif());
            } else if (operation instanceof Depot) {
                operationDto = new DepotDto();
                Depot depot = (Depot) operation;
                ((DepotDto) operationDto).setSourceDepot(depot.getSourceDepot());
//                ((DepotDto) operationDto).setDateDepot(depot.getDateDepot());
            } else {
                operationDto = new OperationDto();
            }

            BeanUtils.copyProperties(operation, operationDto, "compte");
            operationDto.setIdCompte(operation.getCompte().getIdCompte());
            operationDto.setRibCompte(operation.getCompte().getRibCompte());
            operationDtos.add(operationDto);
        }

        return operationDtos;
    }



}





