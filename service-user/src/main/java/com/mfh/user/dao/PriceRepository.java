package com.mfh.user.dao;

import com.mfh.user.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author :mfh
 * @Date :Created in 12:02 2019/1/11
 * @Description :单价
 * @Version :V1.0
 */
public interface PriceRepository extends JpaRepository<Price,Integer> {
}
