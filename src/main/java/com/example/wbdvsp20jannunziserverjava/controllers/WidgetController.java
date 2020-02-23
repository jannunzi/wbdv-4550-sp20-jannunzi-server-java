package com.example.wbdvsp20jannunziserverjava.controllers;

import com.example.wbdvsp20jannunziserverjava.models.Widget;
import com.example.wbdvsp20jannunziserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    @Autowired
    WidgetService service;

    @PostMapping("/widgets")
    public Widget createWidget(
            @RequestBody Widget newWidget) {
        return service.createWidget(newWidget);
    }

    @DeleteMapping("/widgets/{widgetId}")
    public int deleteWidget(
            @PathVariable("widgetId") Integer wid) {
        return service.deleteWidget(wid);
    }

    @PutMapping("/widgets/{widgetId}")
    public int updateWidget(
            @PathVariable("widgetId") Integer wid,
            @RequestBody Widget updatedWidget) {
        return service.updateWidget(wid, updatedWidget);
    }

    @GetMapping("/widgets/{widgetId}")
    public Widget findWidgetById(
            @PathVariable("widgetId") Integer wid) {
        return service.findWidgetById(wid);
    }

    @GetMapping("/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

//    @GetMapping("/topics/{tid}/widgets")
//    public List<Widget> findWidgetsForTopic(
//            @PathVariable("tid") String topicId) {
//        return service.findWidgetsForTopic(topicId);
//    }
}
