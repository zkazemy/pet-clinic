package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.Model.Owner;
import guru.springframework.sfgpetclinic.Model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
