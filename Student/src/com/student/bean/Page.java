package com.student.bean;

public class Page {
	//当前页，实时变动的，需要从jsp页面中实时获取
	private int nowPageNo;
	//总页数，根据数据库查询到的总记录数来计算得到的
	private int totalPages;
	//数据表总记录数，通过查询数据库得到的
	private int studentTableNum;
	//每页显示多少条数据，自己定义
	private int pageSize = 5;
	//下一页，通过当前页计算得到的
	private int nextPage;
	//上一页，通过当前页计算得到的
	private int prefPage;




	/**
	 *
	 * @return
	 */
	public int getNowPageNo() {
		    //如果当前页为负数了，使它限定当前的页码，设定最小为1，不会为负数
		if(nowPageNo < 0) {
			nowPageNo = 1;
			//限定当前页的页码，最大为计算好的总页数，不会超出分页范围
		}else if(nowPageNo > totalPages){
			nowPageNo = totalPages;
		}

		return nowPageNo;
	}

	/**
	 *
	 * @param nowPageNo
	 */
	public void setNowPageNo(int nowPageNo) {
		this.nowPageNo = nowPageNo;
	}
	public int getTotalPages() {
		    //如果数据库总条数能被整除
		if(studentTableNum % pageSize ==0) {
			//总页数就为，数据库总条数 除以 每页显示记录数
			totalPages = studentTableNum /pageSize;
		}else {
			//否则，就在相除得到的结果上加1，从而让所有数据都能被分页显示
			totalPages = studentTableNum /pageSize + 1;
		}

		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getStudentTableNum() {
		return studentTableNum;
	}
	public void setStudentTableNum(int studentTableNum) {
		this.studentTableNum = studentTableNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 *
	 * @return NextPage
	 */
	public int getNextPage() {
		//如果当前页小于总页数时
		if(nowPageNo < totalPages) {
		//便会有下一页，下一页的页码就是当前页+1，
			nextPage = nowPageNo +1;
		}else {
			//反之，当前页等于总页数的时候，表明已经是最后一页了，所以下一页的页码，便一直是最后一页
			nextPage = nowPageNo;
		}
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPrefPage() {
		//如果当前页大于1时，即当前页不是第一页
		if(nowPageNo > 1) {
			//便会有上一页，上一页的页码就是当前页-1
			prefPage = nowPageNo-1;

		}else {
			//反之，当前页等于1的时候，表明已经是第一页了，所以上一页的页码，便一直是1，即首页；
			prefPage = nowPageNo;
		}

		return prefPage;
	}
	public void setPrefPage(int prefPage) {
		this.prefPage = prefPage;
	}



}
