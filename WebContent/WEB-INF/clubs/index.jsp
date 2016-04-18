<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:authent pageTitle="Clubs">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <h2 class="header center orange-text">Clubs</h2>
        </div>
        <c:if test="${!empty error }">
          <p>Erreur détectée lors de votre création !!</p>
        </c:if>
        <div class="col s12">
          <div class="row">
            <form class="col s6 offset-s3 hoverable" method="post">
              <div class="row">
                <div class="input-field col s6">
                  <input id="name" name="name" type="text" class="validate" required aria-required="true"> <label for="title">Nom</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s6">
                  <input id="country" name="country" type="text" class="validate" required aria-required="true"> <label for="price">Pays</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="address" name="address" type="text" class="validate" required aria-required="true"> <label for="address">Adresse</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s10">
                  <input id="creationDate" name="creationDate" type="text" class="validate" required aria-required="true" > <label for="creationDate">Date de création (au format jj-mm-aaaa)</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                	<input id="website" name="website" type="text" class="validate" required aria-required="true"> <label for="website">Site web</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s6">
                  <input id="nbTrophies" name="nbTrophies" type="text" class="validate" required aria-required="true"> <label for="nbTrophies">Nombre de trophés</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s6">
                  <input id="managerId" name="managerId" type="text" class="validate"> <label for="managerId">Id du responsable</label>
                </div>
              </div>
              <div class="row">
                <button class="waves-effect waves-light btn" type="submit">Ajouter un club</button>
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
                <th>Nom</th>
                <th>Pays</th>
                <th>Adresse</th>
                <th>Date de création</th>
                <th>Site Web</th>
                <th>Nombre de trophés</th>
                <th>Id du responsable</th>
                <th>Modifier</th>
                <th>Supprimer</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="club" items="${clubs}">
                <tr>
                  <td>${club.id}</td>
                  <td>${club.name}</td>
                  <td>${club.country}</td>
                  <td>${club.address}</td>
                  <td>${club.creationDate}</td>
                  <td>${club.website}</td>
                  <td>${club.nbTrophies}</td>
                  <td>${club.manager.id}</td>
                  <td><a href="${pageContext.request.contextPath}/clubs/modify?id=${club.id}" class="waves-effect waves-light btn">Modifier</a></td>
                  <td><a href="${pageContext.request.contextPath}/clubs/delete?id=${club.id}" class="waves-effect waves-light btn">Supprimer</a></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</layout:authent>