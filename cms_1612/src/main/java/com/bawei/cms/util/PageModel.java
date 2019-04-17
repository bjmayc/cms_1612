
package com.bawei.cms.util;

/**
 * @author myc
 */

public class PageModel {
  //当前页
  private int currentPage;

  //上一页
  private int prevPage;

  //下一页
  private int nextPage;

  //尾页
  private int lastPage;

  //数据总条数
  private int count;

  //每页显示的数量
  private int pageSize;

  //分页计入数
  private int pageRecord;//起始的索引

  //分页  
  private String page;

  public int getCurrentPage() {
    return currentPage;
  }

  public int getPrevPage() {
    return prevPage;
  }

  public int getNextPage() {
    return nextPage;
  }

  public int getLastPage() {
    return lastPage;
  }

  public int getCount() {
    return count;
  }

  public int getPageSize() {
    return pageSize;
  }

  public int getPageRecord() {
    return pageRecord;
  }

  public String getPage() {
    return page;
  }
  
  
  public PageModel() {
  }

  //有参构造
  //  currentPage:当前页号    
  //count  总条数
  //pageSize: 每页大小 
  public PageModel(String currentPage, int count, int pageSize) {
    init(currentPage, count, pageSize);
    initPrevPage();
    initLastPage();
    initNextPage();
    initPageRecord();
    initPage();
  }

  //初始化变量的值ֵ
  private void init(String currentPage, int count, int pageSize) {
    if (currentPage == null || currentPage.equals("")) {
      currentPage = "1";
    }
    this.currentPage = Integer.parseInt(currentPage);
    this.count = count;
    this.pageSize = pageSize;
  }

  //实现上一页
  private void initPrevPage() {
    if (currentPage == 1) {
      prevPage = 1;
    } else {
      prevPage = currentPage - 1;
    }
  }

  //实现最后一页
  private void initLastPage() {
    if (count % pageSize == 0) {
      lastPage = count / pageSize;
    } else {
      lastPage = count / pageSize + 1;
    }
  }

  //实现下一页
  private void initNextPage() {
    if (currentPage == lastPage) {
      nextPage = lastPage;
    } else {
      nextPage = currentPage + 1;
    }
  }

  //实现分页数
  private void initPageRecord() {
    pageRecord = (currentPage - 1) * pageSize;
  }

  private void initPage() {
    page = "第" + currentPage + "/" + lastPage + "页，共" + count + "条数据    ";
    page += "<button   onclick='page(1)' class='btn btn-default'>首页</button>";
    page += "<button  onclick='page(" + prevPage + ")' class='btn btn-default'>上一页</button>";
    page += "<button onclick='page(" + nextPage + ")'  class='btn btn-default'>下一页</button>";
    page += "<button onclick='page(" + lastPage + ")'  class='btn btn-default'>尾页</button>";
  }

}
