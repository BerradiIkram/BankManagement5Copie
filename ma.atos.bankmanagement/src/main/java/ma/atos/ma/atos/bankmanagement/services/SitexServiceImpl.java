package ma.atos.ma.atos.bankmanagement.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.atos.ma.atos.bankmanagement.Dtos.SitexDto;
import ma.atos.ma.atos.bankmanagement.entities.Sitex;
import ma.atos.ma.atos.bankmanagement.exceptions.SitexExeption;
import ma.atos.ma.atos.bankmanagement.mappers.SitexMapper;
import ma.atos.ma.atos.bankmanagement.repositories.SitexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Transactional
@Service
@AllArgsConstructor
@Slf4j
public class SitexServiceImpl implements SitexService {

    @Autowired
    SitexRepository sitexRepository;
    @Autowired
    SitexMapper sitexMapper;
    @Autowired
    MessageSource messageSource;


    @Override
    public List<SitexDto> listSitex() throws SitexExeption {
        List<Sitex> sitexes = sitexRepository.findAll();
        List<SitexDto> sitexDtos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(sitexes)) {
            sitexes.stream().forEach(sitex -> {
                sitexDtos.add(sitexMapper.sitexToSitexDto(sitex));
            });
        } else {
            throw new SitexExeption(messageSource.getMessage("sitex.not.found.message", new Object[]{}, Locale.getDefault()));
        }
        return sitexDtos;
    }

    @Override
    public SitexDto getSitex(Long idSitex) {
        Sitex sitex = sitexRepository.findById(idSitex).get();
        SitexDto sitexDto = sitexMapper.sitexToSitexDto(sitex);
        return sitexDto;
    }


    @Override
    public void createSitex(SitexDto sitexDto) throws SitexExeption {
        Sitex sitex = sitexMapper.sitexDtoToSitex(sitexDto);
/*        Sitex save = sitexRepository.save(sitex);
        log.info(save.toString());*/
        try {
            sitexRepository.save(sitex);
        } catch (Exception e) {
            throw new SitexExeption(
                    messageSource.getMessage("sitex.creation.failed.message", new Object[]{}, Locale.getDefault())
            );
        }

    }

    @Override
    public void deleteSitex(Long idSitex) throws SitexExeption {

        if (!sitexRepository.findById(idSitex).isPresent()) {
            throw new SitexExeption(
                    messageSource.getMessage("sitex.not.found.message", new Object[]{}, Locale.getDefault())
            );
        } else {
            sitexRepository.deleteById(idSitex);
        }

    }
}
