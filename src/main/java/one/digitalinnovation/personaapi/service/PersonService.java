package one.digitalinnovation.personaapi.service;

import one.digitalinnovation.personaapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personaapi.dto.response.request.PersonDTO;
import one.digitalinnovation.personaapi.entity.Person;
import one.digitalinnovation.personaapi.mapper.PersonMapper;
import one.digitalinnovation.personaapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with Id" + savedPerson.getId())
                .build();
    }

}
