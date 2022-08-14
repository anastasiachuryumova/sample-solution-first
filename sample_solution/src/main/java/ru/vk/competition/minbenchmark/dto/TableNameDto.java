package ru.vk.competition.minbenchmark.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TableNameDto {
    @NotNull
    @Size(min = 1, max = 50)
    private String tableName;

    @NotNull
    @Size(min = 1, max = 120)
    private String primaryKey;

}
