package com.example.gestor_de_livros.controller;


import com.example.gestor_de_livros.model.Livro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    ArrayList<Livro> listalivros=new ArrayList<>();

    @GetMapping("/lista")
    public ArrayList<Livro> listarlivros(){
    return listalivros;
    }

    @PostMapping("/inserir")
    public String inserirlivro(@RequestBody Livro livro){
        listalivros.add(livro);
        return "Livro Adicionado";
    }

    @GetMapping("/existe-livro")
    public boolean existelivro(@RequestParam String titulo){

        for (Livro livro:listalivros){
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                return true;
            }
        }
        return false;
    }

    @GetMapping("/pesquisa-titulo")
    public Livro pesquisatitulo(@RequestParam String titulo){
        for (Livro livro:listalivros){
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                return livro;
            }
        }
        return null;
    }

    @GetMapping("/pesquisa-autor")
    public Livro pesquisaautor(@RequestParam String autor){
        for (Livro livro:listalivros){
            if (livro.getAutor().equalsIgnoreCase(autor)){
                return livro;
            }
        }
        return null;
    }

    @GetMapping("/pesquisa-editora")
    public Livro pesquisaeditora(@RequestParam String editora){
        for (Livro livro:listalivros){
            if (livro.getEditora().equalsIgnoreCase(editora)){
                return livro;
            }
        }
        return null;
    }

    @GetMapping("/pesquisa-paginas")
    public Livro pesquisapaginas(@RequestParam int paginas){
        for (Livro livro:listalivros){
            if (livro.getPaginas()>=paginas){
                return livro;
            }
        }
        return null;
    }

}
