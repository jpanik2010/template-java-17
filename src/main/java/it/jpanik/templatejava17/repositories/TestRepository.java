package it.jpanik.templatejava17.repositories;

import it.jpanik.templatejava17.entities.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jPanik
 */
@Repository
public interface TestRepository extends CrudRepository<Test, Long> {

}
