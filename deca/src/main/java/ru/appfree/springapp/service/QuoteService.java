package ru.appfree.springapp.service;


import ru.appfree.springapp.model.Quote;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class QuoteService {
    private List<Quote> quotes = new LinkedList<>();


    public void save(Quote quote) {
        this.quotes.add(quote);
    }

    private Quote createQuote(String quote) {
        Quote newQuote = new Quote(quote);
        newQuote.setScore(0);
        return newQuote;
    }

    public String getRandomQuote() {
        Long RANDOM = ThreadLocalRandom.current().nextLong(1, quotes.size() - 1);
        Quote randomQoute = quotes.get(Math.toIntExact(RANDOM));
        return randomQoute.getQuote();
    }

    public Quote find(Long quoteId) {
        return this.quotes.stream().filter(p -> p.getQuoteId().equals(quoteId)).collect(Collectors.toList()).get(0);
    }
}