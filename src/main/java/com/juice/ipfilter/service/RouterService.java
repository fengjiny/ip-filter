package com.juice.ipfilter.service;

import com.juice.ipfilter.model.IpRouterInfo;
import com.juice.ipfilter.model.TorRouterInfo;

import java.util.List;

public interface RouterService {

    List<IpRouterInfo> getAllIpRouterInfo();

    List<TorRouterInfo> getAllTorRouterInfo();
}
