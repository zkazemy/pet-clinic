package guru.springframework.sfgpetclinic.Model;


import java.util.Set;

/**
 * Created by jt on 7/13/18.
 */

public class Owner extends Person {
private Set<Pet> pets;

    public Owner(Set<Pet> pets) {
        this.pets = pets;
    }
}
