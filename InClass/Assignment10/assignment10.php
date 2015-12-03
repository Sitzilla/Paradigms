<!DOCTYPE html>

<?php

	$first = true;
	$second = false;
	$third = false;

	$firstname = null;
	$lastname = null;
	$guess = null;

	if (isset($_POST['hiddenLastname'])) {
		$first = false;
		$second = true;
		$third = false;
		$lastname = $_POST['hiddenLastname'];
	}
	
	if (isset($_REQUEST['firstname'])) {
		$first = false;
		$second = true;
		$firstname = $_REQUEST['firstname'];
		$lastname = $_REQUEST['lastname'];
	}

	if (isset($_POST['hiddenNumber'])) {
		$number = $_POST['hiddenNumber'];
	} else {
		$number = rand(1, 5);
	}

	if (isset($_POST['guess'])) {
		$guess = $_POST['guess'];
	}

	if ($guess == $number) {
		$first = false;
		$second = false;
		$third = true;
	}

	if ($first == true) {

?>
<html>

	<body>
		<form action="assignment10.php" id="myform" method="get" onsubmit="return checkForm()">
			First name:<br>
			<input type="text" name="firstname" value="Evan">
			<br>
			Last name:<br>
			<input type="text" name="lastname" value="Sitzes">
			<br>
			Email:<br>
			<input type="text" name="email" value="esitzes42@hotmail.com">
			<br>
			<input type="submit" value="Submit">		
		</form>
	
	
		<script>
			var form = document.getElementById("myform");

			function checkForm() {
				
				var firstname = form.elements["firstname"].value;
				if (firstname == null || firstname == "") {
					alert("No First Name entered");
					return false;
				}
				
				var lastname = form.elements["lastname"].value;
				if (lastname == null || lastname == "") {
					alert("No Last Name entered");
					return false;
				}
				
				var email = form.elements["email"].value;
				if (!(/(.+)@(.+){2,}\.(.+){2,}/.test(email))) {
					alert("Email was not entered correctly");
					return false;
				}

				return true;
			}


		</script>
	</body>


</html>

<?php
}

	if ($second == true) {

?>

<html>

	<body>
		<?php

		if ($firstname != null) {
		?>
			<p> Hi <?=$firstname, " " , $lastname?>!</p>
		<?php
		} else {
		?>

		<p> Incorrect guess of <?=$guess?>.</p>
		<?php
		}
		?>

		<form action="assignment10.php" id="myguessform" method="post">
			Guess a number between 1 and 5:<br>
			<input type="text" name="guess">
			<br>
			<input type="hidden" name="hiddenLastname" value=<?=$lastname?>>
			<input type="hidden" id="hiddenNum" name="hiddenNumber" value=<?=$number?>>
			<input type="submit" value="Submit">		
		</form>
	</body>


</html>

<?php

}

	if ($third == true) {

?>

<html>
	<body>
		<p>Good job! You guessed correctly</p>
	</body>
</html>

<?php

}

?>
