import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final com.userservice.UserService.repos.ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(com.userservice.UserService.repos.ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<com.userservice.UserService.entities.Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public com.userservice.UserService.entities.Professor getProfessorById(Long id) {
        Optional<com.userservice.UserService.entities.Professor> optionalProfessor = professorRepository.findById(id);
        return optionalProfessor.orElse(null);
    }

    public com.userservice.UserService.entities.Professor createProfessor(com.userservice.UserService.entities.Professor professor) {
        return professorRepository.save(professor);
    }

    public com.userservice.UserService.entities.Professor updateProfessor(Long id, com.userservice.UserService.entities.Professor updatedProfessor) {
        Optional<com.userservice.UserService.entities.Professor> optionalProfessor = professorRepository.findById(id);
        if (optionalProfessor.isPresent()) {
            com.userservice.UserService.entities.Professor existingProfessor = optionalProfessor.get();
            existingProfessor.setName(updatedProfessor.getName());
            existingProfessor.setFamilyName(updatedProfessor.getFamilyName());
            existingProfessor.setEmail(updatedProfessor.getEmail());
            existingProfessor.setSpeciality(updatedProfessor.getSpecialty());
            existingProfessor.setPassword(updatedProfessor.getPassword());
            return professorRepository.save(existingProfessor);
        }
        return null;
    }

    public boolean deleteProfessor(Long id) {
        Optional<com.userservice.UserService.entities.Professor> optionalProfessor = professorRepository.findById(id);
        if (optionalProfessor.isPresent()) {
            professorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
