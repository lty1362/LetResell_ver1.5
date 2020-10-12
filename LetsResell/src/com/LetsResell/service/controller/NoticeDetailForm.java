package com.LetsResell.service.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LetsResell.service.model.service.NoticeService;
import com.LetsResell.service.model.vo.Notice;

/**
 * Servlet implementation class NoticeDetailForm
 */
@WebServlet("/detail.notice")
public class NoticeDetailForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeDetailForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("nno"));
		Notice detail = new NoticeService().selectDetail(noticeNo);
		request.setAttribute("detail", detail);
		request.getRequestDispatcher("views/service/noticeDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
