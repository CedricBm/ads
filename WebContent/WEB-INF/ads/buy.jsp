<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:authent pageTitle="Acheter ad">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <h2 class="header center orange-text">Voulez-vous vraiment acheter ${ad.footballer.lname} ?</h2>
        </div>
        <div class="col s12">
          <div class="row">
            <form class="col s6 offset-s3" method="post">
              <input id="id" name="id" type="hidden" required aria-required="true" value="${ad.id}">
              <input id="buyer_id" name="buyer_id" type="hidden" required aria-required="true" value="${user.id}">
              <input id="footballer_id" name="footballer_id" type="hidden" required aria-required="true" value="${ad.footballer.id}">
              <div class="row">
                <button class="waves-effect waves-light btn" type="submit">Acheter</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</layout:authent>