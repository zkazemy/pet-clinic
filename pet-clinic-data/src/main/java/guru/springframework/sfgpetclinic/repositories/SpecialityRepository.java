package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.Model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
