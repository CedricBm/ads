<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:landing pageTitle="Ads">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <h2 class="header center orange-text">Annonces</h2>
        </div>
        <c:if test="${!empty error }">
          <p>Erreur détectée lors de votre création !!</p>
        </c:if>
        <div class="col s12">
          <div class="row">
            <form class="col s6 offset-s3 hoverable" method="post">
              <div class="row">
                <div class="input-field col s6">
                  <input id="title" name="title" type="text" class="validate" required aria-required="true"> <label for="title">Titre</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s6">
                  <input id="price" name="price" type="text" class="validate" required aria-required="true"> <label for="price">Prix</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="description" name="description" type="text" class="validate" required aria-required="true"> <label for="description">Description</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="buyable" name="buyable" type="text" class="validate" required aria-required="true"> <label for="buyable">Vendre joueur(1) ou louer (0)</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="available_at" name="available_at" type="text" class="validate" required aria-required="true"> <label for="available_at">Date où le joueur est disponible
                    (au format jj-mm-aaaa)</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="seller_id" name="seller_id" type="text" class="validate" required aria-required="true"> <label for="seller_id">Id du vendeur</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="footballer_id" name="footballer_id" type="text" class="validate" required aria-required="true"> <label for="footballer_id">Id du joueur</label>
                </div>
              </div>
              <div class="row">
                <button class="waves-effect waves-light btn" type="submit">Ajouter une annonce</button>
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
                <th>Titre</th>
                <th>Prix</th>
                <th>Description</th>
                <th>Achetable</th>
                <th>Date dispo</th>
                <th>Est Dispo</th>
                <th>Id Acheteur</th>
                <th>Id Vendeur</th>
                <th>Id Joueur</th>
                <th>Modifier</th>
                <th>Supprimer</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="ad" items="${ads}">
                <tr>
                  <td>${ad.id}</td>
                  <td>${ad.title}</td>
                  <td>${ad.price}</td>
                  <td>${ad.description}</td>
                  <td>${ad.buyable}</td>
                  <td>${ad.availableAt}</td>
                  <td>${ad.available}</td>
                  <td>${ad.buyerId}</td>
                  <td>${ad.sellerId}</td>
                  <td>${ad.footballerId}</td>
                  <td><a href="${pageContext.request.contextPath}/ads/modify?id=${ad.id}" class="waves-effect waves-light btn">Modifier</a></td>
                  <td><a href="${pageContext.request.contextPath}/ads/delete?id=${ad.id}" class="waves-effect waves-light btn">Supprimer</a></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</layout:landing>