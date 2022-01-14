package com.example.esportsbackend.service.caster;

import com.example.esportsbackend.handlers.exceptions.CasterNotFoundException;
import com.example.esportsbackend.model.Caster;
import com.example.esportsbackend.repository.CasterRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CasterServiceImplTest {

    @Mock
    CasterRepository casterRepository;

    @InjectMocks
    CasterServiceImpl sut;

    private Caster caster;

    @BeforeEach
    private void setUp(){
        caster = new Caster(1L, "John", "Doe", new Date(1999, 8, 15), "Lebanese");
    }

    @Test
    void addCaster() {
        //arrange
        when(casterRepository.save(caster)).thenReturn(caster);

        //act
        Caster savedCaster = sut.addCaster(caster);

        //assert
        assertEquals(caster.id, savedCaster.id);
        assertEquals(caster.name, savedCaster.name);
        assertEquals(caster.surname, savedCaster.surname);
        assertEquals(caster.dateOfBirth, savedCaster.dateOfBirth);
        assertEquals(caster.nationality, savedCaster.nationality);

    }

    @Test
    void findAll() {
        //arrange
        when(casterRepository.findAll()).thenReturn(List.of(caster));

        //act
        List<Caster> casterList = sut.findAll();

        //asserts
        assertEquals(caster.id, casterList.get(0).id);
        assertEquals(caster.name, casterList.get(0).name);
        assertEquals(caster.surname, casterList.get(0).surname);
        assertEquals(caster.dateOfBirth, casterList.get(0).dateOfBirth);
        assertEquals(caster.nationality, casterList.get(0).nationality);
    }

    @Test
    @DisplayName("Finds a caster by ID succesfully")
    void findById() {
        //arrange
        when(casterRepository.findById(caster.id)).thenReturn(Optional.ofNullable(caster));

        //act
        Caster foundCaster = sut.findById(caster.id);

        //assert
        assertEquals(caster.id, foundCaster.id);
        assertEquals(caster.name, foundCaster.name);
        assertEquals(caster.surname, foundCaster.surname);
        assertEquals(caster.dateOfBirth, foundCaster.dateOfBirth);
        assertEquals(caster.nationality, foundCaster.nationality);
    }

    @Test
    @DisplayName("Throws CasterNotFoundException")
    void shouldThrowCasterNotFoundExceptionWhenFindByNonExistingId(){
        when(casterRepository.findById(caster.id)).thenReturn(Optional.empty());

        assertThrows(CasterNotFoundException.class,
                () -> sut.findById(caster.id));
    }

    @Test
    void findByNationality(){
        when(casterRepository.findByNationality(caster.nationality))
                .thenReturn(List.of(caster));

        List<Caster> casterList = sut.findByNationalityAndOrName(null, caster.nationality);

        assertNotNull(casterList);
        assertEquals(1, casterList.size());
        assertEquals(caster, casterList.get(0));
    }

    @Test
    void findByName(){
        when(casterRepository.findByName(caster.name))
                .thenReturn(List.of(caster));

        List<Caster> casterList = sut.findByNationalityAndOrName(caster.name, null);

        assertNotNull(casterList);
        assertEquals(1, casterList.size());
        assertEquals(caster, casterList.get(0));
    }

    @Test
    void findByNameAndNationality(){
        when(casterRepository.findByNationalityAndName(caster.name, caster.nationality))
                .thenReturn(List.of(caster));

        List<Caster> casterList = sut.findByNationalityAndOrName(caster.nationality, caster.name);

        assertNotNull(casterList);
        assertEquals(1, casterList.size());
        assertEquals(caster, casterList.get(0));
    }

    @Test
    void updateCaster() {
        Caster newCaster = new Caster(2L, "Maria", "Doe", new Date(1999, 8, 15), "YasQueen");
        when(casterRepository.findById(newCaster.getId())).thenReturn(Optional.of(caster));
        when(casterRepository.save(newCaster)).thenReturn(newCaster);

        Caster result = sut.updateCaster(newCaster);

        assertNotNull(result);
        assertEquals(newCaster.id, result.id);
        assertEquals(newCaster.name, result.name);
        assertEquals(newCaster.surname, result.surname);
        assertEquals(newCaster.dateOfBirth, result.dateOfBirth);
        assertEquals(newCaster.nationality, result.nationality);
    }

    @Test
    void shouldThrowWhenIdNotFound(){
        when(casterRepository.findById(caster.getId())).thenReturn(Optional.empty());

        assertThrows(CasterNotFoundException.class,
                () -> sut.updateCaster(caster));
    }

    @Test
    void deleteCaster() {
        when(casterRepository.findById(caster.id)).thenReturn(Optional.of(caster));
        when(casterRepository.deleteCasterById(caster.id)).thenReturn(caster);

        Caster deletedCaster = sut.deleteCaster(caster.id);

        assertNotNull(deletedCaster);
        assertEquals(caster, deletedCaster);
    }

    @Test
    void shouldThrowNotFoundOnDeleteWhenIdNotFounds(){
        when(casterRepository.findById(caster.id)).thenReturn(Optional.empty());

        assertThrows(CasterNotFoundException.class,
                ()->sut.deleteCaster(caster.getId()));
    }
}