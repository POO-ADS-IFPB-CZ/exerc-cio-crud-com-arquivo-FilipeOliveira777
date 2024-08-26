package model;
<<<<<<< HEAD

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String email;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

=======
import java.io.Serializable;
import java.util.Objects;
import java.util.Objects;

public class Pessoa implements Serializable {
    private String nome;
    private String email;

>>>>>>> origin/main
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

<<<<<<< HEAD
=======
    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

>>>>>>> origin/main
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(email, pessoa.email);
    }

    @Override
<<<<<<< HEAD
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Override
=======
>>>>>>> origin/main
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
<<<<<<< HEAD
=======

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
>>>>>>> origin/main
}
