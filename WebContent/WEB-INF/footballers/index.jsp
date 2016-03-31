<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:landing pageTitle="Footballers">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <h2 class="header center orange-text">Footballers</h2>
        </div>
        <div class="col s12">
          <div class="row">
            <form class="col s6 offset-s3 hoverable" method="post">
              <div class="row">
                <div class="input-field col s6">
                  <input id="fname" name="fname" type="text" class="validate" required aria-required="true"> <label for="fname">Prénom</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="lname" name="lname" type="text" class="validate" required aria-required="true"> <label for="lname">Nom</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="position" name="position" type="text" class="validate" required aria-required="true"> <label for="position">Position</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="nationality" name="nationality" type="text" class="validate" required aria-required="true"> <label for="nationality">Nationalité</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="size" name="size" type="text" class="validate" required aria-required="true"> <label for="size">Taille</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="weigh" name="weigh" type="text" class="validate" required aria-required="true"> <label for="weigh">Poids</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="nb_goals" name="nb_goals" type="text" class="validate" required aria-required="true"> <label for="nb_goals">Nombre de buts</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="nb_games" name="nb_games" type="text" class="validate" required aria-required="true"> <label for="nb_games">Nombre de matchs joués</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="birthdate" name="birthdate" type="text" class="validate" required aria-required="true"> <label for="birthdate">Date de naissance (format: jj-mm-aaaa )</label>
                </div>
              </div>                                          
              <div class="row">
                <div class="input-field col s12">
                  <input id="nb_games_international" name="nb_games_international" type="text" class="validate" required aria-required="true"> <label for="nb_games_international">Nombre de matchs joués avec son équipe nationale</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="strong_foot" name="strong_foot" type="text" class="validate" required aria-required="true"> <label for="strong_foot">Son pied le plus fort</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input id="club_id" name="club_id" type="text" class="validate" required aria-required="true"> <label for="club_id">Id du club</label>
                </div>
              </div>
              <div class="row">
                <button class="waves-effect waves-light btn" type="submit">Ajouter un joueur</button>
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
                <th>Prénom</th>
                <th>Nom</th>
                <th>Position</th>
                <th>Nationalité</th>
                <th>Taille</th>
                <th>Poids</th>
                <th>Nombre buts</th>
                <th>Nombre match</th>
                <th>Date naissance</th>
                <th>Nombre match international</th>
                <th>Pied fort</th>
                <th>Club</th>
                <th>Modifier</th>
                <th>Supprimer</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="footballer" items="${footballers}">
                <tr>
                  <td>${footballer.id}</td>
                  <td>${footballer.fname}</td>
                  <td>${footballer.lname}</td>
                  <td>${footballer.position}</td>
                  <td>${footballer.nationality}</td>
                  <td>${footballer.size}</td>
                  <td>${footballer.weigh}</td>
                  <td>${footballer.nbGoals}</td>
                  <td>${footballer.nbGames}</td>
                  <td>${footballer.birthdate}</td>
                  <td>${footballer.nbGamesInternational}</td>
                  <td>${footballer.strongFoot}</td>
                  <td>${footballer.clubId}</td>
                  <td><a href="${pageContext.request.contextPath}/footballers/modify?id=${footballer.id}" class="waves-effect waves-light btn">Modifier</a></td>
                  <td><a href="${pageContext.request.contextPath}/footballers/delete?id=${footballer.id}" class="waves-effect waves-light btn">Supprimer</a></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</layout:landing>