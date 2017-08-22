package com.kgfsl.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kgfsl.springboot.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}