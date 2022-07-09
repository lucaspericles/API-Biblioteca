package com.campomagico.biblioteca.service;

import com.campomagico.biblioteca.model.Livro;
import com.campomagico.biblioteca.repository.LivroRepository;
import com.campomagico.biblioteca.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro findById(Long id){
        Optional<Livro> obj = livroRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", tipo: " + Livro.class.getName()));
    }
}
