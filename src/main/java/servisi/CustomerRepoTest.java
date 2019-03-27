package servisi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import main.Mapiranje;
import repo.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepoTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository customers;

    @Test
    public void testfindByTip() {
        Mapiranje customer = new Mapiranje(0, "first", 0, 0, "last", null, null, 0);
        entityManager.persist(customer);

        List<Mapiranje> findByTip = customers.findByTip(customer.getTip());

        assertThat(findByTip).extracting(Mapiranje::getLastName).containsOnly(customer.getTip());
    }
}