package com.rj.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rj.dao.IDetailsDao;
import com.rj.entity.SetAndImpClass;
import com.rj.servlet.DetailsmanagementService;
import com.rj.servlet.IDetaildService;

@WebServlet("/Controler")
public class MainControlerServlet extends HttpServlet
{
	private IDetaildService  service;
	
	@Override
	public void init() throws ServletException
	{
	   service=new DetailsmanagementService();
	}
	
	//Configure The Do_Get Method
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
	   //Read The Special Req The Value Are Come And Which Place That Are Store  The Value That Will Check
	    //That Are Gose The Browse Or Hyperlink That Are All Devloped By Porgrammer At Manually
	   String s1=req.getParameter("s1");
	   int PageNo=0,PageSize=0;
	   HttpSession sec=req.getSession();
	   if(s1.equalsIgnoreCase("Get Report"))
	   {
		   PageSize=Integer.parseInt(req.getParameter("PageSize"));
		   PageNo=0;
		   sec.setAttribute("PageSize",PageSize);
	   }
		else //Use The Hyperlink
		{
		   PageNo=Integer.parseInt(req.getParameter("PageNo"));
		   PageSize=(int) sec.getAttribute("PageSize");
		}
	   //Use The Service
	   int PageCount=service.getPagessCount(PageSize);
	   List<SetAndImpClass> list=service.GetReportPageData(PageNo, PageSize);
	   //Keep The Result In The Request Scope
	   req.setAttribute("PageData", list);
	   req.setAttribute("PageCount", PageCount);
	   //Forward The Jsp Page
	   RequestDispatcher rd=req.getRequestDispatcher("/show_report.jsp");
	   rd.forward(req, res);
	}
   
 //Configure The Do_Post Method
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		//Add The Do-Get Method Some Not Come Error Propouse
		doGet(req, res);
	}

}
