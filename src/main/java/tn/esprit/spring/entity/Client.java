package tn.esprit.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String nom, prenom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String email, password;
    @Enumerated(EnumType.STRING)
	private CategorieClient categorieClient;
    
    @Enumerated(EnumType.STRING)
	private Profession profession;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Facture> facture;

   
}
