package everis.bootcamp.creditproductms.dao;

import everis.bootcamp.creditproductms.model.CreditProductType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CreditProductTypeRepository extends
    ReactiveMongoRepository<CreditProductType, String> {

  public Mono<CreditProductType> findByNumId(int numId);
}