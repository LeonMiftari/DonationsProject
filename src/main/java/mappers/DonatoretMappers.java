package mappers;

import entities.DonatoretEntity;
import org.springframework.stereotype.Component;

import models.DonatoretChangeStatusDto;
import models.DonatoretDto;

import java.time.LocalDateTime;


@Component
public class DonatoretMappers {

    public DonatoretEntity toEntity(DonatoretDto from) {
        var to = new DonatoretEntity();
        to.setId(from.getId());
        to.setName(from.getName());
        to.setBirthdate(from.getBirthdate());
        to.setActive(from.isActive());
        to.setSurname(from.getSurname());
        to.setDonationCategory(from.getDonationCategory());
        to.setRegisterDate(from.getRegisterDate());
        to.setCreatedAt(LocalDateTime.now());
        to.setCreatedBy("admin");
        return to;
    }

    public DonatoretDto toDto(DonatoretEntity from) {
        var to = new DonatoretDto();
        to.setId(from.getId());
        to.setName(from.getName());
        to.setBirthdate(from.getBirthdate());
        to.setActive(from.isActive());
        to.setSurname(from.getSurname());
        to.setDonationCategory(from.getDonationCategory());
        to.setRegisterDate(from.getRegisterDate());
        return to;
    }

    public DonatoretChangeStatusDto toChangeStatusDto(DonatoretEntity from) {
        var to = new DonatoretChangeStatusDto();
        to.setId(from.getId());
        to.setActive(from.isActive());
        return to;
    }
}