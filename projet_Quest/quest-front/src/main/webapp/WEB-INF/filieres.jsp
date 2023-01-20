<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">


<div id="content">
<h1>Liste des Filieres</h1>
     <input id="btnAddFiliere" type="button" class ="btn btn-success" value="Ajouter">
     <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

     <table class="table table-striped">
       <thead>
         <tr>
           <th>Id</th>
           <th>Libelle</th>
           <th>Debut</th>
           <th>Fin</th>
           </tr>
       </thead>
       <tbody>
       <c:forEach items="${filieres}" var="filiere">
         <tr>
           <td>${filiere.id}</td>
           <td>${filiere.libelle}</td>
           <td>${filiere.debut}</td>
           <td>${filiere.fin}</td>
           <td><a href='filiere?id=${filiere.id}'><input type='button'
						value='Modifier'></a> <a
					href='filiere?id=${filiere.id}&delete'><input type='button'
						value='Delete'></a></td>
         </tr>
         </c:forEach>
      	 </tbody>
     </table>



<div id="addFormFiliere" class="formAjout">
            <h3>Ajouter filiere</h3>

 	<form action='filiere' method='post'>
		<input type="hidden" name="tache" value="insert">Libelle <input type='text'
			name='libelle' placeholder='Saisir libelle'><br> Debut <input
			type='date' name='debut' placeholder='Saisir date debut'><br>
			<br> Fin <input
			type='date' name='fin' placeholder='Saisir date fin'><br>
		<input type='submit' value='Ajouter filiere'><br>

	</form>
        </div>

</div>


</body>
</html>

<script>

btnAddFiliere.onclick=function()
{
  addFormFiliere.style.display="block";
}

</script>
