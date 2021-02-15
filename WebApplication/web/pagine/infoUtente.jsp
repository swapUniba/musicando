<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<!-- Questa pagina contiene un form utile a raccogliere alcune caratteristiche dell’utente, ovvero:
		 Sesso; Età; Titolo di studio; Frequenza uscite settimanali; Utilizzo di recommender systems.
		Alla pressione del submit, la richiesta viene gestita dalla servlet ServletGestioneInfoUtente.java.
	-->
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<title>Musicando</title>
	<link href="../css/style.css" rel="stylesheet">
</head>

<body>	<!-- onload="controlloGenerale()" -->
	<nav class="navbar navbar-light bg-dark">
		<a class="navbar-brand text-light" href="#">
			<img src="../movie2.png" width="30" height="30" alt=""> Musicando
		</a>
	</nav>
	
	<div class="container-fluid bg-light">
		<div class="row text-center">
			<div class="col">
				<h1 class= "display-4">Your profile</h1>
			</div>
		</div>
		
		<form action="../infoUtente" method="get">
			<div class="row justify-content-md-center text-center">

				<div class="col-md-auto">
					<div class="form-group">
						<label for="eta"><h4>Age</h4></label>
						<select class="form-control" name="eta" required>
							<option value="">Open this selection menu</option>
							<option value="1"><18</option>
							<option value="2">18-25</option>
							<option value="3">26-35</option>
							<option value="4">36-50</option>
							<option value="5">>50</option>
						</select>
					</div>
				</div>
			
				<div class="col-md-auto">
					<div class="form-group">
						<label for="genere"><h4>Gender</h4></label>
						<select class="form-control" name="genere" required>
							<option value="">Open this selection menu</option>
							<option value="uomo" default>Man</option>
							<option value="donna">Woman</option>
						</select>
					</div>
				</div>
			
				<div class="col-md-auto">
					<div class="form-group">
						<label for="titoloStudio"><h4>Education</h4></label>
						<select class="form-control" name="titoloStudio" required>
							<option value="">Open this selection menu</option>
							<option value="6" default>High School</option>
							<option value="7">Bachelor's degree</option>
							<option value="8">Master's degree</option>
							<option value="9">Ph.D</option>
							<option value="10">Other</option>
						</select>
					</div>
				</div>
			</div>
			
			<div class="row justify-content-md-center text-center">
			
				<div class="col-md-auto">	
					<div class="form-group">
						<label for="frequenza"><h4>How frequently do you listen to music?</h4></label>
						<select class="form-control" name="frequenza" required>
							<option value="">Open this selection menu</option>
							<option value="11" default>None or once a week</option>
							<option value="12">Twice a week</option>
							<option value="13">5 to 7 times a week</option>
						</select>
					</div>
				</div>
			
				<div class="col-md-auto">
					<div class="form-group">
						<label for="recSys"><h4>Have you ever used a recommender system?</h4>
						<h6>(like Amazon, YouTube, Netflix, Spotify)</h6></label>
						<select class="form-control" name="recSys" required>
							<option value="">Open this selection menu</option>
							<option value="14" default>Yes</option>
							<option value="15">No</option>
						</select>
					</div>
				</div>
				
			</div>
			
			<div class="row justify-content-md-center text-center">
				<div class="col"> 
					<button type="submit" id="infoUtente" class="btn btn-primary btn-lg">Continue </button>
				</div>
			</div>
			
		</form>
		<br>
	</div>
	
	
<footer> 
	<div class="footer bg-info">
		<h2 align="center">Course IIA & NLP - Computer Science UniBA - 2021</h2>
		<p class="lead" align="center">Student: <b>Spillo Giuseppe</b></p>
		<p class="lead" align="center">Professor: <b>Semeraro Giovanni</b></p>
		<p class="lead" align="center">Tutor: dott. <b>Cataldo Musto</b></p>
		
		<div class="d-flex justify-content-center">
			<div> <a href="https://www.uniba.it/"><img src="../Logo_Uniba.png"></a> </div>
			<div> <a href="http://www.di.uniba.it/~swap/"><img height="60" src="../swap.PNG"></a></div>
		</div>
		<br>
	</div>
</footer>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>	
</body>

</html>
