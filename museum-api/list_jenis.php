<?php

	include "koneksi.php";
	
	$query = mysql_query("SELECT * FROM jenis_koleksi");	

	$response = array();
	
	while($data = mysql_fetch_assoc($query))
	{
			$response[] = $data;
	}

	$response['success'] = true;


	echo json_encode($response, JSON_PRETTY_PRINT);


?>