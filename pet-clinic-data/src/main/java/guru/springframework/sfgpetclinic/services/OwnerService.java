package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.Model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);

}
