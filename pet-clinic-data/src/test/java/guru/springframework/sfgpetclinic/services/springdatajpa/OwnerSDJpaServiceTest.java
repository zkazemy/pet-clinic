package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.Model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService service;

    final Long ownerId= 1L;
    final String lastName = "Smith";
    Owner returnOwner;

    @BeforeEach
    void setUp() {

        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setLastName(lastName);
        service.save(owner);
        returnOwner = owner;
    }

    @Test
    void findByLastName() {
        when(service.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName("Smith");
        assertNotNull( smith);
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setLastName("Kazemi");

        Owner owner2 = new Owner();
        owner2.setId(1L);
        owner2.setLastName("Kazemi");

        owners.add(owner1);
        owners.add(owner2);

        when(ownerRepository.findAll()).thenReturn(owners);

        assertEquals(2, service.findAll().size());
    }

    @Test
    void deleteById() {
        service.deleteById(ownerId);
        assertEquals(0, service.findAll().size());
    }

    @Test
    void delete() {
        service.delete(service.findById(ownerId));
        assertEquals(0, service.findAll().size());
    }
    @Test
    void save() {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(1L);
        ownerToSave.setLastName("Kazemi");

        when(ownerRepository.save(any())).thenReturn(ownerToSave);
        service.save(ownerToSave);

        assertNotNull(ownerToSave);
        assertNotNull(ownerToSave.getId());

    }
    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(ownerId);
        assertNotNull(owner.getId());
    }

}