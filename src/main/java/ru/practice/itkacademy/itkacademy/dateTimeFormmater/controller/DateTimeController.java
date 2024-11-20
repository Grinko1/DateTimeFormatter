package ru.practice.itkacademy.itkacademy.dateTimeFormmater.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.practice.itkacademy.itkacademy.dateTimeFormmater.model.DateTimeModel;

import java.time.LocalDateTime;

@RestController
public class DateTimeController {

@PostMapping("/time")
public DateTimeModel formatDateTime(@RequestBody DateTimeModel dateTimeModel) {
    return new DateTimeModel(dateTimeModel.getDateTime());
}
    @GetMapping("/time")
    public DateTimeModel getCurrentDateTime() {
        return new DateTimeModel(LocalDateTime.now());
    }
}