package com.app.dasa.api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Setter
    private String nome;

    @NonNull
    @Setter
    private String tipo;

    @NonNull
    @Setter
    private Boolean status;

    public Exam(@NonNull String nome, @NonNull String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.status = true;
    }

}
