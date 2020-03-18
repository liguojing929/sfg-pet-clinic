package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    //Mockito is used to mock interfaces so that a dummy functionality can be added to a mock interface that can be used in unit testing
    private OwnerRepository ownerRepository;
    @Mock
    private PetRepository petRepository;
    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks // used to mock constructor injection, setter injection, or property injection
    private OwnerSDJpaService ownerSDJpaService;

    private Owner smith;


    @BeforeEach
    void setUp() {
        smith = Owner.builder().id(1L).lastName("Smith").build();
    }

    @Test
    void findByLastName() {
        when(ownerSDJpaService.findByLastName(any())).thenReturn(smith);
        assertEquals("Smith", ownerRepository.findByLastName("Smith").getLastName());
        verify(ownerRepository).findByLastName(any());
        //use verfiy to make sure the mock is actually up and running.
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> serviceSet = ownerSDJpaService.findAll();
        assertNotNull(serviceSet);
        assertEquals(2, serviceSet.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(smith));
        Owner owner = ownerSDJpaService.findById(2L);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerSDJpaService.findById(1L);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner savedOwner = ownerSDJpaService.save(owner);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(smith);
        // verify that ownerRepository does run and only run # of times defined within
        verify(ownerRepository, times(1)).delete(smith);
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}