<%@ page language="java" contentType="text/html; charset=utf-8"
	import="by.bsuir.hotelReservation.domain.Room" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Hotel</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/sign.css"/>" />
</head>
<body>

	<fmt:setBundle basename="by.resources.pagecontent" scope="session" />
	<div id="main">

		<div id="wrapper">
			<img
				src="${pageContext.request.contextPath}/resources/images/hotels.jpg"
				width="100%" height=250px />
		</div>

		<br /> <br />
		<c:if test="${not empty sessionScope.login}">
			<p class="hello">
				<fmt:message key="label.hello" />
				<c:out value="${sessionScope.login} " />
			</p>
			<br />
			<div id="exit">
				<form action="Controller" method="get">
					<input type="hidden" name="command" value="EXIT" /> <input
						type="submit" value=<fmt:message key="label.exit" /> />
				</form>
			</div>
		</c:if>
		<div id="language">
			<div id="languageRu">
				<form action="Controller" method="get">
					<input type="hidden" name="command" value="LOCALERU" /> <input
						type="submit" value="Русский" />
				</form>
			</div>
			<div id="languageEn">
				<form action="Controller" method="get">
					<input type="hidden" name="command" value="LOCALEEN" /> <input
						type="submit" value="English" />
				</form>
			</div>

		</div>
		<p class="messageInfo">
			<c:if test="${not empty  requestScope.errorMessage }">
				<br />
				<c:out value="${  requestScope.errorMessage }" />
				<br />
			</c:if>
			<c:if test="${not empty  requestScope.messageInfo }">
				<br />
				<c:out value="${  requestScope.messageInfo }" />
				<br />
			</c:if>
		</p>
		<div id="inline">
			<div id="content" class="user-${sessionScope.role}">
				<div id="available">
					<h1>
						<fmt:message key="label.availableRooms" />
					</h1>
				</div>
				<c:forEach var="List" items="${requestScope.List}">

					<div id="information">

						<strong><fmt:message key="label.room" /></strong>
						<c:out value=" ${List.number}" />
						<br /> <strong><fmt:message key="label.type" /></strong>
						<c:out value=" ${List.type}" />
						<br /> <strong><fmt:message key="label.countOfPeople" /></strong>
						<c:out value=" ${List.countOfPeople}" />
						<br /> <br />
						<c:if test="${not empty sessionScope.login}">
							<c:if test="${sessionScope.role=='1' }">
								<form action="Controller" style="float: left" method="get">
									<input type="hidden" name="command" value="DELETE_ROOM" /> <input
										type="hidden" name="id" value="${List.id}" /> <input
										type="submit" value="<fmt:message key="label.deleteRoom" />" />
								</form>
								<c:if test="${!List.isVacant}">
									<form action="Controller" method="get">
										<input type="hidden" name="command" value="FREE_ROOM" /> <input
											type="hidden" name="id" value="${List.id}" /> <input
											type="submit" value="<fmt:message key="label.freeRoom" />" />
									</form>
								</c:if>
							</c:if>
							<c:if test="${List.isVacant}">
								<form action="Controller" method="get">
									<input type="hidden" name="command" value="BOOK_ROOM" /> <input
										type="hidden" name="id" value="${List.id}" /> <input
										type="submit" value="<fmt:message key="label.bookRoom"/>" />
								</form>
							</c:if>
						</c:if>
					</div>

					<br />
				</c:forEach>
			</div>
			<c:if test="${empty sessionScope.login }">
				<div id="enterReg">
					<div class="login">
						<h1>
							<fmt:message key="label.enter" />
						</h1>
						<i class="error"> <c:if
								test="${not empty  requestScope.message }">
								<c:out value="${  requestScope.message}" />
							</c:if>
						</i> <br />
						<form action="Controller" method="post">
							<input type="hidden" name="command" value="AUTHENTICATION" />
							<fmt:message key="label.login" />
							<br /> <input type="text" name="login" value="" /><br />
							<fmt:message key="label.password" />
							<br /> <input type="password" name="password" value="" /> <input
								type="submit" name="commit"
								value="<fmt:message key="label.sign" />" style="float: right">

						</form>

						<form action="Controller" method="get">
							<input type="hidden" name="command"
								value="SHOW_REGISTRATION_FORM" /> <input type="submit"
								value=<fmt:message key="label.registration" /> />

						</form>
					</div>
				</div>
			</c:if>


			<c:if test="${sessionScope.role=='1' }">
				<div id="enterReg">
					<div class="login">
						<h1>
							<fmt:message key="label.addRoom" />
						</h1>
						<br /> <i class="error"> <c:if
								test="${not empty  requestScope.message }">
								<c:out value="${  requestScope.message}" />
							</c:if>
						</i>
						<form action="Controller" method="post">
							<input type="hidden" name="command" value="ADD_NEW_ROOM" />
							<fmt:message key="label.number" />
							<br /> <input type="text" name="number" value="" /><br />
							<fmt:message key="label.type" />
							<br /> <input type="text" name="type" value="" />
							<fmt:message key="label.countOfPeople" />
							<br /> <input type="text" name="countOfPeople" value="" /> <input
								type="hidden" name="command" value="ADD_NEW_ROOM" /> <br /> <input
								type="submit" value="<fmt:message key="label.addRoom" />"
								style="float: right" />
							<div style="clear: both;"></div>
						</form>
					</div>
				</div>
			</c:if>
			<br /> <br />
		</div>
		<div id="footer">
			<fmt:message key="label.footer" />
		</div>
	</div>
</body>
</html>

