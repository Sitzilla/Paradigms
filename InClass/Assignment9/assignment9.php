<!DOCTYPE html>
<html>

	<?php
	if (empty($_REQUEST)) {

	echo "<head>";
		echo "<title> Assignment 9: no query string</title>";
	echo "</head>";
	echo "<body>";
		
		echo "Hello world!<br>";
		echo "Evan Sitzes's assignment 9.<br>";
		echo "The query string is null.<br>";
		phpinfo();

	echo "</body>";
	} else {

	echo "<head>";
		echo "<title> Assignment 9: with a query string</title>";
	echo "</head>";

	echo "<body>";
		echo "Hello world!<br>";
		echo "Evan Sitzes's assignment 9.<br>";
		echo "The query string is ", var_dump($_REQUEST);
		phpinfo();
	echo "</body>";	
	}
	?>

</html>
