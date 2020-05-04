package com.mmarciniak.reservationservice.repository;

import com.mmarciniak.reservationservice.entity.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserDto,Long> {

    Optional<UserDto> findUserDtoByName(String name);
}
