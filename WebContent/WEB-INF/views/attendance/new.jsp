<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>勤怠 新規登録ページ</h2>

        <form method="POST" action="<c:url value='/attendance/create'/>">
            ＊日付
            <input type="date" name="date" pattern='yyyy-MM-dd'>
            ＊出勤時間（30分単位）
            <input type="time" name="startTime" step="1800">
            ＊退勤時間（30分単位)
            <input type="time" name="finishTime" step="1800">
            <button type="submit">投稿</button>

        </form>

        <p>
            <a href="<c:url value='/attendance/index'/>">勤怠一覧に戻る</a>
        </p>
    </c:param>
</c:import>