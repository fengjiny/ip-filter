package com.juice.ipfilter.service.impl;

import com.juice.ipfilter.model.IpRouterInfo;
import com.juice.ipfilter.model.TorRouterInfo;
import com.juice.ipfilter.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnalyseSevice {

    @Autowired
    private RouterService routerService;

    /**
     * 查找两张表重复的IP
     */
    public List<String> findDupIp(List<IpRouterInfo> ipRouterInfoList, List<TorRouterInfo> torRouterInfoList) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet();
        ipRouterInfoList.forEach(t -> {
            set.add(t.getIp());
        });
        torRouterInfoList.forEach(t -> {
            if (set.contains(t.getIp())) {
                res.add(t.getIp());
            }
        });
        return res;
    }

    /**
     * 统计两张表重复的country，在各自表对应的IP数量
     * @param ipRouterInfoList
     * @param torRouterInfoList
     */
    public Map<String, HashMap<String, Integer>> countIpbyCountry(List<IpRouterInfo> ipRouterInfoList, List<TorRouterInfo> torRouterInfoList) {
        Map<String, HashMap<String, Integer>> res = new HashMap<>();
        HashMap<String, Integer> ipRouterMap = new HashMap<>();
        HashMap<String, Integer> torRouterMap = new HashMap<>();

        HashMap<String, Integer> map = new HashMap();
        ipRouterInfoList.forEach(t -> {
            map.put(t.getCountry(), map.getOrDefault(t.getCountry(), 0) + 1);
        });
        torRouterInfoList.forEach(t ->{
            //重复的country,记录两张表这个country有多少IP
            if (map.containsKey(t.getCountry())) {
                ipRouterMap.put(t.getCountry(),map.get(t.getCountry()));
                torRouterMap.put(t.getCountry(),torRouterMap.getOrDefault(t.getCountry(), 0) + 1);
            }
        });
        res.put("ipRouter", ipRouterMap);
        res.put("torRouter", torRouterMap);
        return res;
    }
}
