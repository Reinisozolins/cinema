package lv.ozo.cinema.controller;

import lv.ozo.cinema.entity.Answer;
import lv.ozo.cinema.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class KinoController {

    @Autowired
    private CinemaRepository cinemaRepository;

@GetMapping("/test")
    public String index(){
    return "test";
}
    @GetMapping("/answers")
    public String answertest(){
        return "add_answer";
    }

@PostMapping("/answers")
    public String addAnswer(@Valid Answer answer, BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "add_answer";
    }
    cinemaRepository.save(answer);
    return "redirect:add_answer";
}

    @GetMapping("/results")
    public String results (Model model){
        model.addAttribute("answers", cinemaRepository.findAll());
        return "results";
    }
}
