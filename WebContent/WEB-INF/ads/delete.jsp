<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:landing pageTitle="Suppression ad">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <h2 class="header center orange-text">Voulez-vous vraiment supprimer ${ad.description} ?</h2>
        </div>
        <div class="col s12">
          <div class="row">
            <form class="col s6 offset-s3" method="post">
              <input id="id" name="id" type="hidden" required aria-required="true" value="${ad.id}">
              <div class="row">
                <button class="waves-effect waves-light btn" type="submit">Supprimer</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</layout:landing>