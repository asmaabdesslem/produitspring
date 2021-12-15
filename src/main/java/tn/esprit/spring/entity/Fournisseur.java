package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Fournisseur implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name="idFournisseur")
	private Long idFournisseur; // Clé primaire
	private String codeFournisseur;
	private String libelleFournisseur;
	
}
