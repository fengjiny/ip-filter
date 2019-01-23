package com.juice.ipfilter.dao;

import com.juice.ipfilter.model.TorRouterInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TorRouterInfoDao {
    List<TorRouterInfo> getAllTorInfo();
}
