package services;

import models.DonatoretChangeStatusDto;
import models.DonatoretDto;
import java.util.List;

public interface DonatoretService {

    boolean add(DonatoretDto donatoretDto);

    List<DonatoretDto> getAll();

    DonatoretDto getById(long id);

    boolean update(long id, DonatoretDto updatedDonatoretDto);

    boolean deleteById(long id);

    boolean changeStatus(long id, DonatoretChangeStatusDto dto);
}
