<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fiche Matière</title>
</head>
<body>



<div id="content">

  <h3>Modifier Matière ${matiere.id}</h3>
  <form action="matiere" method="post">
  <input type="hidden" name="id" value="${matiere.id}">
  Libellé :<input value="${matiere.libelle}" name="libelle" type="text" placeholder="Saisir le libellé"><br>
  Code Quest :<input value="${matiere.quest}" name="quest" type="text" placeholder="Saisir le code Quest"><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="stagiaire"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>