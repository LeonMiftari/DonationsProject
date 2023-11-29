package repositories;

import entities.DonatoretEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonatoretRepository extends JpaRepository<DonatoretEntity, Long> {
}