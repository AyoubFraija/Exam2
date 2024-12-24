package client.commandeservice.Service;
import client.commandeservice.Model.Commande;
import client.commandeservice.Repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "commande_topic";


    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElseThrow();
    }

    public Commande createCommande(Commande commande) {
        Commande savedCommande = commandeRepository.save(commande);
        kafkaTemplate.send(TOPIC, "Commande créée: " + savedCommande.getId());
        return savedCommande;
    }

    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}
