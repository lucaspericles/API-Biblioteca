package com.campomagico.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter @Setter
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "É necessário digitar um título")
    @Length(min = 3,  max = 50, message = "O campo 'título' deve ter de 3 a 50 caracteres")
    private String titulo;
    @NotEmpty(message = "É necessário digitar o nome do autor")
    private String autor;
    @NotEmpty(message = "É necessário especificar o resumo")
    @Length(min = 20,  max = 200000, message = "O campo 'nome' deve ter de 3 a 50 caracteres")
    private String sinopse;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return id.equals(livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
