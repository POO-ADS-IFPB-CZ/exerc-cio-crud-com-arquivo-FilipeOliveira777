package dao;

import model.Pessoa;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class PessoaDao {

    private final File arquivo;

    public PessoaDao(){
        arquivo = new File("pessoas.ser");
        if(!arquivo.exists()){
            try {
                arquivo.createNewFile();

            }
            catch (IOException e){
                System.out.println("Falha ao criar arquivo");
            }
        }
    }

    public Set<Pessoa> getPessoas() {
        if (arquivo.length() > 0) {
            try {
                FileInputStream inputStream = new FileInputStream(arquivo);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                return (Set<Pessoa>) objectInputStream.readObject();
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Falha ao ler arquivo");
            }
        }
        return new HashSet<>();
    }

    public boolean salvar(Pessoa pessoa) {
        Set<Pessoa> pessoas = getPessoas();
        if (pessoas.add(pessoa)) {
            try {
                FileOutputStream outputStream = new FileOutputStream(arquivo);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(pessoas);
                return true;
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            } catch (IOException e) {
                System.out.println("Falha ao escrever no arquivo");
            }
        }
        return false;
    }

    public boolean deletar(Pessoa pessoa) {
        Set<Pessoa> pessoas = getPessoas();
        if (pessoas.remove(pessoa)) {
            try {
                FileOutputStream outputStream = new FileOutputStream(arquivo);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(pessoas);
                return true;
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            } catch (IOException e) {
                System.out.println("Falha ao escrever no arquivo");
            }
        }
        return false;
    }

    public boolean buscarPorEmail(String email) {
        Set<Pessoa> pessoas = getPessoas();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getEmail().equals(email)) return true;
        }
        return false;
    }

    public boolean deletarPorEmail(String email) {
        Set<Pessoa> pessoas = getPessoas();
        Pessoa pessoaParaDeletar = null;
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getEmail().equals(email)) {
                pessoaParaDeletar = pessoa;
                break;
            }
        }
        if (pessoaParaDeletar != null) {
            pessoas.remove(pessoaParaDeletar);
            salvar((Pessoa) pessoas);
            return true;
        }

        return false;
    }


}
