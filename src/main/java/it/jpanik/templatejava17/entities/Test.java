package it.jpanik.templatejava17.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author jPanik
 */
@Entity
@SequenceGenerator(name = "TEST_SEQUENCE_GENERATOR", allocationSize = 1, sequenceName = "TEST_SEQ")
@Table(name = "TEST")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TEST_SEQUENCE_GENERATOR")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
