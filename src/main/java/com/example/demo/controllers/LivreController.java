package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.livre;
import com.example.demo.service.LivreService;

@RestController
@RequestMapping("/books")
public class LivreController {
	@Autowired
    private LivreService bookService;

    @GetMapping
    public List<livre> getAllBooks() {
        return bookService.getAllLivres();
    }

    @GetMapping("/{id}")
    public livre getBookById(@PathVariable Long id) {
        return bookService.getLivreById(id);
    }

    @PostMapping
    public void createBook(@RequestBody livre book) {
         bookService.saveLivre(book);
    }

    @PutMapping("/{id}")
    public livre updateBook(@PathVariable Long id, @RequestBody livre book) {
        return bookService.updateBook(id, book);
    }
    @PutMapping("/rendreLivre/{id}")
    public livre rendreLivre(@PathVariable Long id) {
        return bookService.RendreLivre(id);
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteLivre(id);
    }
}
