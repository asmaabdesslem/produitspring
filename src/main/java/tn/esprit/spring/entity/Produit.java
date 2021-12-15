package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table( name = "Produit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name="idProduit")
	private Long idProduit; // Clé primaire
	private String code;
	private String Name;
	private String libelle;
	private String image;
	private float prixUnitaire;
	  @Enumerated(EnumType.STRING)
		private CategorieProduit categorieProduit;
	@OneToMany(mappedBy="produit")
	private List<DetailFacture> detailFacture;
	@OneToOne
	private DetailProduit detailProduit;
	@ManyToOne
	private Stock stock;
	@ManyToOne
	private Rayon rayon;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> fournisseur;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
