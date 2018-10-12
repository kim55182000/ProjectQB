<%-- 
	@JSP:adminClassSidebar.jsp
	@DATE:2018-10-08
	@Author:김현이
	@Desc:관리자 클래스 상세보기 사이드바(스토리보드 8 of 41)
		  url 매핑 미완성
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--sidebar start  -->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          
          <!-- 강사  -->
          <li class="sub-menu">
            <a href="#">
              <span>관리자 클래스상세보기 </span>
             </a>
          </li>
          <li class="sub-menu">
            <a href="${pageContext.request.contextPath}/admin/adminClassMain.do">
              <i class="fa fa-desktop"></i>
              <span>공지사항 & 시험일정</span>
              </a>
          </li>
          <li class="sub-menu">
            <a href="${pageContext.request.contextPath}/admin/studentInfo.do">
              <i class="fa fa-desktop"></i>
              <span>학생 & 성적관리</span>
              </a>
          </li>
          <li class="sub-menu">
            <a href="${pageContext.request.contextPath}/admin/questionManagement.do">
              <i class="fa fa-desktop"></i>
              <span>문제 관리</span>
              </a>
          </li>
          <li class="sub-menu">
            <a href="${pageContext.request.contextPath}/admin/examManagement.do">
              <i class="fa fa-desktop"></i>
              <span>시험 관리</span>
              </a>
          </li>
	          <li class="sub-menu">
	            <a href="${pageContext.request.contextPath}/admin/adminMain.do">
	              <i class="fa fa-desktop"></i>
	              <span>클래스 전체 관리</span>
	             </a>
	          </li> 
          <!-- 강사 end -->
         </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
<!--sidebar end-->