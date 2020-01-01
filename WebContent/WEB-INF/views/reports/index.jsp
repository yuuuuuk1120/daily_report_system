<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush!=null }">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>日報 一覧</h2>
        <table id="report_list">
            <tbody>
                <tr>
                    <th class="report_name">氏名</th>
                    <th class="report_date">日付</th>
                    <th class="report_title">タイトル</th>
                    <th class="report_action">操作</th>
                    <th class="report_like">皆の反応</th>
                    <th class="report_checkCount">確認者数</th>
                    <th class="report_checkName">確認者名</th>
                </tr>
                <c:forEach var="report" items="${reports }" varStatus="status">
                    <tr class="row${status.count%2 }">
                        <td class="report_name">
                            <c:out value="${report.employee.name }" /></td>
                        <td class="report_date">
                            <fmt:formatDate value='${report.report_date }' pattern='yyyy-MM-dd' /></td>
                        <td class="report_title">${report.title }</td>
                        <td class="report_action">
                            <a href="<c:url value='/reports/show?id=${report.id }'/>"> 詳細を見る</a>
                        </td>
                        <td class="report_like">
                            <form action="<c:url value='/reports/like'/>" method="POST">
                                <input type="hidden" value="${report.id }" name="id">
                                <input type="submit" value="イイネ！">
                                <c:out value="${report.like_value }" />件
                            </form>

                            <form action="<c:url value='/reports/like'/>" method="POST">
                                <input type="hidden" value="${report.id }" name="id2">
                                <input type="submit" value="ヨクナイネ！">
                                <c:out value="${report.like_value }" />件
                            </form>
                        </td>
                        <td class="report_checkCount">
                            <form action="<c:url value='/reports/check'/>" method="POST">
                                <input type="hidden" value="${report.id }" name="id_check">
                                <input type="submit" value="確認"><br/>
                                <c:out value="${report.check_value }"/>人が確認しました。
                            </form>
                         </td>
                         <td class="report_checkName">
                            <form action="<c:url value='/reports/check'/>" method="POST">
                                <input type="hidden"  name="checkName">
                                最後に確認したのは<c:out value="${report.check_name }"/>です。
                            </form>
                          </tr>

                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全${reports_count }件)<br />
            <c:forEach var="i" begin="1" end="${((reports_count-1)/15)+1 }"
                step="1">
                <c:choose>
                    <c:when test="${i==page }">
                        <c:out value="${i }" />&nbsp;
                      </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/reports/index?page=${i }'/>"><c:out
                                value="${i }" /></a>&nbsp;
                          </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p>
            <a href="<c:url value='/reports/new'/>">新規日報の登録</a>
        </p>
    </c:param>
</c:import>