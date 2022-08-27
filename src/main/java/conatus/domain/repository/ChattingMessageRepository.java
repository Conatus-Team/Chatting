package conatus.domain.repository;

import conatus.domain.entity.ChattingMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "chattingMessages", path = "chattingMessages")
public interface ChattingMessageRepository
    extends PagingAndSortingRepository<ChattingMessage, Long> {
    Page<ChattingMessage> findByChattingRoomId(Long roomId, Pageable pageable);
}
