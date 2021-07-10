package com.aquicksoftEventPublisher.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Order implements Serializable {
	public String txId;
	public String userId;
	public String hbKey;
}
