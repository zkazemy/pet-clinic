package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.Model.Owner;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
    OwnerMapService ownerMapService;
    final Long ownerId= 1L;
    final String lastName = "Smith";
    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setLastName(lastName);
        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
       ownerMapService.deleteById(ownerId);
       assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistId() {
        Long id= 2L;
        Owner owner2 = new Owner();
        owner2.setId(id);
        ownerMapService.save(owner2);

        assertEquals(id, owner2.getId());
    }

    @Test
    void saveNoId() {
        Owner owner2 = new Owner();;
        ownerMapService.save(owner2);

        assertNotNull(owner2);
        assertNotNull(owner2.getId());

    }
    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertNotNull(owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertNotNull(owner.getId());
    }
}