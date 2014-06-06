package com.nttdata.kata.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.kata.domain.ApplicationPacket;
@Repository
public interface ApplicationPacketRepository extends CrudRepository<ApplicationPacket, Long> {

}
