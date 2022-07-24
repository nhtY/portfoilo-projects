<?php
header("Content-Type: application/json; charset=UTF-8");
$obj = json_decode($_GET["x"], false);

$servername = "localhost:3340";
$username = "root";
$password = "";
$dbname = "machinedb";

try {
	$conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
	$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	
	// prepare sql and bind parameters
	$stmt = $conn->prepare("SELECT * FROM machinestatus 
							WHERE stopBegin >= :stopBegin AND stopEnd <= :stopEnd 
							ORDER BY name;");
	
	
	$stmt->bindParam(':stopBegin', $rangeStart);
	$stmt->bindParam(':stopEnd', $rangeEnd);

	// select rows
	$rangeStart = $obj->rangeStart;
	$rangeEnd = $obj->rangeEnd;

	$stmt->execute();
  
	// set the resulting array to associative
	$result = $stmt->setFetchMode(PDO::FETCH_ASSOC);
	$outp = $stmt->fetchAll();
	echo json_encode($outp);

  } catch(PDOException $e) {
	echo "Error: " . $e->getMessage();
	
  }
  $conn = null;

?>
