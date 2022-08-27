package conatus.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import conatus.domain.entity.User;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUserId(Long userId);
}

