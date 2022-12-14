package com.platzi.springboot.fundamentos.fundamentos.repository;

import com.platzi.springboot.fundamentos.fundamentos.dto.UserDto;
import com.platzi.springboot.fundamentos.fundamentos.entity.User;
import net.bytebuddy.asm.Advice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findUserByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name LIKE ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);

    Optional<User> findByNameAndEmail(String name, String email);

    List<User> findByNameLike(String name);
    List<User> findByNameLikeAndEmailLike(String name, String email);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);
    List<User> findByNameLikeOrderByIdAsc(String name);

    List<User> findByNameContainingOrderByIdDesc(String name);

    @Query("SELECT new com.platzi.springboot.fundamentos.fundamentos.dto.UserDto(u.id, u.name, u.birthDate) " +
            " FROM User u " +
            " WHERE u.birthDate=:dateParam " +
            " AND u.email=:emailParam ")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("dateParam")LocalDate date, @Param("emailParam") String email);

}
