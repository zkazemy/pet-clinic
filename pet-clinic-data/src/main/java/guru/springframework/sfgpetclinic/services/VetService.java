package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.Model.Owner;
import guru.springframework.sfgpetclinic.Model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
