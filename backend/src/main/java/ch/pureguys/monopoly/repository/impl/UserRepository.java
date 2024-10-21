package ch.pureguys.monopoly.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.pureguys.monopoly.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
}
