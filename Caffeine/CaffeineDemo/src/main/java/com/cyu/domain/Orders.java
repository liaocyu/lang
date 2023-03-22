package com.cyu.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName orders
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 价格
     */
    private Double money;

    private static final long serialVersionUID = 1L;
}