package org.example.exobonusspringforum.dao;

import org.example.exobonusspringforum.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
