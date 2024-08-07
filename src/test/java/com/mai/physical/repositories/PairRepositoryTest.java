package com.mai.physical.repositories;

import com.mai.physical.domain.Pair;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    @Mock
    PairRepository pairRepository;

    @InjectMocks
    VetSDJpaService service;

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(vetRepository).deleteById(1L);
    }
}

@RunWith(SpringRunner.class)
@DataJpaTest(showSql = false)
@ActiveProfiles("joins")
public class PairRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;


    @Test
    void findAll()
    {
    }

    @Test
    void findAllByCableId()
    {
    }

    @Test
    public void whenPathExpressionIsUsedForSingleValuedAssociation_thenCreatesImplicitInnerJoin() {
        TypedQuery<Pair> query
                = entityManager.createQuery(
                "SELECT e.department FROM Employee e", Department.class);
        List<Department> resultList = query.getResultList();

        // Assertions...
    }
}