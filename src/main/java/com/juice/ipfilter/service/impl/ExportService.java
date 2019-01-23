package com.juice.ipfilter.service.impl;

import com.juice.ipfilter.model.IpRouterInfo;
import com.juice.ipfilter.model.TorRouterInfo;
import com.juice.ipfilter.service.RouterService;
import com.juice.ipfilter.utils.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class ExportService {

    @Autowired
    private AnalyseSevice analyseSevice;

    @Autowired
    private RouterService routerService;

    public void exportIpCount(String filePath) {
        List<IpRouterInfo> ipRouterList = routerService.getAllIpRouterInfo();
        List<TorRouterInfo> torRouterList = routerService.getAllTorRouterInfo();
        Map<String, HashMap<String, Integer>> res = analyseSevice.countIpbyCountry(ipRouterList, torRouterList);
        if (StringUtils.isEmpty(filePath)) {
            filePath = "/Users/fjy/Desktop/重复国家IP数量统计.xls";
        }
        ExportExcel.exportEcxel(res, filePath);
    }

    public void exportDupIp(String filePath) {
        List<IpRouterInfo> ipRouterList = routerService.getAllIpRouterInfo();
        List<TorRouterInfo> torRouterList = routerService.getAllTorRouterInfo();
        List<String> res = analyseSevice.findDupIp(ipRouterList, torRouterList);
        if (StringUtils.isEmpty(filePath)) {
            filePath = "/Users/fjy/Desktop/重复的IP.xls";
        }
        ExportExcel.exportEcxel(res,"重复的IP", filePath);
    }




}
