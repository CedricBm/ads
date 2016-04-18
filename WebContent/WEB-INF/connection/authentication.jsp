<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:connection pageTitle="Connexion">
  <div class="col s12">
    <h4 class="header center orange-text">Connexion à Javaller</h4>
    <form method="post" class="col s4 offset-s4 hoverable">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">account_circle</i> <input id="email" name="email" type="email" class="validate" required aria-required="true" autofocus> <label for="email">Email</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">security</i> <input id="password" name="password" type="password" class="validate" required aria-required="true"> <label for="password">Mot de passe</label>
        </div>
      </div>
      <div class="row">
        <button class="waves-effect waves-light btn" type="submit">Connexion</button>
      </div>
    </form>
  </div>
</layout:connection>