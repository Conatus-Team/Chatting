package conatus.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import conatus.domain.entity.ChattingRoom;
import conatus.domain.entity.RoomMember;

public interface RoomMemberRepository extends PagingAndSortingRepository<RoomMember, Long> {
	
	
}

