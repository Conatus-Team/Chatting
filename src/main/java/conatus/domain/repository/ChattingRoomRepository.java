package conatus.domain.repository;

import conatus.domain.entity.ChattingRoom;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(
    collectionResourceRel = "chattingRooms",
    path = "chattingRooms"
)
public interface ChattingRoomRepository
    extends PagingAndSortingRepository<ChattingRoom, Long> {

    Optional<ChattingRoom> findByGroupId(Long groupId);

}
