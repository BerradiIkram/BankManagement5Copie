package ma.atos.ma.atos.bankmanagement.services;

import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.Dtos.RestrictionDto;
import ma.atos.ma.atos.bankmanagement.entities.Restriction;
import ma.atos.ma.atos.bankmanagement.exceptions.RestrictionException;
import ma.atos.ma.atos.bankmanagement.mappers.RestrictionMapper;
import ma.atos.ma.atos.bankmanagement.repositories.RestrictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class
RestrictionServiceImpl implements RestrictionService {
    @Autowired
    RestrictionRepository restrictionRepo;
    @Autowired
    RestrictionMapper restrictionMapper;
    @Autowired
    MessageSource messageSource;


    @Override
    public List<RestrictionDto> getResctrictions() {
        List<Restriction> restrictionDtoList = restrictionRepo.findAll();
        List<RestrictionDto> restrictionDtos = new ArrayList<>();
        restrictionDtoList.stream().forEach(restriction -> {
            restrictionDtos.add(restrictionMapper.restrictionToRestrictionDto(restriction));
        });
        return restrictionDtos;
    }
    @Override
    public Restriction getRestrictionById(Long idRestriction){
        return  restrictionRepo.findById(idRestriction).orElse(null);
    }
    @Override
    public void createRestriction( RestrictionDto restrictionDto) {
        Restriction restriction = restrictionMapper.restrictionDtoToRestriction(restrictionDto);
        restrictionRepo.save(restriction) ;
    }
    @Override
    public void deleteRestriction(Long idRestriction) throws RestrictionException {
        restrictionRepo.findById(idRestriction).orElseThrow(()-> new RestrictionException(
                messageSource.getMessage("Restriction.not.found.message", new Object[]{}
                        , Locale.getDefault()), HttpStatus.OK) );
        try {
            restrictionRepo.deleteById(idRestriction);
        } catch (Exception e) {
            throw new  RestrictionException("Failed to delete restriction !");
        }
    }
}




