package com.campomagico.biblioteca.service;

import com.campomagico.biblioteca.model.Livro;
import com.campomagico.biblioteca.repository.LivroRepository;
import com.campomagico.biblioteca.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Long id){
        Optional<Livro> obj = livroRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Long id_cat) {
        categoriaService.findById(id_cat);
        return livroRepository.findAllByCategoria(id_cat);
    }
}
