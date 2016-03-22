# ads

Projet de persistance objet

## Installation
- Télécharger et installer [Glassfish 4.1.1](https://glassfish.java.net/download.html).
- Télécharger et installer [PostgreSQL](http://www.postgresql.org/download/).
- Créer la base de données "ads" et exécuter le script sql "tables.sql" pour créer les différentes tables.
- Création de la datasource dans Glassfish:
  - [Télécharger](https://jdbc.postgresql.org/) et mettre le driver JDBC de postgres dans le dossier lib de Glassfish
  - Lancer le serveur Glassfish
  - Lancer la console Glassfish "asadmin" qui se trouve dans le dossier de Glassfish
  - Exécuter les commandes suivantes en adaptant:
    - create-jdbc-connection-pool --restype javax.sql.DataSource --datasourceclassname org.postgresql.ds.PGSimpleDataSource --property "user=postgres:password=postgres:url=jdbc\\:postgresql\\://localhost\\:5432/ads" ads-pool
    - ping-connection-pool ads-pool
    - create-jdbc-resource --connectionpoolid ads-pool jdbc/ads
- Télécharger et installer Eclipse, et ajouter le serveur Glassfish. Ajouter le projet ads au serveur Glassfish.
