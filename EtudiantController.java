import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;
    
    @GetMapping("/api/etudiants")
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

@GetMapping("/api/etudiants/{id}")
public Etudiant getEtudiantById(@PathVariable Long id) {
    return etudiantRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Erreur ! "));
}
}
