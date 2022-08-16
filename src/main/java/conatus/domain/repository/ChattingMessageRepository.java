package conatus.domain.repository;

import conatus.domain.entity.ChattingMessage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "chattingMessages", path = "chattingMessages")
public interface ChattingMessageRepository
    extends PagingAndSortingRepository<ChattingMessage, Long> {}
