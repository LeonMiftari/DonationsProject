package services.impls;


import entities.DonatoretEntity;
import mappers.DonatoretMappers;
import models.DonatoretChangeStatusDto;
import models.DonatoretDto;
import repositories.DonatoretRepository;
import services.DonatoretService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DonatoretServiceimpl implements DonatoretService {

    private final DonatoretRepository repository;
    private final DonatoretMappers mapper;

    public DonatoretServiceimpl(DonatoretRepository repository, DonatoretMappers mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public boolean add(DonatoretDto donatoretDto) {
        var entity = mapper.toEntity(donatoretDto);
        repository.save(entity);
        return true;
    }

    @Override
    public List<DonatoretDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public DonatoretDto getById(long id) {
        Optional<DonatoretEntity> optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty())
            throw new EntityNotFoundException("Donatoret not found with id " + id);
        return mapper.toDto(optionalEntity.get());
    }

    @Override
    public boolean update(long id, DonatoretDto updatedDonatoretDto) {
        Optional<DonatoretEntity> optionalDonatoret = repository.findById(id);
        if (optionalDonatoret.isEmpty())
            throw new EntityNotFoundException("Donatoret not found with id " + id);

        DonatoretEntity entity = optionalDonatoret.get();
        entity.setName(updatedDonatoretDto.getName());
        entity.setSurname(updatedDonatoretDto.getSurname());
        entity.setDonationCategory(updatedDonatoretDto.getDonationCategory());

        repository.save(entity);
        return true;
    }

    @Override
    public boolean deleteById(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean changeStatus(long id, DonatoretChangeStatusDto dto) {
        Optional<DonatoretEntity> optionalDonatoret = repository.findById(id);
        if (optionalDonatoret.isEmpty())
            throw new EntityNotFoundException("Donatoret not found with id " + id);

        DonatoretEntity entity = optionalDonatoret.get();
        entity.setActive(dto.isActive());

        repository.save(entity);
        return true;
    }
}
