<?php

	include "koneksi.php";
	
	$id_lantai = $_GET['id_lantai'];
	
	$query = mysql_query("SELECT * FROM kategori WHERE id_lantai = '$id_lantai'");	

	$response = array();
	
	while($hasil = mysql_fetch_assoc($query))	{
			$response[] = $hasil;
	}
	
	$data = json_encode($response);
	echo "{\"list_kategori\":" .$data ."}";

?>