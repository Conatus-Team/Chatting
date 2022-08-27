package conatus.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import conatus.domain.entity.ChattingRoom;
import conatus.domain.entity.RoomMember;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface RoomMemberRepository extends PagingAndSortingRepository<RoomMember, Long> {


}

