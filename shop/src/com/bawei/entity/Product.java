package com.bawei.entity;

import java.util.Date;

/*
 * CREATE TABLE `tb_product` (
  `pid` varchar(32) PRIMARY KEY,
  `pname` varchar(50) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `shop_price` double DEFAULT NULL,
  `pimage` varchar(200) DEFAULT NULL, 
  `pdate` timestamp,
  `is_hot` int(1) DEFAULT NULL,
  `pdesc` varchar(255) DEFAULT NULL,
  `pflag` int(1) DEFAULT NULL,
  `cid` varchar(32) DEFAULT NULL
);
 */
//商品实体类
public class Product {
	private String pid;			//商品ID
	private String pname;		//商品名称
	private double marketPrice;	//市场价
	private double shopPrice;	//商城价
	private String pimage;		//商品的图片路径
	private Date pdate;			//商品的创建时间
	private int isHot;			//是否是热门商品（1是，0否）
	private String pdesc;		//商品描述
	private int pflag;			//商品状态（0是在售，1是下架）
	private String cid;			//商品分类的ID，应该是Category类的对象，临时使用
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public double getShopPrice() {
		return shopPrice;
	}
	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getIsHot() {
		return isHot;
	}
	public void setIsHot(int isHot) {
		this.isHot = isHot;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public int getPflag() {
		return pflag;
	}
	public void setPflag(int pflag) {
		this.pflag = pflag;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", marketPrice=" + marketPrice + ", shopPrice=" + shopPrice
				+ ", pimage=" + pimage + ", pdate=" + pdate + ", isHot=" + isHot + ", pdesc=" + pdesc + ", pflag="
				+ pflag + ", cid=" + cid + "]";
	}
}
