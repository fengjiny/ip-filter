package com.juice.ipfilter.service.impl;

import com.juice.ipfilter.dao.IpRouterInfoDao;
import com.juice.ipfilter.dao.TorRouterInfoDao;
import com.juice.ipfilter.model.IpRouterInfo;
import com.juice.ipfilter.model.TorRouterInfo;
import com.juice.ipfilter.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouterServiceImpl implements RouterService {
    @Autowired
    private IpRouterInfoDao ipRouterInfoDao;

    @Autowired
    private TorRouterInfoDao torRouterInfoDao;


    @Override
    public List<IpRouterInfo> getAllIpRouterInfo() {
        return ipRouterInfoDao.getAllIpInfo();
    }

    @Override
    public List<TorRouterInfo> getAllTorRouterInfo() {
        return torRouterInfoDao.getAllTorInfo();
    }
}
