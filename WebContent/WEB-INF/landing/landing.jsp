<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:landing pageTitle="Accueil">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12 m8">
          <h2 class="header center orange-text">Javaller</h2>
          <div class="row center">
            <h5 class="header col s12 light">Le site d'annonces de ventes et locations de footballers.</h5>
            <img class="cover" src="<c:url value="/img/messi-vs-ronaldo.jpg" />" />
          </div>
        </div>
        <div class="col s12 m4">
          <div class="row">
            <form class="col s12 hoverable" method="post" action="signup">
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
                <button class="waves-effect waves-light btn" type="submit">Je m'inscris!</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="container main">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-blue-text">
              <i class="material-icons">flash_on</i>
            </h2>
            <h5 class="center">Une inscription éclair</h5>

            <p class="light">Inscrivez-vous pour voir toutes les annonces de footballers.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-blue-text">
              <i class="material-icons">group</i>
            </h2>
            <h5 class="center">Une communauté de footballers</h5>

            <p class="light">Les meilleurs footballers sont présents pour vous fournir les services.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-blue-text">
              <i class="material-icons">settings</i>
            </h2>
            <h5 class="center">Un processus d'achat et de location simplifié</h5>

            <p class="light">Plus aucune prise de tête, tous les meilleurs footballers sont présents sur Javaller</p>
          </div>
        </div>
      </div>

    </div>
  </div>
</layout:landing>