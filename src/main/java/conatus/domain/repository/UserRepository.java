package conatus.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import conatus.domain.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	User findByUserId(Long userId);
}

