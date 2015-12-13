<?php
session_start();
?>

<!DOCTYPE html>


<?php

	$accountsFile = fopen("assignment11-account-info.txt", "a") or die("unable to open file!");
	$errorMessage = "";
	if (isset($_GET['submit'])) {
		$errorOccured = false;

		if ($_GET['setUsername'] == null)  {
			$errorMessage = "No username set";
			$errorOccured = true;
		}

		if ($_GET['setPassword'] == null)  {
			$errorMessage = "No password set";
			$errorOccured = true;
		}

		if ($_GET['setFirstname'] == null)  {
			$errorMessage = "No first name set";
			$errorOccured = true;
		}

		if ($_GET['setLastname'] == null)  {
			$errorMessage = "No last name set";
			$errorOccured = true;
		}

		if (usernameExists($_GET['setUsername'])) {
			$errorMessage = "Username already exists";
			$errorOccured = true;
		}

		if (!$errorOccured) {
			$_SESSION['username'] = $_GET['setUsername'];
			$_SESSION['password'] = $_GET['setPassword'];
			$_SESSION['firstName'] = $_GET['setFirstname'];
			$_SESSION['lastName'] = $_GET['setLastname'];
			$_SESSION['background'] = "white";
			$_SESSION['pageTitle'] = "Welcome to Evan Sitzes's Assignment 11 PHP page!";
			$_SESSION['imageLink'] = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Stick_Figure.svg/170px-Stick_Figure.svg.png";
			fwrite($accountsFile, $_SESSION['username'] . ";" . $_SESSION['password'] . ";" .
				$_SESSION['firstName'] . ";" . $_SESSION['lastName'] . ";" . 
				$_SESSION['background'] . ";" . $_SESSION['pageTitle'] .";" . 
				$_SESSION['imageLink'] . "\n");
		}
	}

	function usernameExists($username) {
		$contents = file("assignment11-account-info.txt");

		foreach($contents as $line) {
			$line = trim($line);
			if (strlen($line) > 0) {
				$arr = explode(";", $line);
				if ($arr[0] == $username) {
					return true;
				}			
			}
		}
		return false;
	}


	if (isset($_GET['login'])) {
		$errorOccured = false;
		$contents = file("assignment11-account-info.txt");

		if ($_GET['loginUsername'] == null)  {
			$errorMessage = "No username set";
			$errorOccured = true;
		}

		if ($_GET['loginPassword'] == null)  {
			$errorMessage = "No password set";
			$errorOccured = true;
		}

		if (!$errorOccured) {
			// Checks that password and username are correct
			$errorOccured = true;
			foreach($contents as $line) {
				$line = trim($line);
				if (strlen($line) > 0) {
					$arr = explode(";", $line);
					if ($arr[0] == $_GET['loginUsername'] && 
					    $arr[1] == $_GET['loginPassword']) {
						$_SESSION['username'] = $arr[0];
						$_SESSION['password'] = $arr[1];
						$_SESSION['firstName'] = $arr[2];
						$_SESSION['lastName'] = $arr[3];
						$_SESSION['background'] = $arr[4];
						$_SESSION['pageTitle'] = $arr[5];
						$_SESSION['imageLink'] = $arr[6];
						$errorOccured = false;
					}			
				}
			}
			if ($errorOccured) {
				$errorMessage = "Username or password incorrect";
			}
		}
	}

	if (isset($_GET['editAccountInfo'])) {
		$_SESSION['firstName'] = $_GET['setFirstname'];
		$_SESSION['lastName'] = $_GET['setLastname'];
		$_SESSION['background'] = $_GET['setBackground'];
		$_SESSION['pageTitle'] = $_GET['setTitle'];
		$_SESSION['imageLink'] = $_GET['setImagelink'];

		editUserInformation();
	}

	function editUserInformation() {
		global $accountsFile;
		$newFile = array();
		$contents = file("assignment11-account-info.txt");

		foreach($contents as $line) {
			$line = trim($line);
			if (strlen($line) > 0) {
				$arr = explode(";", $line);
				if ($arr[0] != $_SESSION['username']) {
					$newFile[] = $line . "\n";
				}			
			}
		}
		$newFile[] = $_SESSION['username'] . ";" . $_SESSION['password'] . ";" .
				$_SESSION['firstName'] . ";" . $_SESSION['lastName'] . ";" . 
				$_SESSION['background'] . ";" . $_SESSION['pageTitle'] .";" . 
				$_SESSION['imageLink'] . "\n";
		
		file_put_contents("assignment11-account-info.txt", $newFile);
	}
	
	fclose($accountsFile);

	if (isset($_GET['logout'])) {
		session_unset();
		session_destroy();
	}

	if (isset($_SESSION['username'])) {

?>

<html>
	<head> 
		<title> <?=$_SESSION['pageTitle']?> </title>
	</head>

	<body bgcolor=<?=$_SESSION['background']?>>
		<h1><?=$_SESSION['pageTitle']?></h1>
		<p>Welcome <?=$_SESSION['firstName']?></p>
		<br><br>

		<img src=<?=$_SESSION['imageLink']?> height="250" width="200" alt="Profile Image">
		<br>

		<form action="assignment11.php" id="logout" method="get">
			<input name="logout" type="submit" value="Logout">		
		</form>
		
		<hr>

		<form action="assignment11.php" id="editAccountInformation" method="get">
			First name:<br>
			<input type="text" name="setFirstname" value="<?php echo htmlentities($_SESSION['firstName']); ?>">
			<br>
			Last name:<br>
			<input type="text" name="setLastname" value="<?php echo htmlentities($_SESSION['lastName']); ?>">
			<br>
			Background color:<br>
			<input type="text" name="setBackground" value="<?php echo htmlentities($_SESSION['background']); ?>">
			<br>
			Title:<br>
			<input type="text" name="setTitle" value="<?php echo htmlentities($_SESSION['pageTitle']); ?>">
			<br>
			Image:<br>
			<input type="text" name="setImagelink" value="<?php echo htmlentities($_SESSION['imageLink']); ?>">
			<br>
			<input name="editAccountInfo" type="submit" value="Submit">		
		</form>

		
	</body>

</html>

<?php
} else {
?>

<html>
	<head>
		<title> Welcome to Evan Sitzes's Assignment 11 PHP page!</title>
	</head>

	<body>
		<h1> Welcome to Evan Sitzes's Assignment 11 PHP page!</h1>

		<p><font color="red"><?=$errorMessage?></font></p>

		<form action="assignment11.php" id="loginAccountForm" method="get">
			Account Login:
			<br>
			Username:
			<input type="text" name="loginUsername">
			<br>
			Password:
			<input type="text" name="loginPassword">
			<br>
			<input type="submit" name="login" value="Submit">		
		</form>

		<hr>

		<form action="assignment11.php" id="createAccountForm" method="get">
			Create new account:
			<br>
			Username:
			<input type="text" name="setUsername">
			<br>
			Password:
			<input type="text" name="setPassword">
			<br>
			First name:
			<input type="text" name="setFirstname">
			<br>
			Last name:
			<input type="text" name="setLastname">
			<br>
			<input type="submit" name="submit" value="Submit">		
		</form>

	</body>

</html>

<?php
}
?>
