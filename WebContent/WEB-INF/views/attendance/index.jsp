<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/app.jsp">
     <c:param name="content">
        <h2>勤怠管理表</h2>
            <table id="attendanceManagement_list">
                 <tbody>
                     <tr>
                       <th class="day_time">日付</th>
                       <th class="start_time">出勤時間</th>
                       <th class="finish_time">退勤時間</th>
                    </tr>
                        <c:forEach var="attendanceManagement" items="${attendanceManagements}" varStatus="status">
                            <tr class="row${status.count % 2}">
                                <td class="day_time">
                                    <fmt:formatDate value="${attendanceManagement.day_time}" pattern='yyyy-MM-dd'/></td>
                                <td class="start_time">
                                    <fmt:formatDate value="${attendanceManagement.start_from}" pattern='HH:mm'/></td>
                                <td class="finish_at">
                                    <fmt:formatDate value="${attendanceManagement.finish_at}" pattern='HH:mm'/></td>
                            </tr>
                        </c:forEach>
                  </tbody>
             </table>
          <p><a href="<c:url value='/attendance/new'/>">新規勤怠の登録</a></p>
        </c:param>
</c:import>