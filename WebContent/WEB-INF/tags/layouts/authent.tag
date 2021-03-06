<%@ tag body-content="scriptless"%>
<%@ attribute name="pageTitle" required="true" type="java.lang.String"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${pageTitle} - Javaller</title>

<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet" type="text/css" href="<c:url value="/css/materialize.min.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css" />" />

</head>
<body>
  <nav class="light-blue lighten-1" role="navigation">
    <div class="nav-wrapper container">
      <a id="logo-container" href="${pageContext.request.contextPath}" class="brand-logo valign-wrapper"><img src="<c:url value="/img/logo.png" />" /></a>
      <ul class="right hide-on-med-and-down">
        <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/users">Utilisateurs</a></li>
        <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/clubs">Clubs</a></li>
        <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/footballers">Footballers</a></li>
        <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/ads">Ads</a></li>
        <li><a class="waves-effect waves-light" href="${pageContext.request.contextPath}/logout">D�connexion</a></li>
      </ul>
    </div>
  </nav>

  <jsp:include page="/WEB-INF/inc/flash.jsp" />
  <jsp:doBody />

  <footer class="page-footer orange">
    <div class="footer-copyright">
      <div class="container center-align">Javaller - �2016 - Tous droits r�serv�s</div>
    </div>
  </footer>

  <script src="<c:url value="/js/jquery-2.2.1.min.js" />"></script>
  <script src="<c:url value="/js/materialize.min.js" />"></script>
  <script src="<c:url value="/js/main.js" />"></script>
</body>
</html>