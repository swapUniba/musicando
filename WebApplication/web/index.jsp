<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<html lang="en">
<!--Questa pagine contiene una breve descrizione di ciò che effettua il framework, 
	e contiene un bottone “Inizia” che avvia l’esecuzione e che rimanda alla pagina infoUtente.jsp.-->
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<title>Musicando</title>
	<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-light bg-dark">
  		<a class="navbar-brand text-light" href="#">
   			<img src="movie2.png" width="30" height="30" alt=""> Musicando
 	 	</a>
	</nav>
	<div class="container-fluid bg-light">
		<div class="row text-center">
			<div class="col">
				<h1 class= "display-4">Musicando</h1>
				<img src="movie.png" width="160" height="160" alt="">
				<!--<img src= "movie.png" class="img-fluid" alt="Responsive image">-->
			</div>
		</div>
		<div class="row text-center">
			<div class="col">	
				<p class="lead">
				<b>Musicando</b> will recommend you a music album you will like along with a
				justification based on the <b>context</b> of consumption of the item. 
				<br>
				In the following, you will provide information about your current
				context and you will receive a suitable <b>recommendation</b>
				and a <b>context-aware natural language justification</b>. 
				<br>
				You will be asked to <b>evaluate</b> the justification and 
				to select your preferred justification style. 
				<br>
				Thanks for your support. Enjoy the webapp!
				</p>
			</div>
		</div>
		<div class="row text-center">
			<div class="col">
				<button type="button" onclick="window.location='pagine/infoUtente.jsp'"
					class="btn btn-primary btn-lg">Start!
				</button>
			</div>
		</div>	
		<br>		
	</div>
	
<footer> 
	<div class="footer bg-info">
		<h2 align="center">Course IIA & NLP - Computer Science UniBA - 2021</h2>
		<p class="lead" align="center">Student: <b>Spillo Giuseppe</b></p>
		<p class="lead" align="center">Professor: <b>Semeraro Giovanni</b></p>
		<p class="lead" align="center">Tutor: dott. <b>Cataldo Musto</b></p>
		
		<div class="d-flex justify-content-center">
			<div> <a href="https://www.uniba.it/"><img src="Logo_Uniba.png"></a> </div>
			<div> <a href="http://www.di.uniba.it/~swap/"><img height="60" src="swap.PNG"></a></div>
		</div>
		<br>
	</div>
</footer>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>
