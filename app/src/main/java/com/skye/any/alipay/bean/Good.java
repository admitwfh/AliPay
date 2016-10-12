package com.skye.any.alipay.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2016/10/12.
 */
@Entity
public class Good {
   @Id(autoincrement = true)
    private Long id;
    private String name;
    private int price;
    private int number;
   private int goodId;

   public Good(String name, int price, int number,int goodId){
      this.name = name;
      this.price = price;
      this.number = number;
      this.goodId = goodId;
   }

   @Generated(hash = 2023362924)
   public Good(Long id, String name, int price, int number, int goodId) {
      this.id = id;
      this.name = name;
      this.price = price;
      this.number = number;
      this.goodId = goodId;
   }

   @Generated(hash = 2016981037)
   public Good() {
   }

   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getPrice() {
      return this.price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public int getNumber() {
      return this.number;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   public int getGoodId() {
      return this.goodId;
   }

   public void setGoodId(int goodId) {
      this.goodId = goodId;
   }









  
}
