
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
		<div class="home">
			<form action="Controller" method="get">
				<input type="hidden" name="command" value="VIEW_ALL_ROOMS" /> <input
					type="submit" value=<fmt:message key="label.home" /> />
			</form>
		</div>
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

		<div id="inline">
			<c:if test="${empty sessionScope.login }">
				<div id="enterReg">
					<div class="login" style="margin-right: 455px">
						<h1>
							<fmt:message key="label.newUser" />
						</h1>
						<i class="error"> <c:if
								test="${not empty  requestScope.errorMessage }">
								<c:out value="${ requestScope.errorMessage}" />
							</c:if>
						</i> <br />
						<form action="Controller" method="post">
							<input type="hidden" name="command" value="REGISTRATION" />
							<fmt:message key="label.login" />
							<br /> <input type="text" name="login" value="" /><br />
							<fmt:message key="label.password" />
							<br /> <input type="password" name="password" value="" /> <input
								type="submit" name="commit"
								value="<fmt:message key="label.register" />"
								style="float: right">
							<div style="clear: both;"></div>
						</form>
					</div>
				</div>
			</c:if>

			<br /> <br />
		</div>
		<div id="footer" style="margin-top: 197px">
			<fmt:message key="label.footer" />
		</div>
	</div>
</body>
</html>

