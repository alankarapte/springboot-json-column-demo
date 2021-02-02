package com.alankar.springbootjsoncolumnexample.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class Address implements Serializable{
	private String city;
	private String landmark;
	private String pincode;
}
