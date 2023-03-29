package ma.atos.ma.atos.bankmanagement.services;

import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.Dtos.AgenceDto;
import ma.atos.ma.atos.bankmanagement.entities.Agence;
import ma.atos.ma.atos.bankmanagement.exceptions.AgenceException;
import ma.atos.ma.atos.bankmanagement.mappers.AgenceMapper;
import ma.atos.ma.atos.bankmanagement.repositories.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Transactional
@Service
@AllArgsConstructor
public class AgenceServiceImp implements AgenceService {

    @Autowired
    AgenceRepository agenceRepository;
    @Autowired
    AgenceMapper agenceMapper;
    @Autowired
    MessageSource messageSource;

    @Override
    public List<AgenceDto> listAgences() throws AgenceException {
        List<Agence> agences = agenceRepository.findAll();
        List<AgenceDto> agenceDtos = new ArrayList<>();
        if (!CollectionUtils.isEmpty((agences))) {
            agences.stream().forEach((agence -> {
                agenceDtos.add(agenceMapper.agenceToAgenceDto(agence));
            }));
        } else {
            throw new AgenceException(messageSource.getMessage("Agence.list.not.found.message", new Object[]{}, Locale.getDefault()));
        }
        return agenceDtos;
    }

    @Override
    public AgenceDto getAgence(String codeAgence) throws AgenceException {
        Agence agence = agenceRepository.findAgenceByCodeAgence(codeAgence).get();

        if (agence == null) {
            throw new AgenceException(
                    messageSource.getMessage("Agence.not.found.message", new Object[]{codeAgence}, Locale.getDefault()));

        } else {
            return agenceMapper.agenceToAgenceDto(agence);
        }
    }

    @Override
    public void createAgence(AgenceDto agenceDto) throws AgenceException {
        Agence agence = agenceMapper.agenceDtoToAgence(agenceDto);
        try {
            agenceRepository.save(agence);
        } catch (Exception e) {
            messageSource.getMessage("Agence.creation.failed.message", new Object[]{}, Locale.getDefault());

        }

    }

    @Override
    public void deleteAgence(String codeAgence) throws AgenceException {
        if (!agenceRepository.findAgenceByCodeAgence(codeAgence).isPresent()) {
            messageSource.getMessage("Agence.not.found.message", new Object[]{}, Locale.getDefault());
        } else {

            agenceRepository.deleteBycodeAgence(codeAgence);
        }
    }
}
