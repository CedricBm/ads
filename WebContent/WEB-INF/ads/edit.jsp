<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:landing pageTitle="Edition ad">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <h2 class="header center orange-text">Edition d'une annonce</h2>
        </div>
        <div class="col s12">
          <div class="row">
            <form class="col s6 offset-s3 hoverable" method="post">
            <input id="id" name="id" type="hidden" required aria-required="true" value="${ad.id}">
              <div class="row">
                <div class="input-field col s6">
                  <input id="price" name="price" type="text" class="validate" required aria-required="true" value="${ad.price}"> <label for="price">Prix</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="description" name="description" type="text" class="validate" required aria-required="true" value="${ad.description}"> <label for="description">Description</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="available_at" name="available_at" type="text" class="validate" required aria-required="true" value="${ad.availableAt}"> <label for="available_at">Date où le joueur est disponible (au format jj-mm-aaaa)</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="is_available" name="is_available" type="text" class="validate" required aria-required="true" value="${ad.isAvailable}"> <label for="is_available">Le joueur est encore dispo</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="buyable" name="buyable" type="text" class="validate" required aria-required="true" value="${ad.buyable}"> <label for="buyable">Le joueur est achetable</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="buyer_id" name="buyer_id" type="text" class="validate" required aria-required="true" value="${ad.buyerId}"> <label for="buyer_id">Id de l'acheteur</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="seller_id" name="seller_id" type="text" class="validate" required aria-required="true" value="${ad.sellerId}"> <label for="seller_id">Id du vendeur</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="club_id" name="club_id" type="text" class="validate" required aria-required="true" value="${ad.clubId}"> <label for="club_id">Id du club du joueur</label>
                </div>
              </div>
              <div class="row">
                <button class="waves-effect waves-light btn" type="submit">Modifier une annonce</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</layout:landing>