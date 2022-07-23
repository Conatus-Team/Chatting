package conatus.domain;

import conatus.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "chattings", path = "chattings")
public interface ChattingRepository
    extends PagingAndSortingRepository<Chatting, Long> {}
