package com.juice.ipfilter.dao;

import com.juice.ipfilter.model.IpRouterInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IpRouterInfoDao {
    List<IpRouterInfo> getAllIpInfo();
}
