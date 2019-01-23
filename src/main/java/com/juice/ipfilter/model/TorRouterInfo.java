package com.juice.ipfilter.model;

import lombok.Data;

import java.util.Date;

@Data
public class TorRouterInfo {
    private Integer id;
    private String nickname;
    private String fingerPrint;
    private Date firstSeen;
    private String country;
    private Date lastRestarted;
    private String ip;
    private String port;
}
