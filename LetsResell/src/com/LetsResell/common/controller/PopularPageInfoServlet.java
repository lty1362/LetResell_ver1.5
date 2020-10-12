package com.LetsResell.common.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LetsResell.common.member.vo.PageInfo;
import com.LetsResell.common.model.service.CommonService;
import com.google.gson.Gson;

/**
 * Servlet implementation class PopularPageInfoServlet
 */
@WebServlet("/popularPageInfo.ajax")
public class PopularPageInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopularPageInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int popularCurrentPage = Integer.parseInt(request.getParameter("popularCurrentPage"));
		
		int listCount;		// 현재 총 게시글 갯수
		int currentPage;	// 현재 페이지
		int pageLimit;		// 한 페이지 하단에 보여질 페이지 최대 갯수 (버튼 갯수)
		int boardLimit;		// 한 페이지 내에 보여질 게시글 최대 갯수 (한 번에 볼 게시글 갯수)
		int maxPage;		// 전체 페이지 중 가장 마지막 페이지
		int startPage;		// 페이징 바의 시작 수
		int endPage;		// 페이징 바의 끝 수
		
		// popular Paging
		listCount = new CommonService().selectPopularCount();
		currentPage = popularCurrentPage;
		pageLimit = 4;
		boardLimit = 3;
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (currentPage -1) / pageLimit * pageLimit +1;
		endPage = startPage + pageLimit -1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo popularPi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		Gson gson = new Gson();
		response.setContentType("application/json; charset=utf-8");
		
		gson.toJson(popularPi, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
