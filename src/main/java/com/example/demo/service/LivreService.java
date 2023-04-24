package com.example.demo.service;
import com.example.demo.entity.livre;
import com.example.demo.repository.LivreRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LivreService {
	
	@Autowired
    private LivreRepository livreRepository;
	
	public List<livre> getAllLivres() {
        return livreRepository.findAll();
    }
    
    public livre getLivreById(Long id) {
        return livreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }
    
    public void saveLivre(livre livre) {
    	livreRepository.save(livre);
    }
    
    public void deleteLivre(Long id) {
    	livreRepository.deleteById(id);
    }
    public livre updateBook(Long id, livre book) {
        livre existingBook = livreRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        existingBook.setTitre(book.getTitre());
        existingBook.setAuteur(book.getAuteur());
        existingBook.setGenre(book.getGenre());
        existingBook.setLangue(book.getLangue());
        existingBook.setName(book.getName());
        existingBook.setNbcopie(book.getNbcopie());
        existingBook.setPrix(book.getPrix());
        return livreRepository.save(existingBook);
    }

}
