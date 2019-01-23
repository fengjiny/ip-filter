package com.juice.ipfilter.controller;

import com.juice.ipfilter.model.IpRouterInfo;
import com.juice.ipfilter.model.TorRouterInfo;
import com.juice.ipfilter.service.impl.AnalyseSevice;
import com.juice.ipfilter.service.impl.ExportService;
import com.juice.ipfilter.service.RouterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api("RouterController")
@RestController
public class RouterController {

    @Autowired
    private RouterService routerService;

    @Autowired
    private AnalyseSevice analyseSevice;



    @RequestMapping(value = "/getTorRouter.do", method = RequestMethod.POST)
    public List getTorRouter() {
        return routerService.getAllTorRouterInfo();
    }

    @RequestMapping(value = "/getIpRouter.do", method = RequestMethod.POST)
    public List getIpRouter() {
        return routerService.getAllIpRouterInfo();
    }

    @ApiOperation("查找重复的IP")
    @RequestMapping(value = "/findDupIp.do", method = RequestMethod.POST)
    public List<String> findDupIp(){
        List<IpRouterInfo> ipRouterInfoList = routerService.getAllIpRouterInfo();
        List<TorRouterInfo> torRouterInfoList = routerService.getAllTorRouterInfo();
        List<String> res = analyseSevice.findDupIp(ipRouterInfoList, torRouterInfoList);
        return res;
    }

    @ApiOperation("统计重复的国家各自对应IP数量")
    @RequestMapping(value = "/countIpByCountry.do", method = RequestMethod.POST)
    public Map countIpByCountry() {
        List<IpRouterInfo> ipRouterInfoList = routerService.getAllIpRouterInfo();
        List<TorRouterInfo> torRouterInfoList = routerService.getAllTorRouterInfo();
        return analyseSevice.countIpbyCountry(ipRouterInfoList, torRouterInfoList);
    }

    @RequestMapping(value = "/findAllIp.do", method = RequestMethod.POST)
    public List findAllIp() {
        List<IpRouterInfo> ipRouterInfoList = routerService.getAllIpRouterInfo();
        List<TorRouterInfo> torRouterInfoList = routerService.getAllTorRouterInfo();
        List<String> res = new ArrayList<>();
        ipRouterInfoList.forEach(ipRouter -> {
            res.add("ID: " + ipRouter.getId() + " ip: " + ipRouter.getIp());
        });
        res.add("=====================我是分割线===========================");
        torRouterInfoList.forEach(torRouter -> {
            res.add("ID: " + torRouter.getId() + " ip: " + torRouter.getIp());
        });
        return res;
    }
}
