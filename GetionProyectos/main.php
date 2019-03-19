<html>
	<head>
		<title>Main Proyects</title>
		<link rel="stylesheet" href="bootstrap.min.css">
		<style>
		.container{ 
			margin-top:10px;
		}
		</style>
		<script type="text/javascript">
		
		function action(value){
		var x = document.forms["crear"]["name_p"].value;
		if (x.length == 0) { 
			document.getElementById("alert").innerHTML = "<div class='alert alert-warning' role='alert'>Ingresa un Nombre De Poyecto</div>";
			return;
		  } else {
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {
			  if (this.readyState == 4 && this.status == 200) {
				console.log(this.responseText);
				document.getElementById("alert").innerHTML = "<div class='alert alert-success' role='alert'>"+this.responseText+"</div>";
			  }
			};
			xmlhttp.open("POST", "pr2.php", true);
			xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xmlhttp.send("name_p=" + x);
		  }
	     }
		</script>
	</head>
 	<body>
	<div class="container">
		<nav class="navbar navbar-light bg-light">
			<a class="navbar-brand">Sistema Gestión de Proyectos</a>
			<form class="form-inline" action="https://www.google.com/search"  method="get" target="_blanck">
				<input class="form-control mr-sm-2" type="search" placeholder="Google" aria-label="Search" name="q">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Search</button>
			</form>
		</nav>
		<div id="alert"></div>
		<div class="container">
			<div class="row">
				<div class="col-sm">
					<!-- <h3>Lista</h3> -->
					<div class="list-group" >
					<?php
					$pasth=__DIR__;
					$ficheros1  = scandir($pasth);
					foreach ($ficheros1 as $x){
						if(is_dir($x)){
							if("."==$x || ".."==$x){
							
							}else{
							print "<a href='{$x}' class='list-group-item list-group-item-action list-group-item-primary'>{$x}</a>";
							}
						}
					}
					$URL=$_SERVER['PHP_SELF']
					?>
					</div>
				</div>
				<div class="col-sm">
					<div class="mx-auto">
						<div class="jumbotron jumbotron-fluid">
							<div class="container">
								<h1><p>Escribe el nombre del nuevo proyecto que vas a  agregar y preciona crear </p></h1>
								<form name="crear">
									<div class="form-group">
										<label for="inp_name_pro">Nombre </label>
										<input type="text"  class="form-control" name="name_p" aria-describedby="proyectHelp" placeholder="ej.Proyecto Nº 1">
									</div>	
								</form>
								<button class="btn btn-primary" onclick="action('borrar')">Crear</button>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- <div class="container text-center">
			<div class="row">
				<div class="col-sm">
					<button type="button" class="btn btn-primary">Crear</button>
				</div>
				<div class="col-sm">
					<button type="button" class="btn btn-warning">Editar</button>
				</div>
				<div class="col-sm">
					<button type="button" class="btn btn-danger">Borrar</button>
				</div>
			</div>
		</div> -->
	</div>
	</body>
</html>



<!--
// if (!empty($_SERVER['HTTPS']) && ('on' == $_SERVER['HTTPS'])) {
			// 	$uri = 'https://';
			// } else {
			// 	$uri = 'http://';
			// }
			// $uri .= $_SERVER['HTTP_HOST'];
			// header('Location: '.$uri.'/dashboard/');
			// exit;
-->
<!-- Something is wrong with the XAMPP installation :-( -->













