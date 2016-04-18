<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:authent pageTitle="Utilisateurs">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <h2 class="header center orange-text">Utilisateurs</h2>
        </div>
        <div class="col s12">
          <div class="row">
            <form class="col s6 offset-s3 hoverable" method="post">
              <div class="row">
                <div class="input-field col s6">
                  <i class="material-icons prefix">account_circle</i> <input id="fname" name="fname" type="text" class="validate" required aria-required="true"> <label for="fname">Prénom</label>
                </div>
                <div class="input-field col s6">
                  <input id="lname" name="lname" type="text" class="validate" required aria-required="true"> <label for="lname">Nom</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <i class="material-icons prefix">email</i> <input id="email" name="email" type="email" class="validate" required aria-required="true"> <label for="email">Email</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <i class="material-icons prefix">security</i> <input id="password" name="password" type="password" class="validate" required aria-required="true"> <label for="password">Mot
                    de passe</label>
                </div>
              </div>
              <div class="row">
                <button class="waves-effect waves-light btn" type="submit">Ajouter un utilisateur</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="container main">
    <div class="section">
      <div class="row">
        <div class="col s12">
          <table class="bordered highlight centered responsive-table">
            <thead>
              <tr>
                <th>Id</th>
                <th>Prénom</th>
                <th>Nom</th>
                <th>Email</th>
                <th>Club</th>
                <th>Modifier</th>
                <th>Supprimer</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="user" items="${users}">
                <tr>
                  <td>${user.id}</td>
                  <td>${user.fname}</td>
                  <td>${user.lname}</td>
                  <td>${user.email}</td>
                  <td>
                    <c:choose>
                      <c:when test="user.club == null">Pas de club</c:when>
                      <c:otherwise><a href="${pageContext.request.contextPath}/clubs/modify?id=${user.club.id}">${user.club.name}</a></c:otherwise>
                    </c:choose>
                  </td>
                  <td><a href="${pageContext.request.contextPath}/user?id=${user.id}" class="waves-effect waves-light btn">Modifier</a></td>
                  <td><a href="${pageContext.request.contextPath}/user/delete?id=${user.id}" class="waves-effect waves-light btn">Supprimer</a></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</layout:authent>