<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:authent pageTitle="Edition club">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <h2 class="header center orange-text">Edition d'un club</h2>
        </div>
        <c:if test="${!empty error }">
          <p>Erreur détectée lors de votre modification !!</p>
        </c:if>
        <div class="col s12">
          <div class="row">
            <form class="col s6 offset-s3 hoverable" method="post">
              <input id="id" name="id" type="hidden" required aria-required="true" value="${club.id}">
              <div class="row">
                <div class="input-field col s6">
                  <input id="name" name="name" type="text" class="validate" required aria-required="true" value="${club.name}"> <label for="name">Nom</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s6">
                  <input id="country" name="country" type="text" class="validate" required aria-required="true" value="${club.country}"> <label for="country">Pays</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="address" name="address" type="text" class="validate" required aria-required="true" value="${club.address}"> <label for="address">Adresse</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s10">
                  <input id="creationDate" name="creationDate" type="text" class="validate" required aria-required="true" value="${club.creationDate}"> <label for="creationDate">Date de création (au format jj-mm-aaaa)</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="website" name="website" type="text" class="validate" required aria-required="true" value="${club.website}"> <label for="website">Site web</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s6">
                  <input id="nbTrophies" name="nbTrophies" type="text" class="validate" required aria-required="true" value="${club.nbTrophies}"> <label for="nbTrophies">Nombre de trophés</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s6">
                  <input id="managerId" name="managerId" type="text" class="validate" value="${club.manager.id}"> <label for="managerId">Id du responsable</label>
                </div>
              </div>
              <div class="row">
                <button class="waves-effect waves-light btn" type="submit">Modifier un club</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</layout:authent>