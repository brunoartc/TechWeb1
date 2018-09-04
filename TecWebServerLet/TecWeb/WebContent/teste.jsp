<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<style media="screen">
.quadrado {
	height: 100px;
	width: 100px;
	background-color: blue;
}
</style>

<head>
<title>TecWeb JS+HTML+BOOTSTRAP+CSS</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="https://rawgit.com/mattyork/fuzzy/master/fuzzy-min.js"></script>
<script type="text/javascript">
	var toFuzzy = []

	function addToDatabase(id, title, content, update) {
		var card = {}
		card.id = id;
		card.title = title;
		card.content = content;
		card.updateDate = update;

		toFuzzy.push(card)
		console.log(toFuzzy);

	}

	function fuzzuezauza() {
		var searchfor = document.getElementById('textopraprocura').value;
		// console.log(typeof searchfor);
		var options = {
			extract : function(element) {
				return element.title;
			}
		};
		// // Filter!
		var filtered = fuzzy.filter(searchfor, toFuzzy, options);
		console.log(filtered);

		// TODO: colocar todos os cards como hidden e passar pelos ids para mostrar eles um por um

	}

	function addNote() {
		var cardsDiv = document.getElementById('cards');
		console.log(cardsDiv.lastChild);
		var divtest = document.getElementById('padrao').cloneNode(true);
		divtest.id = toFuzzy.length +1
		addToDatabase(divtest.id, divtest.querySelector("#title").innerHTML,
				divtest.querySelector("#content").innerHTML, divtest
						.querySelector("#update").innerHTML)
		cardsDiv.appendChild(divtest);
	}
</script>
</head>

<body>

	<div class="container mt-3">
		<div class="d-flex flex-wrap justify-content-around"></div>
		<div class="row">
			<div class="col-lg-12">
				<h3 class="one">Text</h3>
				<div class="float-right">
					<input type="text" name="" value="" id="textopraprocura">
					<button class="btn btn-primary" type="button" name="button"
						onclick="fuzzuezauza()">Butaum2</button>
				</div>
				<button class="btn btn-secondary float-left" onclick="addNote()">Button</button>
			</div>
		</div>

	</div>
	<div class="card-columns" id='cards'>
		<!-- Mais cards em https://getbootstrap.com/docs/4.0/components/card/-->
		<div class="card" id='padrao'>
			<div class="card-body">
				<h5 class="card-title" id="title">Card title</h5>
				<p class="card-text" id="content">This is a wider card with
					supporting text below as a natural lead-in to additional content.
					This card has even longer content than the first to show that equal
					height action.</p>
				<p class="card-text" id="update">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
	</div>

</body>

</html>