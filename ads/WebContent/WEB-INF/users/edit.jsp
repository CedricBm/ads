<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:landing pageTitle="Edition utilisateur">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <h2 class="header center orange-text">Edition d'un utilisateur</h2>
        </div>
        <div class="col s12">
          <div class="row">
            <form class="col s6 offset-s3 hoverable" method="post">
              <input id="id" name="id" type="hidden" required aria-required="true" value="${user.id}">
              <div class="row">
                <div class="input-field col s6">
                  <i class="material-icons prefix">account_circle</i> <input id="fname" name="fname" type="text" class="validate" required aria-required="true" value="${user.fname}"> <label for="fname">Prénom</label>
                </div>
                <div class="input-field col s6">
                  <input id="lname" name="lname" type="text" class="validate" required aria-required="true" value="${user.lname}"> <label for="lname">Nom</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <i class="material-icons prefix">email</i> <input id="email" name="email" type="email" class="validate" required aria-required="true" value="${user.email}"> <label for="email">Email</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <i class="material-icons prefix">security</i> <input id="password" name="password" type="password" class="validate"> <label for="password">Mot de passe</label>
                </div>
              </div>
              <div class="row">
                <button class="waves-effect waves-light btn" type="submit">Modifier</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</layout:landing>