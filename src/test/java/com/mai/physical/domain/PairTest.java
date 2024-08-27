package com.mai.physical.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;

import com.mai.physical.repositories.PairRepository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class PairTest {

    @Autowired
    PairRepository pairRepository;

    @Autowired
    private Environment env;

    @Autowired
    TestEntityManager entityManager;

    @Test
    @Disabled
    void givenParentWithUnidirectionalRelationship_whenSaveParentWithChildren_thenNoChildrenPresentInDB() {
        Pair parent = new Pair();

        List<PairBinding> cables = new ArrayList<>();
        cables.add(new PairBinding());
        cables.add(new PairBinding());
        cables.add(new PairBinding());

        parent.setCables(cables);

        entityManager.persist(parent);

        Pair foundParent = entityManager
                .find(Pair.class, parent.getObjectId());
        assertThat(foundParent.getCables())
                .hasSize(3);

        Pair pair = foundParent.getCables().get(0).getPair();
        Optional<Pair> opt = Optional.ofNullable(pair);
        assertTrue(opt.isPresent());
        assertThat(opt.get().getObjectId()).isNotNull();
    }

    @Test
    void tmpTest() {

        Author parent = new Author();

        List<Post> cables = new ArrayList<>();
        cables.add(new Post());
        cables.add(new Post());
        cables.add(new Post());

        parent.setPosts(cables);
        parent.setName("SomeName");

        entityManager.persist(parent);

        Author cc = entityManager.persist(parent);
       // assertThat(cc.getPosts()).isNotNull();
        System.out.println(cc.getId());

        Author foundParent = entityManager
                .find(Author.class, 1L);
        assertThat(foundParent.getPosts())
                .hasSize(3);

        Author author = foundParent.getPosts().get(0).getAuthor();
        Optional<Author> opt = Optional.ofNullable(author);
        assertTrue(opt.isPresent());
        assertThat(opt.get().getId()).isNotNull();
    }
}