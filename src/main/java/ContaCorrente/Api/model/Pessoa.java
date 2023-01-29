package ContaCorrente.Api.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column
    private Date dataNascimento;

}
