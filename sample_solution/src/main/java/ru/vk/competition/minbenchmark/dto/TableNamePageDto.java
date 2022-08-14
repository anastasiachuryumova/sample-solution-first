package ru.vk.competition.minbenchmark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TableNamePageDto {
    private List<TableNameDto> columnsInfos;
    private int columnsAmount;
    private int resultCode;

}
