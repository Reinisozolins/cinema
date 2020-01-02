package lv.ozo.cinema.repository;

import lv.ozo.cinema.entity.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends CrudRepository <Answer,Long> {
    List<Answer> findByName(String name);
}
