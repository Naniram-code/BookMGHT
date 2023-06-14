package net.ims.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ims.entity.BookMGHT;

@Repository
public interface BookMGHTRepo extends JpaRepository<BookMGHT, Integer> {

}
