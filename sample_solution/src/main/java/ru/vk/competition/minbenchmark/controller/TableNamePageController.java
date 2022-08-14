package ru.vk.competition.minbenchmark.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vk.competition.minbenchmark.dto.TableNameDto;
import ru.vk.competition.minbenchmark.service.TableNameService;

@Controller
@RequiredArgsConstructor
public class TableNamePageController {

    private final TableNameService tableNameService;

    @GetMapping("/tableNames")
    public String allTableNames() {
        return "tableName/tableNames";
    }

    @GetMapping("/tableName/add")
    public String newTableName() {
        return "tableName/tableName";
    }

    @GetMapping("/tableName/edit")
    public String currentTableName(@RequestParam("primaryKey") String primaryKey, Model model) {
        TableNameDto currentTableName = tableNameService.getByPrimaryKey(primaryKey)
                .orElseThrow(() -> new IllegalArgumentException("Таблицы с таким именем не существует"));
        model.addAttribute("tableName", currentTableName);
        return "tableName/tableName";
    }

    @PostMapping("/tableName/save")
    public String saveTableName(TableNameDto tableName) {
        tableNameService.save(tableName);
        return "redirect:/tableNames";
    }
}
