package com.aquicksoftEventPublisher.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Stats implements Serializable {
private String action;
private String txId;
}
