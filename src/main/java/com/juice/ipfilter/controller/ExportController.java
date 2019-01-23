package com.juice.ipfilter.controller;

import com.juice.ipfilter.service.impl.ExportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("输出到Excel")
@RestController
public class ExportController {

    @Autowired
    private ExportService exportService;

    @ApiOperation("打印重复的IP到Excel")
    @RequestMapping(value = "/exportDupIp.do", method = RequestMethod.POST)
    public void exportDupIp(@RequestParam(value = "filePath", required = false)String filePath) {
        exportService.exportDupIp(filePath);
    }

    @ApiOperation("打印重复的国家对应的IP数量到Excel")
    @RequestMapping(value = "/exportCountIp.do", method = RequestMethod.POST)
    public void exportCountIp(@RequestParam(value = "filePath", required = false)String filePath) {
        exportService.exportIpCount(filePath);
    }
}
