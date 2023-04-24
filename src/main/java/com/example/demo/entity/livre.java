package com.example.demo.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class livre {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer idLivre;

	@Column private String name;
	@Column private String auteur;
	@Column	private String titre;
	@Column	private String genre;
	@Column	private String langue;
	@Column	private Integer nbcopie;
	@Column	private float prix;
	
	@OneToMany(mappedBy = "Livre", cascade = CascadeType.ALL)
    private List<emprunt> emprunts;
    
	public Integer getIdLivre() {
		return idLivre;
	}
	public Integer getNbcopie() {
		return nbcopie;
	}
	public void setIdLivre(Integer idLivre) {
		this.idLivre = idLivre;
	}
	public void setNbcopie(Integer nbcopie) {
		this.nbcopie = nbcopie;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public livre(Integer idLivre,Integer nbcopie, String name, String auteur, String titre, String genre, String langue, float prix) {
		this.idLivre = idLivre;
		this.name = name;
		this.auteur = auteur;
		this.titre = titre;
		this.genre = genre;
		this.langue = langue;
		this.prix = prix;
		this.nbcopie=nbcopie;
	}
	public livre()
	{
		
	}
	public livre( String name, Integer nbcopie, String auteur, String titre, String genre, String langue, float prix) {
		this.name = name;
		this.auteur = auteur;
		this.titre = titre;
		this.genre = genre;
		this.langue = langue;
		this.prix = prix;
		this.nbcopie=nbcopie;
	}

	
	
}
