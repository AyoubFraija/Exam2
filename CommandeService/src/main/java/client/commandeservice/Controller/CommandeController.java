package client.commandeservice.Controller;

import client.commandeservice.Model.Commande;
import client.commandeservice.Service.CommandeService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.util.List;

@Controller
public class CommandeController implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    private CommandeService commandeService;

    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    public Commande getCommandeById(Long id) {
        return commandeService.getCommandeById(id);
    }

    public Commande createCommande(Long produitId, int quantite, String dateCommande) {
        Commande commande = new Commande();
        commande.setProduitId(produitId);
        commande.setQuantite(quantite);
        commande.setDateCommande(Date.valueOf(dateCommande));
        return commandeService.createCommande(commande);
    }

    public boolean deleteCommande(Long id) {
        commandeService.deleteCommande(id);
        return true;
    }
}