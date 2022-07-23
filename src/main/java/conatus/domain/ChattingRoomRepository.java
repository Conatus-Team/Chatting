package conatus.domain;

import conatus.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "chattingRooms",
    path = "chattingRooms"
)
public interface ChattingRoomRepository
    extends PagingAndSortingRepository<ChattingRoom, Long> {}
