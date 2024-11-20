package ru.practice.itkacademy.itkacademy.dateTimeFormmater.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practice.itkacademy.itkacademy.dateTimeFormmater.serializer.CustomLocalDateTimeSerializer;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DateTimeModel {
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime dateTime;
}
