<html>
	<head>
		<title>Main Proyects</title>
		<link rel="stylesheet" href="bootstrap.min.css">
		<style>
		.container{

			margin-bottom:20px;
		}
		</style>
		<script type="text/javascript">
		
		</script>
	</head>
 	<body>
	<div class="container">
		<nav class="navbar navbar-light bg-light">
			<a class="navbar-brand">Sistema Gestión de Proyectos</a>
			<form class="form-inline" action="https://www.google.com/search"  method="get">
				<input class="form-control mr-sm-2" type="search" placeholder="Google" aria-label="Search" name="q">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</nav>
		<div class="">
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
							echo "<a href='{$x}' class='list-group-item list-group-item-action list-group-item-primary'>{$x}</a>";
							}
						}
					}
					$URL=$_SERVER['PHP_SELF']
					?>
					</div>
				</div>
				<div class="col-sm">
				<div class="jumbotron jumbotron-fluid">
					<div class="container">
						<h1><p>Escribe el nombre del nuevo proyecto que vas a  agregar y preciona crear </p></h1>
						<form>
							<div class="form-group">
								<label for="inp_name_pro">Nombre </label>
								<input type="text" class="form-control" id="inp_name_pro" aria-describedby="proyectHelp" placeholder="ej.Proyecto Nº 1">
							</div>
							<button type="submit" class="btn btn-primary">Crear</button>
						</form>
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
	<form action="https://www.google.com/search?q=" method="get"></form>
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













