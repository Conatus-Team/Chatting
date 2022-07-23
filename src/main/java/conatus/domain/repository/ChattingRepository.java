package conatus.domain.repository;

import conatus.domain.entity.Chatting;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "chattings", path = "chattings")
public interface ChattingRepository
    extends PagingAndSortingRepository<Chatting, Long> {}
