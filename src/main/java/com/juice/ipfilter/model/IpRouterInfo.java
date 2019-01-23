package com.juice.ipfilter.model;

import lombok.Data;

import java.util.Date;

@Data
public class IpRouterInfo {
    private Integer id;
    private String hash;
    private String ip;
    private Integer isFloodFill;
    private Integer knownLeaseSets;
    private Integer knownRouters;
    private String routerVersion;
    private String caps;
    private String country;
    private Date createTime;
    private String port;
}
