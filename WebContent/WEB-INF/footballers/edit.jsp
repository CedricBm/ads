<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
    
<layout:landing pageTitle="Edition footballer">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <h2 class="header center orange-text">Edition d'un footballer</h2>
        </div>
        <c:if test="${!empty error }">
          <p>Erreur détectée lors de votre modification !!</p>
        </c:if>
        <div class="col s12">
          <div class="row">
            <form class="col s6 offset-s3 hoverable" method="post">
              <input id="id" name="id" type="hidden" required aria-required="true" value="${footballer.id}">
              <div class="row">
                <div class="input-field col s6">
                  <input id="fname" name="fname" type="text" class="validate" required aria-required="true" value="${footballer.fname}"> <label for="fname">Prénom</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="lname" name="lname" type="text" class="validate" required aria-required="true" value="${footballer.lname}"> <label for="lname">Nom</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="position" name="position" type="text" class="validate" required aria-required="true" value="${footballer.position}"> <label for="position">Position</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="nationality" name="nationality" type="text" class="validate" required aria-required="true" value="${footballer.nationality}"> <label for="nationality">Nationalité</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="size" name="size" type="text" class="validate" required aria-required="true" value="${footballer.size}"> <label for="size">Taille</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="weigh" name="weigh" type="text" class="validate" required aria-required="true" value="${footballer.weigh}"> <label for="weigh">Poids</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="nb_goals" name="nb_goals" type="text" class="validate" required aria-required="true" value="${footballer.nb_goals}"> <label for="nb_goals">Nombre de buts</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="nb_games" name="nb_games" type="text" class="validate" required aria-required="true" value="${footballer.nb_games}"> <label for="nb_games">Nombre de matchs joués</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="birthdate" name="birthdate" type="text" class="validate" required aria-required="true" value="${footballer.birthdate}"> <label for="birthdate">Date de naissance (format: jj-mm-aaaa )</label>
                </div>
              </div>                                          
              <div class="row">
                <div class="input-field col s12">
                  <input id="nb_games_international" name="nb_games_international" type="text" class="validate" required aria-required="true" value="${footballer.nb_games_international}"> <label for="nb_games_international">Nombre de matchs joués avec son équipe nationale</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="strong_foot" name="strong_foot" type="text" class="validate" required aria-required="true" value="${footballer.strong_foot}"> <label for="strong_foot">Son pied le plus fort</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="club_id" name="club_id" type="text" class="validate" required aria-required="true" value="${footballer.club_id}"> <label for="club_id">Id du club</label>
                </div>
              </div>
              <div class="row">
                <button class="waves-effect waves-light btn" type="submit">Modifier un footballer</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</layout:landing>  