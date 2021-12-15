package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.esprit.spring.service.ProduitService;
import tn.esprit.spring.service.ProduitServiceImpl;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Produit;




@RestController
public class ProduitRestController {
	
	@Autowired
	ProduitService productService;
	
	
	//http://localhost:8089/SpringMVC/addProduct
	@CrossOrigin("*")
	@PostMapping("/addProduct")
	@ResponseBody
	public String addArticle(@RequestBody Produit p) {
		
		return productService.addProduct(p);
	}
	
	//http://localhost:8089/SpringMVC/retrieve-all-products
	@CrossOrigin("*")
	@GetMapping("/retrieve-all-products")
	@ResponseBody
	public List<Produit> getProduits() {
		List<Produit> list = productService.retrieveAllProducts();
		 return list;
	}
	
	//http://localhost:8089/SpringMVC/deleteProduct/{id_product}
	@CrossOrigin("*")
	@DeleteMapping("/deleteProduct/{id_product}") 
	@ResponseBody 
	public void deleteProduct(@PathVariable("id_product")Long id) {
		productService.deleteProduct(id);
	}

	//http://localhost:8089/SpringMVC/updateProduct
	@CrossOrigin("*")
	@PutMapping(value="/updateProduct") 
	@ResponseBody
	public void updateProduct(@RequestBody Produit p) {
		productService.updateProduct(p);
	}
	

		
	//http://localhost:8089/SpringMVC/retrieve-product-not-expensive
	@CrossOrigin("*")
			@GetMapping(value ="/retrieve-product-not-expensive")
			@ResponseBody
			public List<Produit> getProductNotExpensive() 
			{
			
			return productService.listProductNotExpensive();	    
			} 
			//http://localhost:8089/SpringMVC/retrieve-product-expensive
	@CrossOrigin("*")
					@GetMapping(value ="/retrieve-product-expensive")
					@ResponseBody
					public List<Produit> getProductExpensive() 
					{
					
					return productService.listProductExpensive();	    
					}
			
	

@GetMapping("/{id_product}")
		@ResponseBody
		@CrossOrigin(origins="*")
		public Produit getProductbyId(@PathVariable("id_product") Long idProduct) {
			return productService.getProductbyId(idProduct);
		}

					//http://localhost:8089/SpringMVC/retrieve-product-by-name/{name}
	@CrossOrigin("*")
			    	@GetMapping(value="/retrieve-product-by-name/{name}")
			    	@ResponseBody
			    	public Produit getProductByName(@PathVariable("name") String name) {
			    	return productService.getProductByName(name);
			}
			    	
			    	//http://localhost:8089/SpringMVC/affectProductStock/{idProduct}/{stockId}
	@CrossOrigin("*")
			    	@PostMapping("/affectProductStock/{idProduct}/{stockId}") 
			    	@ResponseBody 
			    	public void affectProduitToStock(@PathVariable("idProduct")Long idProduct,@PathVariable("stockId") Long stockId) {
			    		productService.affectProduitToStock(idProduct, stockId);	    	
		    
			    	}
			    	}
