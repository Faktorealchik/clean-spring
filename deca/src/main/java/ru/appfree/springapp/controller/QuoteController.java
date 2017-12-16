package ru.appfree.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.appfree.springapp.model.Quote;
import ru.appfree.springapp.service.QuoteService;

import javax.validation.Valid;

@Controller
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @RequestMapping(value="/")
    public void modelQuote(Model model, @ModelAttribute("quote") Quote quote){
        model.addAttribute("currentQuote", quote);
    }

    @RequestMapping(value = "/{quoteId}")
    public @ResponseBody
    Quote findQuoteObject(Model model,
                          @PathVariable("quoteId") Long quoteId) {
        return this.quoteService.find(quoteId);
    }

    @RequestMapping(value = "/{quoteId}")
    public String findQuote(Model model,
                            @PathVariable("quoteId") Long quoteId) {
        model.addAttribute("quote", this.quoteService.find(quoteId));
        return "quote";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveQuote(@Valid @ModelAttribute Quote quote,
                            Errors errors, RedirectAttributes attributes) {
        if(errors.hasErrors()){
            return "quote_add";
        }
        this.quoteService.save(quote);
        attributes.addFlashAttribute("quote", quote);
        return "redirect:/";
    }
}
