package com.campomagico.biblioteca.service;

import com.campomagico.biblioteca.model.Categoria;
import com.campomagico.biblioteca.repository.CategoriaRepository;
import com.campomagico.biblioteca.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria findById(Long id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", tipo: " + Categoria.class.getName()));
    }
}
