package com.my.common.page;

/**
 * 分页基本实现
 * 
 */
public class Page {

	/** 页码 */
	protected int pageNo;
	/** 每页记录条数 */
	protected int pageCount;
	/** 总页数 */
	protected int totalPage;
	/** 总记录条数 */
	protected int totalCount = -1;

	/** 开始 */
	protected int pageBegin;

	/** 是否是最后一页 */
	protected int islastPage;  //0、否  1、是

	public Page() {
	}

	public Page(int pageNo, int pageCount) {
		if (pageNo <= 0) {
			throw new IllegalArgumentException("pageNo must be greater than 0.");
		}
		if (pageCount <= 0) {
			throw new IllegalArgumentException("pageCount must be greater than 0.");
		}
		this.pageNo = pageNo;
		this.pageCount = pageCount;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if (totalCount < 0) { // 如果总数为负数, 表未设置
			totalPage = 0;
		} else { // 计算总页数
			totalPage = (totalCount / pageCount) + (totalCount % pageCount == 0 ? 0 : 1);
			if(totalPage==pageNo||totalPage==0||totalPage<pageNo){
				islastPage=1;
			}else{
				islastPage=0;
			}
		}
	}


	public int getIslastPage() {
		return islastPage;
	}
	public void setIslastPage(int islastPage) {
			this.islastPage = islastPage;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}



	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageCount=" + pageCount + ", totalPage=" + totalPage + ", totalCount="
				+ totalCount + ", islastPage=" + islastPage + "]";
	}

	
}
