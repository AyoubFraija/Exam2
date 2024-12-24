package client.produitservice.Service;

import client.produitservice.Model.Produit;
import client.produitservice.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(Long id) {
        return produitRepository.findById(id).orElseThrow();
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }
}
