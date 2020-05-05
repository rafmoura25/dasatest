package com.app.dasa.api.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
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

    public Exam(Long id, @NonNull String nome, @NonNull String tipo, @NonNull Boolean status){
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.status = status;
    }

}
