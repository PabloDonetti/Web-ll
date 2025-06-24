package br.com.pratica4.projeto.repository;

import br.com.pratica4.projeto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Método para buscar um usuário pelo email (usado no login)
    Optional<User> findByEmail(String email);
}