<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.Map.Entry"%>
<%@ page import="java.io.ObjectInputStream" %>
<html lang="en">
<!-- Questa pagina serve a selezionare i contesti di utilizzo del sistema (uno almeno).
		Una volta selezionati i contesti tramite un form, la richiesta viene gestita dalla servlet ServeltGestioneRichiesta.java. 
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
				<h1 class= "display-4">Indicate the context of consumption of music </h1>
				<h3>(at least one)</h3>
			</div>
		</div>
		
		<form action="../gestioneRichiesta" method="get" name="form">
			<% String tempo = request.getParameter("tempo").trim();%>
			
			<script type="text/javascript">
			function checkButton() {
				mood = document.form.mood.value;//  good/bad
				activity = document.form.activity.value;//  relax/sport/focus/home/driving
				company = document.form.company.value;//    alone/friends/couple

				tasto = document.getElementById('infoUtente');
				console.log(tasto.disabled);
				//DEVE ESSERE SELEZIONATO ALMENO 1 DELLE 3 COMBINAZIONI
				if (mood == 0 && company == 0 && activity == 0) {
					tasto.disabled = true;
				} else {
					tasto.disabled = false;
				}
			}
			</script>
		
			<div class="row justify-content-md-center text-center">

				<div class="col-md-auto">
					<div class="form-group">
						<label for="mood"><h4>Your mood</h4></label>
						<select class="form-control" name="mood" onchange="checkButton()">
							<option value="0">Indifferent</option>
							<option value="1">Good</option>
							<option value="2">Bad</option>
						</select>
					</div>
				</div>
			
				<div class="col-md-auto">
					<div class="form-group">
						<label for="activity"><h4>Your activity</h4></label>
						<select class="form-control" name="activity" onchange="checkButton()">
							<option value="0">Indifferent</option>
							<option value="3">Relax</option>
							<option value="4">Sport</option>
							<option value="5">Focus</option>
                            <option value="6">Home</option>
                            <option value="7">Driving</option>
						</select>
					</div>
				</div>
			
				<div class="col-md-auto">
					<div class="form-group">
						<label for="company"><h4>Your company</h4></label>
						<select class="form-control" name="company" onchange="checkButton()">
							<option value="0">Indifferent</option>
							<option value="8">Alone</option>
							<option value="9">Friends</option>
                            <option value="10">Couple</option>
						</select>
					</div>
				</div>
			
			</div>
			<br><br><br>
			<div class="row justify-content-md-center text-center">
				<div class="col"> 
					<input type="hidden" id="tempo" name="tempo" value="<%out.println(tempo);%>"></input>
					<button type="submit" id="infoUtente" class="btn btn-primary btn-lg" disabled>Suggest! </button>
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
