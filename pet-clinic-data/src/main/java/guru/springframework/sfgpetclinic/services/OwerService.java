package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

public interface OwerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
