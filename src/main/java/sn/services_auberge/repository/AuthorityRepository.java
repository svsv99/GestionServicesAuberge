package sn.services_auberge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.services_auberge.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
