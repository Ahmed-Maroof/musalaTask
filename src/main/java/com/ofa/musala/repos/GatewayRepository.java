package com.ofa.musala.repos;

import com.ofa.musala.model.Gateway;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayRepository extends CrudRepository<Gateway, Long> {
}
