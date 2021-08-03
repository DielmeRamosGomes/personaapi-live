package one.digitalinnovation.personaapi.repository;

import one.digitalinnovation.personaapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
