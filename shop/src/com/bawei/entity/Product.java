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
//��Ʒʵ����
public class Product {
	private String pid;			//��ƷID
	private String pname;		//��Ʒ����
	private double marketPrice;	//�г���
	private double shopPrice;	//�̳Ǽ�
	private String pimage;		//��Ʒ��ͼƬ·��
	private Date pdate;			//��Ʒ�Ĵ���ʱ��
	private int isHot;			//�Ƿ���������Ʒ��1�ǣ�0��
	private String pdesc;		//��Ʒ����
	private int pflag;			//��Ʒ״̬��0�����ۣ�1���¼ܣ�
	private String cid;			//��Ʒ�����ID��Ӧ����Category��Ķ�����ʱʹ��
	
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
