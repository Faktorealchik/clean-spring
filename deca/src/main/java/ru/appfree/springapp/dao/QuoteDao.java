package ru.appfree.springapp.dao;

import ru.appfree.springapp.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteDao extends JpaRepository<Quote, Long> {

}